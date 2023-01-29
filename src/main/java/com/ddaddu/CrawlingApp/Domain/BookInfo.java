package com.ddaddu.CrawlingApp.Domain;

public class BookInfo {

    AmazonPage amazonPage;
    private String mainImgUrl;
    private String subImgUrl;
    private String productInfo;
    public BookInfo() { //테스트용
        mainImgUrl = "mainImgUrl 입니다";
        subImgUrl = "subImgUrl 입니다";
        productInfo = "상서설명 입니다";
    }

    public BookInfo(AmazonPage amazonPage) {
        this.amazonPage = amazonPage;
        mainImgUrl = amazonPage.getImgUrls().getMainImgUrl();
        subImgUrl = amazonPage.getImgUrls().getSubImgUrl();
        productInfo = amazonPage.getProductInfo();
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public String getSubImgUrl() {
        return subImgUrl;
    }

    public String getProductInfo() {
        return productInfo;
    }
}
