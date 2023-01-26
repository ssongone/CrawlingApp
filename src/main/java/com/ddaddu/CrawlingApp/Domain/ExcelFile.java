package com.ddaddu.CrawlingApp.Domain;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile {


    XSSFWorkbook workbook = new XSSFWorkbook(); // 엑셀 쓰기전 workbook 지정
    XSSFSheet sheet = workbook.createSheet("test");

    public void fileOpen() {
        String excel_filePath = "///Users/ssongwon/Desktop/springproject/babo.xlsx"; // 엑셀 파일 경로 지정

        try(FileOutputStream fos = new FileOutputStream(excel_filePath)) { //false가 기본값 기존파일내용지워짐, true면 기존파일에 추가
            writeText("메롱~");
            workbook.write(fos); // 작업이 끝난후 해당 workbook객체를 FileOutputStream에 쓰기
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("오류오류");
        }
    }

    void writeText(String str) {
        XSSFRow curRow;
        curRow = sheet.createRow(0);
        curRow.createCell(1).setCellValue(str);
    }



}
