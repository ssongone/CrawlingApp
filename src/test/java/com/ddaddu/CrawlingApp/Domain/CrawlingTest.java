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
    //String url = "https://www.amazon.co.jp/泣きたい私は猫をかぶる-角川つばさ文庫-岩佐-まもる/dp/404632015X/ref=d_pd_sbs_sccl_2_7/358-1246692-8264911?pd_rd_w=ybbRk&content-id=amzn1.sym.820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_p=820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_r=VREHQY6G0GC49079VEAQ&pd_rd_wg=P9D7z&pd_rd_r=3cbe8fa1-651e-4dbd-b608-02c39d5f3bd4&pd_rd_i=404632015X&psc=1";
    //String url = "https://www.amazon.co.jp/%E5%A4%89%E3%81%AA%E7%B5%B5-%E9%9B%A8%E7%A9%B4/dp/4575245674/ref=tmm_pap_swatch_0?_encoding=UTF8&qid=1676109533&sr=8-1";
    String url = "https://www.amazon.co.jp/BARFOUT-バァフアウト-2022年7月号-Prince-Browns/dp/4344954254/ref=sr_1_2?__mk_ja_JP=カタカナ&crid=2FTIJGAKCVR4P&keywords=barfout+バァフアウト+2022年7&qid=1675661913&sprefix=barfout+バァフアウト+2022年+%2Caps%2C216&sr=8-2";
    @Test
    void 이미지주소크롤링() {
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
    @Test
    void 메인_설명_테스트() {
        Crawling crawling = new Crawling(url);
        crawling.takeMainDescription();
    }
    @Test
    void 상세페이지디테일테스트() {
        Crawling crawling = new Crawling(url);
        crawling.takeProductDetails();
    }
    @Test
    void 상세페이지설명테스트() {
        Crawling crawling = new Crawling(url);
        crawling.takeProductDescription();
    }

    @Test
    void 상세페이지통합테스트() {
        Crawling crawling = new Crawling(url);
        System.out.println(crawling.makeProductInfo());
    }

    @Test
    void 제품명테스트() {
        Crawling crawling = new Crawling();
        crawling.connect(url);
        System.out.println(crawling.takeProductName());
    }

    @Test
    void 제품가격테스트() {
        Crawling crawling = new Crawling();
        crawling.connect(url);
        int result = crawling.takeProductPrice();
        System.out.println(result);
    }
}