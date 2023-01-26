package com.ddaddu.CrawlingApp.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelFileTest {

    @Test
    void 엑셀파일생성테스트() {
        ExcelFile excelFile = new ExcelFile();
        excelFile.fileOpen();
    }

}