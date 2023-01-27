package com.ddaddu.CrawlingApp.Domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ImgUrls { // 일급 컬렉션으로 만들기~!
    private List<ImgUrl> imgUrls;
    public ImgUrls(List<ImgUrl> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getMainImgUrl() {
        return imgUrls.stream()
                .filter(ImgUrl::isMainImg)
                .map(ImgUrl::getImgUrl)
                .findAny()
                .orElse("");
    }

    //추가이미지는 최대 9개까지 등록할 수 있습니다. 각각의 추가이미지는 줄바꿈(엔터)으로 구분합니다.
    public String getSubImgUrl() {
        String subImgUrl = "";
        List<String> subImages = imgUrls.stream()
                .filter(url -> url.isMainImg() == false)
                .map(ImgUrl::getImgUrl)
                .limit(9)
                .collect(Collectors.toList());

        for (String str : subImages) {
            subImgUrl = subImgUrl + str + "\n";
        }

        return subImgUrl;
    }


}
