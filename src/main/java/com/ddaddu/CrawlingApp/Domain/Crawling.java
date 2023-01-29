package com.ddaddu.CrawlingApp.Domain;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crawling {

    private String pageUrl;
    Document document;

    List<ImgUrl> imgUrls;
    String productInfo;

    public Crawling(String pageUrl) {
        this.pageUrl = pageUrl;
        try{
            Connection conn = Jsoup.connect(pageUrl);
            document = conn.get();
        }catch (IOException e){
            e.printStackTrace();
        }
        imgUrls = makeImgUrl();
        productInfo = makeProductInfo();
    }

    public List<ImgUrl> getImgUrls() {
        return imgUrls;
    }
    public String getProductInfo() {
        return productInfo;
    }

    List<ImgUrl> makeImgUrl() {
        List<ImgUrl> tmpUrls = new ArrayList<>();
        String html = document.html();
        String[] before = html.split("mainUrl");
        for(int i = 0 ; i < before.length-1 ; i++){
            //ImgUrl url = new ImgUrl(splitUrl(before[i+1]));
            tmpUrls.add(new ImgUrl(splitUrl(before[i+1])));
        }
        setMainImg(tmpUrls,0); //기본적으로 젤 앞 이미지가 메인 이미지지만 나중에 바꿀수 있도록 함수로 만들어 놓음
        return tmpUrls;
    }

    String makeProductInfo() {
        String sum = takeProductDescription() + "<br><br>" +takeProductDetails();
        System.out.println(sum);
        return sum;
    }

    String takeProductDescription() {
        Elements elements = document.select("div[class=\"a-section a-spacing-small a-padding-base\"]");
        return "<h2>Product Description</h2>" + elements.toString();
//        Elements elements = document.select("div[class=\"a-row a-expander-container a-expander-extend-container\"]");
//                List<String> collect = elements.stream()
//                .map(str -> str.toString())
//                .map(str -> str.replace("h3","h1"))
//                .collect(Collectors.toList());
//        elements.stream()
//                .forEach(str -> System.out.println(str));

    }

    String takeProductDetails() {
        //Product Details
        Elements details = document.select("div[id=\"detailBulletsWrapper_feature_div\"] > div[id=\"detailBullets_feature_div\"]");
        return "<h2>Product Details</h2>" + details.toString();
    }


    String splitUrl(String str) {
        String lastUrl = str.substring(3);
        int lastIdx = lastUrl.indexOf("\"");
        lastUrl = lastUrl.substring(0, lastIdx);
        return lastUrl;
    }

    void setMainImg(List<ImgUrl> imgUrls, int idx) {
        if(imgUrls.size()!=0)
            imgUrls.get(idx).setMainImg(true);
    }
}
