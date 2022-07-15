package com.discom.springmvc.utils;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.Discomschedulemaster;
import com.discom.springmvc.pojo.Portfoliomaster;
import com.discom.springmvc.pojo.Rldcdownloads;
import com.discom.springmvc.pojo.Rldcsetting;
import com.discom.springmvc.service.AdminDataService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RldcMatchingUtils {

    private final String USER_AGENT = "Mozilla/5.0";
    ConvertDateFormat cdf = new ConvertDateFormat();
    String erMytrahFilePath = "", erGIWELFilePath = "";
    private HttpURLConnection conn;

    public static String getPath() {
        String path = "";
        URL resource;
        try {
            resource = Class.forName("com.discom.spingmvc.utils.NewScheduleCount").getResource("/");

            path = resource.getPath();
            path = path.replace("WEB-INF/classes/", "");
            path = path.replace("%20", " ");
            path = path.replaceFirst("/", "");

        } catch (ClassNotFoundException e) {

        }
        return path;
    }

    public static void addSheet(XSSFSheet mergedSheet, XSSFSheet sheet) {
        // map for cell styles
        Map<Integer, XSSFCellStyle> styleMap = new HashMap<Integer, XSSFCellStyle>();

        // This parameter is for appending sheet rows to mergedSheet in the end
        // int len = mergedSheet.getLastRowNum();
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {

            XSSFRow row = sheet.getRow(j);
            if (row != null) {
                XSSFRow mrow = mergedSheet.getRow(j);
                int len = mrow.getLastCellNum();

                for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    XSSFCell mcell = mrow.createCell(len + k);

                    if (cell.getSheet().getWorkbook() == mcell.getSheet().getWorkbook()) {
                        mcell.setCellStyle(cell.getCellStyle());
                    } else {
                        int stHashCode = cell.getCellStyle().hashCode();
                        XSSFCellStyle newCellStyle = styleMap.get(stHashCode);
                        if (newCellStyle == null) {
                            newCellStyle = mcell.getSheet().getWorkbook().createCellStyle();
                            newCellStyle.cloneStyleFrom(cell.getCellStyle());
                            styleMap.put(stHashCode, newCellStyle);
                        }
                        mcell.setCellStyle(newCellStyle);
                    }

                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_FORMULA:
                            mcell.setCellFormula(cell.getCellFormula());
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            mcell.setCellValue(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            mcell.setCellValue(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            mcell.setCellType(HSSFCell.CELL_TYPE_BLANK);
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            mcell.setCellValue(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            mcell.setCellErrorValue(cell.getErrorCellValue());
                            break;
                        default:
                            mcell.setCellValue(cell.getStringCellValue());
                            break;
                    }
                }
            }
        }
    }

    public static void swapRow(XSSFSheet sheet) {


        final XSSFRow rowA = sheet.getRow(108);
        final XSSFRow rowB = sheet.getRow(111);
        System.out.println(rowA);
        System.out.println(rowB);

        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {

            if (j == 108) {
                sheet.removeRow(sheet.getRow(108));
                XSSFRow mrow = sheet.createRow(108);
                for (int k = rowB.getFirstCellNum(); k < rowB.getLastCellNum(); k++) {
                    XSSFCell cell = rowB.getCell(k);
                    XSSFCell mcell = mrow.createCell(k);
                    mcell.setCellStyle(cell.getCellStyle());
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_FORMULA:
                            mcell.setCellFormula(cell.getCellFormula());
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            mcell.setCellValue(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            mcell.setCellValue(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            mcell.setCellType(HSSFCell.CELL_TYPE_BLANK);
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            mcell.setCellValue(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            mcell.setCellErrorValue(cell.getErrorCellValue());
                            break;
                        default:
                            mcell.setCellValue(cell.getStringCellValue());
                            break;
                    }
                }
            }
            if (j == 111) {
                sheet.removeRow(sheet.getRow(111));
                XSSFRow mrow = sheet.createRow(111);
                for (int k = rowA.getFirstCellNum(); k < rowA.getLastCellNum(); k++) {
                    XSSFCell cell = rowA.getCell(k);
                    XSSFCell mcell = mrow.createCell(k);
                    mcell.setCellStyle(cell.getCellStyle());
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_FORMULA:
                            mcell.setCellFormula(cell.getCellFormula());
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            mcell.setCellValue(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            mcell.setCellValue(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            mcell.setCellType(HSSFCell.CELL_TYPE_BLANK);
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            mcell.setCellValue(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            mcell.setCellErrorValue(cell.getErrorCellValue());
                            break;
                        default:
                            mcell.setCellValue(cell.getStringCellValue());
                            break;
                    }
                }
            }
        }
    }

    @Transactional
    public void downloadRLDCFiles(String schedulemasterid, String wpdregions, AddDao addDao, SearchDao searchDao, AdminDataService adminDataService) {
        try {
            System.out.println("schedulemasterid: " + schedulemasterid + " wpdregions: " + wpdregions);
            java.util.Date saveDate = new java.util.Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());
            Discomschedulemaster schedule = searchDao.findDiscomScheduleById(schedulemasterid);
            schedule.setScheduleDate(cdf.dataBaseFmt(schedule.getScheduleDate()));
            Portfoliomaster wpd = adminDataService.getPortfoliomaster(schedule.getId() + "");

            int rldcrevno = 0;
            int scheduleType = 4;
            if (wpd.getPortfolioId().equals("GIWEL_SECI-III_RE")) {
                scheduleType = 2;
            }
            String rldcsellerid = "ALL";
            String rldcscheduledatetime = "";
            String parameters = "";
            if (wpdregions.equals("SR")) {
                List<String> list = getRldcDownloadParameters("4", (schedule.getScheduleDate()), wpd.getPortfolioId(), wpdregions, searchDao);
                rldcrevno = Integer.parseInt(list.get(0));
                if (list.get(1) != null && !list.get(1).equals(""))
                    rldcsellerid = list.get(1);
                parameters = "regionId=4&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=" + scheduleType + "&isEXPP=1&isDetails=0&getTokenValue=1543574936007&fileType=xlsx";

                rldcscheduledatetime = getRldcDownloadedScheduleTime("4", schedule.getScheduleDate(), rldcrevno + "", wpdregions, searchDao);
            }
            if (wpdregions.equals("NR")) {
                List<String> list = getRldcDownloadParameters("3", (schedule.getScheduleDate()), wpd.getPortfolioId(), wpdregions, searchDao);
                rldcrevno = Integer.parseInt(list.get(0));
                if (list.get(1) != null && !list.get(1).equals(""))
                    rldcsellerid = list.get(1);
                parameters = "regionId=3&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=" + scheduleType + "&isEXPP=1&isDetails=0&getTokenValue=1544444866229&fileType=xlsx";

                rldcscheduledatetime = getRldcDownloadedScheduleTime("3", schedule.getScheduleDate(), rldcrevno + "", wpdregions, searchDao);
            }
            if (wpdregions.equals("ER")) {
                List<String> list = getRldcDownloadParameters("1", (schedule.getScheduleDate()), wpd.getPortfolioId(), wpdregions, searchDao);
                rldcrevno = Integer.parseInt(list.get(0));
                if (list.get(1) != null && !list.get(1).equals(""))
                    rldcsellerid = list.get(1);
                parameters = "regionId=1&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=" + scheduleType + "&isEXPP=1&isDetails=0&getTokenValue=1544445226301&fileType=xlsx";

                rldcscheduledatetime = getRldcDownloadedScheduleTime("1", schedule.getScheduleDate(), rldcrevno + "", wpdregions, searchDao);
            }
            if (wpdregions.equals("WR")) {
                List<String> list = getRldcDownloadParameters("2", (schedule.getScheduleDate()), wpd.getPortfolioId(), wpdregions, searchDao);
                rldcrevno = Integer.parseInt(list.get(0));
                if (list.get(1) != null && !list.get(1).equals(""))
                    rldcsellerid = list.get(1);
                parameters = "regionId=2&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=" + scheduleType + "&isEXPP=1&isDetails=0&getTokenValue=1544688408695&fileType=xlsx";

                rldcscheduledatetime = getRldcDownloadedScheduleTime("2", schedule.getScheduleDate(), rldcrevno + "", wpdregions, searchDao);
            }
            if (wpdregions.equals("NER")) {
                List<String> list = getRldcDownloadParameters("5", (schedule.getScheduleDate()), wpd.getPortfolioId(), wpdregions, searchDao);
                rldcrevno = Integer.parseInt(list.get(0));
                if (list.get(1) != null && !list.get(1).equals(""))
                    rldcsellerid = list.get(1);
                parameters = "regionId=5&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=" + scheduleType + "&isEXPP=1&isDetails=0&getTokenValue=1544688408695&fileType=xlsx";

                rldcscheduledatetime = getRldcDownloadedScheduleTime("5", schedule.getScheduleDate(), rldcrevno + "", wpdregions, searchDao);
            }
            String urlPath = getRldcMap(searchDao).get(wpdregions + "LDC") + parameters;
            String urlPath2 = "";
            if (wpdregions.equals("ER"))//for WR Tuticorin_GIREL download file
            {
                if (wpd.getPortfolioId().equals("GIWEL_SECI-II_RE"))
                    urlPath2 = "https://schedule.erldc.in/Report/ExportFlowGateScheduleToPDF?scheduleDate=" + (schedule.getScheduleDate()) + "&getTokenValue=1549357923957&fileType=xlsx&revisionNumber=" + rldcrevno + "&pathId=48&scheduleType=" + scheduleType + "&isLink=1";
            }
            if (wpdregions.equals("WR"))//for WR Tuticorin_GIREL download file
            {
                if (wpd.getPortfolioId().equals("Tuticorin_GIREL"))
                    urlPath = "http://scheduling.wrldc.in/wbes/Report/ExportFlowGateScheduleToPDF?scheduleDate=" + (schedule.getScheduleDate()) + "&getTokenValue=1546595733219&fileType=xlsx&revisionNumber=" + rldcrevno + "&pathId=27&scheduleType=" + scheduleType + "&isLink=1";
                if (wpd.getPortfolioId().equals("Tuticorin_Mytrah"))
                    urlPath = "http://scheduling.wrldc.in/wbes/Report/ExportFlowGateScheduleToPDF?scheduleDate=" + (schedule.getScheduleDate()) + "&getTokenValue=1549357442631&fileType=xlsx&revisionNumber=" + rldcrevno + "&pathId=1&scheduleType=" + scheduleType + "&isLink=1";
                if (wpd.getPortfolioId().equals("Tuticorin_Orange"))
                    urlPath = "http://scheduling.wrldc.in/wbes/Report/ExportFlowGateScheduleToPDF?scheduleDate=" + (schedule.getScheduleDate()) + "&getTokenValue=1549357442631&fileType=xlsx&revisionNumber=" + rldcrevno + "&pathId=1&scheduleType=" + scheduleType + "&isLink=1";
            }
            if (wpdregions.equals("NER"))//for WR Tuticorin_GIREL download file
            {
                if (wpd.getPortfolioId().equals("Tuticorin_Mytrah"))
                    urlPath = "https://schedule.erldc.in/Report/ExportFlowGateScheduleToPDF?scheduleDate=" + (schedule.getScheduleDate()) + "&getTokenValue=1549357923957&fileType=xlsx&revisionNumber=" + rldcrevno + "&pathId=48&scheduleType=" + scheduleType + "&isLink=1";
            }
            System.out.println("Downoad PATH: " + urlPath + " urlPath2 " + urlPath2);
            String downloadFileName = schedule.getScheduleDate() + "_" + wpd.getPortfolioId() + "_" + " REV_" + schedule.getRevisionno() + ".xlsx";
            String downloadFileName2 = schedule.getScheduleDate() + "_" + wpd.getPortfolioId() + "_" + " REV_" + schedule.getRevisionno() + "SameSite" + ".xlsx";
            String downloadroute = schedule.getScheduleDate() + "/" + wpd.getPortfolioId() + "/" + "R-" + schedule.getRevisionno() + "/" + wpdregions + "/";
            File dir = new File(getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute);
            if (!dir.exists())
                dir.mkdirs();

            String downloadPath = getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute + downloadFileName;
            String downloadPath2 = getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute + downloadFileName2;

            boolean download = urlDownload(urlPath, downloadPath);
            if (wpd.getPortfolioId().equals("GIWEL_SECI-II_RE"))
                urlDownload(urlPath2, downloadPath2);
            if (wpd.getPortfolioId().equals("Tuticorin_Mytrah"))    //Merging both file data new one
            {
                if (wpdregions.equals("ER"))    //first download ER File before downloading NER file
                {
                    erMytrahFilePath = downloadPath;
                }
                if (wpdregions.equals("NER"))    //after download ER File merge with NER file
                {
                    getMergeExcelData(erMytrahFilePath, downloadPath, true);
                    System.out.println("File Merged...");
                }
            }
            if (wpd.getPortfolioId().equals("GIWEL_SECI-II_RE"))    //Merging both file data new one
            {
                if (wpdregions.equals("ER"))    //first download ER File before downloading NER file
                {
                    erGIWELFilePath = downloadPath;
                    getMergeExcelData(downloadPath, downloadPath2, true);
                }
					 /*if(wpdregions.equals("NER"))	//after download ER File merge with NER file //same region download both files
					 {
						 getMergeExcelData(erGIWELFilePath, downloadPath, false);
						 System.out.println("File Merged...");
					 }*/
            }
            if (download == true) {
                Rldcdownloads rldcdownloads = new Rldcdownloads();
                rldcdownloads.setMasterid(null);
                rldcdownloads.setDownloadby("System");
                rldcdownloads.setIsdownloaded(download);
                rldcdownloads.setDownloaddate(timeStampDate);
                rldcdownloads.setFilename(downloadFileName);
                rldcdownloads.setSchedulemasterid(schedule.getScheduleMasterid());
                rldcdownloads.setRldc(wpdregions + "LDC");
                rldcdownloads.setScheduledate(cdf.dataBaseFmt(schedule.getScheduleDate()));
                rldcdownloads.setWpdid(wpd.getPortfolioId());
                rldcdownloads.setWpdname(wpd.getPortfolioName());
                rldcdownloads.setRevno(schedule.getRevisionno());
                rldcdownloads.setRldcrevno(rldcrevno);
                rldcdownloads.setWpdmasterid(schedule.getId());
                rldcdownloads.setRegionfor(wpdregions);
                rldcdownloads.setRldcscheduledatetime(rldcscheduledatetime);
                ///addDao.saveRldcdownloads(rldcdownloads);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Downoading complete");
    }

    public boolean urlDownload(String weburl, String filepath) throws IOException {
        boolean returne = false;
        try {
            System.out.println("weburl " + weburl);

            URL url = new URL(weburl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // act like a browser
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            InputStream input = con.getInputStream();
            FileOutputStream output = new FileOutputStream(filepath);
            byte[] bufferr = new byte[4096];
            int n = 0;
            while (-1 != (n = input.read(bufferr))) {
                output.write(bufferr, 0, n);
            }
            input.close();
            output.close();
            returne = true;
        } catch (Exception e) {
            e.printStackTrace();
            returne = false;
        }
        System.out.println("weburl end");
        return returne;
    }

    public Map<String, String> getRldcMap(SearchDao searchDao) {
        Map<String, String> map = new HashMap<String, String>();
        List<Rldcsetting> rldcS = searchDao.getRldcList();
        for (Rldcsetting rldc : rldcS) {
            map.put(rldc.getRldc(), rldc.getUrl());
        }
        return map;
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    public List<String> getRldcDownloadParameters(String regionId, String scheduleDate, String wpdId, String wpdregions, SearchDao searchDao) throws ParseException, Exception {
        JSONParser parser = new JSONParser();
        List<String> list = new ArrayList<String>();
        String rev = "0";
        String sellerid = "";
        String urlA = getRldcMap(searchDao).get(wpdregions + "LDCMAXREV");
        String urlAA = getRldcMap(searchDao).get(wpdregions + "LDCMAXREVDETAIL");

        urlA += "?regionid=" + regionId + "&ScheduleDate=" + scheduleDate;
        JSONObject revjson = (JSONObject) parser.parse(GetPageContent(urlA) + "");
        rev = revjson.get("MaxRevision") + "";
        urlAA += "?regionId=" + regionId + "&scheduleDate=" + scheduleDate + "&revision=" + rev;
        JSONObject json = (JSONObject) parser.parse(GetPageContent(urlAA) + "");
        JSONArray jsonSellers = (JSONArray) json.get("sellers");
        for (Object arr : jsonSellers) {
            JSONObject selldata = (JSONObject) arr;
            if (selldata.get("Acronym").equals(wpdId)) {
                sellerid = selldata.get("UtilId") + "";
            }
        }

        list.add(rev);
        list.add(sellerid);
        return list;
    }

    public String getRldcDownloadedScheduleTime(String regionId, String scheduleDate, String rev, String wpdregions, SearchDao searchDao) throws ParseException, Exception {
        JSONParser parser = new JSONParser();
        String rldcscheduledatetime = "";
        String urlA = getRldcMap(searchDao).get(wpdregions + "LDCSCHTIME");

        urlA += "?regionId=" + regionId + "&scheduleDate=" + scheduleDate;
        JSONArray jsonSellers = (JSONArray) parser.parse(GetPageContent(urlA) + "");
        for (Object arr : jsonSellers) {
            JSONObject selldata = (JSONObject) arr;
            if (selldata.get("Revision").toString().equals(rev)) {
                rldcscheduledatetime = selldata.get("strScheduleCreationDate") + "";
            }
        }

        return rldcscheduledatetime;
    }

    private String GetPageContent(String url) throws Exception {

        URL obj = new URL(url);
        System.out.println(" URL " + url);
        conn = (HttpURLConnection) obj.openConnection();
        // default is GET
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        conn.setConnectTimeout(60000);
        conn.setReadTimeout(60000);

        int responseCode = conn.getResponseCode();
        System.out.println(" URL start reading... ");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            // System.out.println("inputLine"+inputLine);
            response.append(inputLine);
        }
        in.close();
        System.out.println(" URL end reading...");
        //System.out.println(url);
        //System.out.println(response.toString());
        return response.toString();
    }

    public void getMergeExcelData(String er, String ner, boolean isSwap) {
        try {

            //String er = "D:/WINDENERGY WORKSPACE sec2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Scheduling/static/alldata/schedule/downloadrldcfile/05-02-2019/Tuticorin_Mytrah/R-0/ER/05-02-2019_Tuticorin_Mytrah_ REV_0.xlsx";
            //String ner = "D:/WINDENERGY WORKSPACE sec2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Scheduling/static/alldata/schedule/downloadrldcfile/05-02-2019/Tuticorin_Mytrah/R-0/NER/05-02-2019_Tuticorin_Mytrah_ REV_0.xlsx";

            FileInputStream excellFile1 = new FileInputStream(new File(er));
            FileInputStream excellFile2 = new FileInputStream(new File(ner));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook1 = new XSSFWorkbook(excellFile1);
            XSSFWorkbook workbook2 = new XSSFWorkbook(excellFile2);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet1 = workbook1.getSheetAt(0);
            XSSFSheet sheet2 = workbook2.getSheetAt(0);

            // add sheet2 to sheet1
            if (isSwap == true)
                swapRow(sheet2);
            addSheet(sheet1, sheet2);
            excellFile1.close();

            // save merged file
            File mergedFile = new File(er);
            // if (!mergedFile.exists()) {
            mergedFile.createNewFile();
            //}
            FileOutputStream out = new FileOutputStream(mergedFile);
            workbook1.write(out);
            out.close();
            System.out
                    .println("Files were merged succussfully");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}