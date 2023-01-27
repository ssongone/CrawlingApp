package com.ddaddu.CrawlingApp.Service;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelService {
    XSSFWorkbook workbook = new XSSFWorkbook(); // 엑셀 쓰기전 workbook 지정
    XSSFSheet sheet = workbook.createSheet("book_sheet");

    public void makeExcelFile(String filePath) {

    }


}
