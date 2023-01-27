package com.ddaddu.CrawlingApp.Domain;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ExcelFileTest {
    String url = "https://www.amazon.co.jp/%E6%96%B0%E6%B5%B7-%E8%AA%A0/dp/4046316411/ref=sr_1_1_sspa?crid=39148EHJBV9A2&keywords=%E5%90%9B%E3%81%AE%E5%90%8D%E3%81%AF&qid=1674553337&sprefix=%E5%90%9B%E3%81%AE%E5%90%8D%E3%81%AF+%2Caps%2C175&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzNVJXNDRIOTg2SVFZJmVuY3J5cHRlZElkPUEwMjkzMTIxMUVQNVlFS1RMNzFZQSZlbmNyeXB0ZWRBZElkPUEzSUVPOTJMNlhWODNHJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==";
    String url2 = "https://www.amazon.co.jp/-/en/%E6%96%B0%E6%B5%B7-%E8%AA%A0/dp/4046321903/ref=d_pd_sbs_sccl_2_1/356-0132074-2627358?pd_rd_w=FDmhS&content-id=amzn1.sym.820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_p=820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_r=YKJT09KZRFTV68BP6556&pd_rd_wg=yJkKj&pd_rd_r=c8939c27-6103-45ed-8767-8e6a6837df46&pd_rd_i=4046321903&psc=1";
    String url3 = "https://www.amazon.co.jp/泣きたい私は猫をかぶる-角川つばさ文庫-岩佐-まもる/dp/404632015X/ref=d_pd_sbs_sccl_2_7/358-1246692-8264911?pd_rd_w=ybbRk&content-id=amzn1.sym.820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_p=820591ed-a555-4556-9bf6-5ebd5493c69e&pf_rd_r=VREHQY6G0GC49079VEAQ&pd_rd_wg=P9D7z&pd_rd_r=3cbe8fa1-651e-4dbd-b608-02c39d5f3bd4&pd_rd_i=404632015X&psc=1";

    @Test
    void 엑셀파일생성테스트() {
        List<AmazonPage> pages = new ArrayList<>();
        pages.add(new AmazonPage(url));
        pages.add(new AmazonPage(url2));
        pages.add(new AmazonPage(url3));

        ExcelFile excelFile = new ExcelFile(pages);
        excelFile.makeExcelFile();
    }
    @Test
    void 현재시간테스트() {
        ExcelFile excelFile = new ExcelFile();
        excelFile.calcCurrentTime();
    }

    
}