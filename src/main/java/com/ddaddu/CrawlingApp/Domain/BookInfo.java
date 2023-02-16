package com.ddaddu.CrawlingApp.Domain;

public class BookInfo {

    AmazonPage amazonPage;
    private String productName;
    private int productPrice;
    private String mainImgUrl;
    private String subImgUrl;
    private String productInfo;

    final static String INTRO_IMG_HTML = "<img src=\"https://ifh.cc/v-Dz2HRp\">";


    public BookInfo() { //테스트용
        mainImgUrl = "mainImgUrl 입니다";
        subImgUrl = "subImgUrl 입니다";
        productInfo = "상세설명 입니다";
    }

    public BookInfo(AmazonPage amazonPage) {
        this.amazonPage = amazonPage;
        productName = amazonPage.getProductName();
        productPrice = amazonPage.getProductPrice();
        mainImgUrl = amazonPage.getImgUrls().getMainImgUrl();
        subImgUrl = amazonPage.getImgUrls().getSubImgUrl();
        productInfo = addImgTagToInfo(amazonPage.getProductInfo());
    }

    public String getProductName() {
        return productName;
    }
    public int getProductPrice() {
        return productPrice;
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

    private String addImgTagToInfo(String beforeInfo) {
        String afterInfo = makeImgSrcTag(mainImgUrl) + "<br><br>" + beforeInfo + "<br><br>" + INTRO_IMG_HTML;
        return afterInfo;
    }

    private String makeImgSrcTag(String url) {
        return "<img src ='" + url + "'>";
    }

}
