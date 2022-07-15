package com.discom.springmvc.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class XlsxWriter {

    public XSSFWorkbook buildExcelDocument(String dataJson, String[] columns, String[] columnskeys) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        XSSFSheet sheet = workbook.createSheet("Data Export");
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
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

        JSONParser parser = new JSONParser();
        JSONArray jArr = (JSONArray) parser.parse(dataJson);
        for (int i = 0; i < jArr.size(); ++i) {
            Row row = sheet.createRow(rowNum++);
            JSONObject jObj = (JSONObject) parser.parse(jArr.get(i).toString());
            for (int j = 0; j < columnskeys.length; j++) {
                row.createCell(j).setCellValue(jObj.get(columnskeys[j]) + "");
            }
        }

        //for(Iterator iterator = jObj.keySet().iterator(); iterator.hasNext();) {
        //  String key = (String) iterator.next();
        //  row.createCell(i).setCellValue(jObj.get(key)+"");
        //  System.out.println(key+" || "+jObj.get(key));
        //}

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }

    public XSSFWorkbook buildExcelDocument2(String dataJson, String[] columns) throws Exception {
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

        JSONParser parser = new JSONParser();
        JSONArray jArr = (JSONArray) parser.parse(dataJson);
        for (int i = 0; i < jArr.size(); ++i) {
            Row row = sheet.createRow(rowNum++);
            JSONObject jObj = (JSONObject) parser.parse(jArr.get(i).toString());
            for (int j = 0; j < columns.length; j++) {
                row.createCell(j).setCellValue(jObj.get(columns[j].toLowerCase()) + "");
            }
        }

        //for(Iterator iterator = jObj.keySet().iterator(); iterator.hasNext();) {
        //  String key = (String) iterator.next();
        //  row.createCell(i).setCellValue(jObj.get(key)+"");
        //  System.out.println(key+" || "+jObj.get(key));
        //}

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }
}
