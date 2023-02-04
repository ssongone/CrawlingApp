package com.ddaddu.CrawlingApp.Domain;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crawling {
    private Document document;
    private List<ImgUrl> imgUrls;
    private String productInfo;

    private String productName;
    private int productPrice;

    public Crawling() {}

    public Crawling(String pageUrl) {
        connect(pageUrl);
        imgUrls = makeImgUrl();
        productInfo = makeProductInfo();
        productName = takeProductName();
        productPrice = takeProductPrice();
    }

    public List<ImgUrl> getImgUrls() {
        return imgUrls;
    }
    public String getProductInfo() {
        return productInfo;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    void connect(String pageUrl) {
        try{
            Connection conn = Jsoup.connect(pageUrl);
            document = conn.get();
        }catch (IOException e){
            e.printStackTrace();
        }
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
        return sum;
    }



    String takeProductDescription() {
        Elements elements = document.select("div[class=\"a-section a-spacing-small a-padding-base\"]");
        return "<h3>Product Description</h3>" + elements.toString();
    }

    String takeProductDetails() {
        //Product Details
        Elements details = document.select("div[id=\"detailBulletsWrapper_feature_div\"] > div[id=\"detailBullets_feature_div\"]");
        return "<h3>Product Details</h3>" + details.toString();
    }

    String takeProductName() {
        return document.select("span[id=\"productTitle\"]").text();
    }

     int takeProductPrice() {
        String yenPrice = document.select("span[class=\"a-size-base a-color-price a-color-price\"]").text();
        int krwPrice = Integer.parseInt(yenPrice.replaceAll("[^0-9]",""));
        krwPrice =  (int) Math.round(krwPrice * 11 / 10.0) * 10;
        return krwPrice;
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
