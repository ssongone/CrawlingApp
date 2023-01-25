package com.ddaddu.CrawlingApp.Domain;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crawling {

    private String pageUrl;
    Document document;

    List<ImgUrl> imgUrls;

    public List<ImgUrl> getImgUrls() {
        return imgUrls;
    }

    public Crawling(String pageUrl) {
        this.pageUrl = pageUrl;
        Connection conn = Jsoup.connect(pageUrl);
        try{
            document = conn.get();
        } catch (IOException e){
            e.getMessage();
        }
        imgUrls = new ArrayList<>();
    }

    void makeImgUrl() {
        String html = document.html();
        String[] before = html.split("mainUrl");
        for(int i = 0 ; i < before.length-1 ; i++){
            //ImgUrl url = new ImgUrl(splitUrl(before[i+1]));
            imgUrls.add(new ImgUrl(splitUrl(before[i+1])));
        }
        setMainImg(0); //기본적으로 젤 앞 이미지가 메인 이미지지만 나중에 바꿀수 있도록 함수로 만들어 놓음
    }

    String splitUrl(String str) {
        String lastUrl = str.substring(3);
        int lastIdx = lastUrl.indexOf("\"");
        lastUrl = lastUrl.substring(0, lastIdx);
        return lastUrl;
    }

    void setMainImg(int idx) {
        imgUrls.get(idx).setMainImg(true);
    }
}
