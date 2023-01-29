package com.ddaddu.CrawlingApp.Domain;

import java.io.IOException;
import java.util.List;

public class AmazonPage {

    private Long id;
    private String pageUrl;
    private ImgUrls imgUrls;
    String productInfo;

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

    public void setImgUrls() {
        Crawling crawling = new Crawling(pageUrl);
        crawling.makeImgUrl();
        imgUrls = new ImgUrls(crawling.imgUrls);
    }

    public void crawlData() {
        Crawling crawling = new Crawling(pageUrl);
        imgUrls = new ImgUrls(crawling.imgUrls);
        productInfo = crawling.getProductInfo();
        System.out.println("crawling = " + crawling);
    }


}
