package com.ddaddu.CrawlingApp.Domain;

import java.util.List;

public class ImgUrls { // 일급 컬렉션으로 만들기~!
    private List<ImgUrl> imgUrls;

    public ImgUrls(List<ImgUrl> imgUrls) {
        this.imgUrls = imgUrls;
    }
}
