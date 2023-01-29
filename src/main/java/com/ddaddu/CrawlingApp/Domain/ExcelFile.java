package com.ddaddu.CrawlingApp.Domain;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ExcelFile {

    XSSFWorkbook workbook; // 엑셀 쓰기전 workbook 지정
    XSSFSheet sheet;
    static final String ORIGIN_FILE_PATH = "/Users/ssongwon/Desktop/springproject/";
    static final String ORIGIN_FILE_NAME = "1월 생활실용서 일괄.xlsx";
    static final int MAIN_IMG_COLUMN = 17; //R
    static final int SUB_IMG_COLUMN = 18;
    static final int PRODUCT_INFO_COLUMN = 19;

    List<AmazonPage> amazonPages;

    public ExcelFile() {}
    public ExcelFile(List<AmazonPage> amazonPages) {
        this.amazonPages = amazonPages;
        readOriginalFile();
    }

    void readOriginalFile() {
        try(FileInputStream fis = new FileInputStream(ORIGIN_FILE_PATH+ORIGIN_FILE_NAME)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0); //맨앞시트만 쓰니까 지정해줌
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void makeExcelFile() {
        try(FileOutputStream fos = new FileOutputStream(ORIGIN_FILE_PATH + "목록 " +calcCurrentTime()+".xlsx")) {
            fillExcel();
//            XSSFRow curRow = sheet.createRow(4);
//            curRow.createCell(MAIN_IMG_COLUMN).setCellValue(bookInfo.getMainImgUrl());
//            curRow.createCell(SUB_IMG_COLUMN).setCellValue(bookInfo.getSubImgUrl());

            workbook.write(fos); // 작업이 끝난후 해당 workbook객체를 FileOutputStream에 쓰기
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("오류오류");
        }
    }

    String calcCurrentTime() {
        LocalDate nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyMMdd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HHmmss");
        String currentTime = nowDate.format(dateTimeFormat) + nowTime.format(timeFormat);
        return currentTime;
    }

    void createCell(int order, BookInfo bookInfo) {
        XSSFRow curRow = sheet.createRow(order);
        curRow.createCell(MAIN_IMG_COLUMN).setCellValue(bookInfo.getMainImgUrl());
        curRow.createCell(SUB_IMG_COLUMN).setCellValue(bookInfo.getSubImgUrl());
        curRow.createCell(PRODUCT_INFO_COLUMN).setCellValue(bookInfo.getProductInfo());
    }

    void fillExcel() {
        for (int i = 0; i < amazonPages.size(); i++) {
            AmazonPage page = amazonPages.get(i);
            BookInfo bookInfo = new BookInfo(page);
            createCell(i + 3, bookInfo);
        }
// indexOf 함수가 비효율적인 거 같아서 스트림말고 for문을 썼다.
//        amazonPages.stream()
//                .forEach(page -> {
//                    BookInfo bookInfo = new BookInfo(page);
//                    createCell(amazonPages.indexOf(page)+3, bookInfo);
//                });

    }
}
