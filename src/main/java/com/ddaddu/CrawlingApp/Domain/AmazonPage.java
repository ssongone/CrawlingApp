package com.ddaddu.CrawlingApp.Domain;

import java.io.IOException;
import java.util.List;

public class AmazonPage {

    private Long id;
    private String pageUrl;
    private ImgUrls imgUrls;


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

    public void setImgUrls() throws IOException {
        Crawling crawling = new Crawling(pageUrl);
        crawling.makeImgUrl();
        imgUrls = new ImgUrls(crawling.imgUrls);
    }



}
