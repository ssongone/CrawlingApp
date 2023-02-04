package com.ddaddu.CrawlingApp.Domain;

import java.io.IOException;
import java.util.List;

public class AmazonPage {

    private Long id;
    private String pageUrl;
    private ImgUrls imgUrls;
    String productInfo;
    String productName;
    int productPrice;

    public AmazonPage(){}
    public AmazonPage(String pageUrl) {
        this.pageUrl = pageUrl;
        crawlData();
    }

    public ImgUrls getImgUrls() {
        return imgUrls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
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

    public void crawlData() {
        Crawling crawling = new Crawling(pageUrl);
        imgUrls = new ImgUrls(crawling.getImgUrls());
        productInfo = crawling.getProductInfo();
        productName = crawling.getProductName();
        productPrice = crawling.getProductPrice();
    }


}
