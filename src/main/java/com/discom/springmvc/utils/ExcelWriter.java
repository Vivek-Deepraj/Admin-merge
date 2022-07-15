package com.discom.springmvc.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;


public class ExcelWriter {

    public XSSFWorkbook buildExcelDocument(List<?> dataList, String[] columns) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        XSSFSheet sheet = workbook.createSheet("Data Export");
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        XSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
        int rowNum = 1;

//      JSONParser parser = new JSONParser();
//      JSONObject json = (JSONObject) parser.parse(dataJson);      
//      JSONArray key = json.names();
//      for (int i = 0; i < key.length (); ++i) {
//         String keys = key.getString (i); 
//         String value = json.getString (keys);
//         System.out.println(keys+" _________ "+value);
//      }

        for (Object obj : dataList) {
            Row row = sheet.createRow(rowNum++);
            Object val[] = (Object[]) obj;
            for (int i = 0; i < columns.length; i++) {
                row.createCell(i).setCellValue(val[i] + "");
            }
            //Cell dateOfBirthCell = row.createCell(2);
            //dateOfBirthCell.setCellValue("10-02-2020");
            //dateOfBirthCell.setCellStyle(dateCellStyle);
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }
}
