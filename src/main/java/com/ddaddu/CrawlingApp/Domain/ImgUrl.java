package com.ddaddu.CrawlingApp.Domain;

public class ImgUrl {
    private String imgUrl;
    private boolean isMainImg;
    public ImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        isMainImg = false;
    }

    public boolean isMainImg() {
        return isMainImg;
    }

    public void setMainImg(boolean mainImg) {
        isMainImg = mainImg;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void printData() {
        System.out.print("주소는 : " + getImgUrl());
        System.out.println("//   대표이미지 : " + isMainImg());
    }
}
