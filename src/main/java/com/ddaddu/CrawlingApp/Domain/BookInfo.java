package com.ddaddu.CrawlingApp.Domain;

import java.util.Optional;

public class BookInfo {

    AmazonPage amazonPage;
    private String mainImgUrl;
    private String subImgUrl;

    public BookInfo() { //테스트용
        mainImgUrl = "mainImgUrl 입니다";
        subImgUrl = "subImgUrl 입니다";
    }

    public BookInfo(AmazonPage amazonPage) {
        this.amazonPage = amazonPage;
        mainImgUrl = amazonPage.getImgUrls().getMainImgUrl();
        subImgUrl = amazonPage.getImgUrls().getSubImgUrl();
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public String getSubImgUrl() {
        return subImgUrl;
    }
}
