package com.ddaddu.CrawlingApp.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrawlingTest {


    //String url = "https://www.amazon.co.jp/%E6%96%B0%E6%B5%B7-%E8%AA%A0/dp/4046316411/ref=sr_1_1_sspa?crid=39148EHJBV9A2&keywords=%E5%90%9B%E3%81%AE%E5%90%8D%E3%81%AF&qid=1674553337&sprefix=%E5%90%9B%E3%81%AE%E5%90%8D%E3%81%AF+%2Caps%2C175&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzNVJXNDRIOTg2SVFZJmVuY3J5cHRlZElkPUEwMjkzMTIxMUVQNVlFS1RMNzFZQSZlbmNyeXB0ZWRBZElkPUEzSUVPOTJMNlhWODNHJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==";
    //String url = "https://www.amazon.co.jp/-/en/%E6%96%B0%E6%B5%B7-%E8%AA%A0/dp/4046321903/ref=d_pd_sbs_sccl_2_1/356-0132074-2627358?pd_rd_w=FDmhS&content-id=amzn1.sym.820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_p=820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_r=YKJT09KZRFTV68BP6556&pd_rd_wg=yJkKj&pd_rd_r=c8939c27-6103-45ed-8767-8e6a6837df46&pd_rd_i=4046321903&psc=1";
    String url = "https://www.amazon.co.jp/泣きたい私は猫をかぶる-角川つばさ文庫-岩佐-まもる/dp/404632015X/ref=d_pd_sbs_sccl_2_7/358-1246692-8264911?pd_rd_w=ybbRk&content-id=amzn1.sym.820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_p=820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_r=VREHQY6G0GC49079VEAQ&pd_rd_wg=P9D7z&pd_rd_r=3cbe8fa1-651e-4dbd-b608-02c39d5f3bd4&pd_rd_i=404632015X&psc=1";
    @Test
    void 이미지주소크롤링() throws IOException {
        Crawling crawling = new Crawling(url);
        crawling.makeImgUrl();
        crawling.getImgUrls().stream()
                .forEach(ImgUrl::printData);

    }
    @Nested
    @DisplayName("ImgUrls 메소드")
    class imgUrlsTest {
        AmazonPage amazonPage = new AmazonPage(url);
        @Test
        void 메인이미지주소출력(){
            ImgUrls imgUrls = amazonPage.getImgUrls();
            System.out.println(imgUrls.getMainImgUrl());
        }
        @Test
        void 서브이미지주소출력(){
            ImgUrls imgUrls = amazonPage.getImgUrls();
            System.out.println(imgUrls.getSubImgUrl());
        }
    }

}