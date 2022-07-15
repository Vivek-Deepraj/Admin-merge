package com.discom.springmvc.utils;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.*;
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
import java.text.SimpleDateFormat;
import java.util.*;
public class RldcMatchingUtilsNew {

    private final String USER_AGENT = "Mozilla/5.0";
    ConvertDateFormat cdf = new ConvertDateFormat();
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
            Date saveDate = new Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());
            Discomschedulemaster schedule = searchDao.findDiscomScheduleById(schedulemasterid);
            schedule.setScheduleDate(cdf.dataBaseFmt(schedule.getScheduleDate()));
            boolean externalUse = isExternalUse(schedule, wpdregions, adminDataService);
            Portfoliomaster wpd = adminDataService.getPortfoliomaster(schedule.getId() + "");

            int scheduleType = 4;
            if (wpd.getPortfolioId().equals("GIWEL_SECI-III_RE")) {
                //scheduleType = 2;
            }
            int regionId = getRegionId(wpdregions);
            List<String> list = getRldcDownloadParameters(regionId + "", (schedule.getScheduleDate()), wpd.getPortfolioId(), wpdregions, searchDao);
            int rldcrevno = Integer.parseInt(list.get(0));
            String rldcsellerid = list.get(1);
            String parameters = "regionId=" + regionId + "&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=" + scheduleType + "&isEXPP=1&isDetails=0&getTokenValue=1543574936007&fileType=xlsx";
            String rldcscheduledatetime = getRldcDownloadedScheduleTime(regionId + "", schedule.getScheduleDate(), rldcrevno + "", wpdregions, searchDao);

            String urlPath = getRldcMap(searchDao).get(wpdregions + "LDC") + parameters;
            System.out.println("Downoad PATH: " + urlPath);
            String urlPathExt = "";
            if (externalUse == true) {
                int pathId = getPathId(schedule, wpdregions, adminDataService);
                urlPathExt = getRldcMap(searchDao).get(wpdregions + "LDC_EXT") + "scheduleDate=" + (schedule.getScheduleDate()) + "&getTokenValue=1546595733219&fileType=xlsx&revisionNumber=" + rldcrevno + "&pathId=" + pathId + "&scheduleType=" + scheduleType + "&isLink=1";
            }
            System.out.println("Downoad PATH: " + urlPathExt);
            String downloadFileName = schedule.getScheduleDate() + "_" + wpd.getPortfolioId() + "_" + " REV_" + schedule.getRevisionno() + ".xlsx";
            String downloadroute = schedule.getScheduleDate() + "/" + wpd.getPortfolioId() + "/" + "R-" + schedule.getRevisionno() + "/" + wpdregions + "/";
            File dir = new File(getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute);
            if (!dir.exists())
                dir.mkdirs();

            String downloadPath = getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute + downloadFileName;

            String downloadFileNameExt = schedule.getScheduleDate() + "_" + wpd.getPortfolioId() + "_" + " REV_" + schedule.getRevisionno() + "SameSite" + ".xlsx";
            String downloadPathExt = getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute + downloadFileNameExt;

            boolean download = urlDownload(urlPath, downloadPath);
            if (externalUse == true) {
                urlDownload(urlPathExt, downloadPathExt);
                getMergeExcelData(downloadPath, downloadPathExt, true);
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
                /// addDao.saveRldcdownloads(rldcdownloads);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Downoading complete");
    }

    @Transactional
    public List<String> downloadRLDCScheduleFiles(String masterid, String scheduleDate, SearchDao searchDao, AdminDataService adminDataService) {
        List<String> listData = new ArrayList<String>();
        int rldcrevno = -1;
        String datetime = "";
        String filename = "";
        try {
            Portfoliomaster wpd = adminDataService.getPortfoliomaster(masterid);

            List<String> list = getRldcDownloadParametersFetch(getRegionId(wpd.getRegionCode().trim()) + "", scheduleDate, wpd.getPortfolioId(), wpd.getRegionCode().trim(), searchDao);
            rldcrevno = Integer.parseInt(list.get(0));
            datetime = list.get(2).replace("/Date(", "").replace(")/", "");
            //Date expiry = new Date(Long.parseLong(datetime));
            System.out.println("DDATTIME: " + datetime);
            String urlPath = getRldcMap(searchDao).get(wpd.getPortfolioId() + "_DLINK");
            urlPath = urlPath.replace("SCHDATE", scheduleDate);
            urlPath = urlPath.replace("revisionNumber=1", "revisionNumber=" + rldcrevno);
            System.out.println("Downoad PATH: " + urlPath);
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmsss");
            String downloadFileName = scheduleDate + "_" + wpd.getPortfolioId() + "_" + "_dt_" + sdf.format(new Date()) + ".xlsx";
            String downloadPath = getPath() + "static/alldata/schedule/tempuploadedfile/" + downloadFileName;

            boolean download = urlDownload(urlPath, downloadPath);
            if (download == true) {
                System.out.println("RLDC File Downoading complete " + downloadPath);
                filename = downloadFileName;
                //return downloadFileName;
            } else {
                filename = "";
                //return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            //return "";
        }
        listData.add(filename);
        listData.add(rldcrevno + "");
        listData.add(datetime + "");
        return listData;
    }

    public boolean urlDownload(String weburl, String filepath) throws IOException {

        HttpUrlConnectionExample httpUrlConnectionExample = new HttpUrlConnectionExample();

        boolean returne = false;
        try {
            System.out.println("weburl " + weburl);
            returne = httpUrlConnectionExample.gett(weburl, filepath);
            /*
             * SSLUtilities.trustAllHostnames(); SSLUtilities.trustAllHttpsCertificates();
             *
             * URL url = new URL(weburl); URLConnection con = url.openConnection();
             * con.setRequestProperty("charset", "utf-8");
             *
             * con.setRequestProperty("User-Agent", "Mozilla/5.0");
             *
             * InputStream input = con.getInputStream(); FileOutputStream output = new
             * FileOutputStream(filepath); byte[] bufferr = new byte[4096]; int n = 0; while
             * (-1 != (n = input.read(bufferr))) { output.write(bufferr, 0, n); }
             * input.close(); output.close();
             */
            //returne = true;
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

    public int getRegionId(String wpdRegion) {
        if (wpdRegion.equals("ER")) {
            return 1;
        } else if (wpdRegion.equals("WR")) {
            return 2;
        } else if (wpdRegion.equals("NR")) {
            return 3;
        } else if (wpdRegion.equals("SR")) {
            return 4;
        } else {
            return 5;
        }
    }

    public int getPathId(Discomschedulemaster schedule, String wpdregions, AdminDataService adminDataService) {
        Map<String, Integer> pathIdMap = new HashMap<String, Integer>();
        pathIdMap.put("WR-NR", 1);
        pathIdMap.put("ER-NER", 48);
        pathIdMap.put("SR-WR", 27);
        pathIdMap.put("NR-WR", 14);
        pathIdMap.put("WR-ER", 67);
        pathIdMap.put("WR-SR", 4);

        int pathId = 1;
        List<Agreementmaster> sourcelist = adminDataService.getWpdActiveAgreementsListByWPDIDForSchedule(cdf.dataBaseFmt(schedule.getScheduleDate()), schedule.getId() + "", schedule.getLtoano());
        for (Agreementmaster agr : sourcelist) {
            ///Powerroute route = searchDao.findRouteById(agr.getRouteId().getRouteId()+""); change
            Powerroute route = null;
            String routes[] = route.getRoute().split("->");
            if (routes.length > 2) {
                for (int i = 1; i < routes.length - 1; i++) {
                    if (routes[i].equals(wpdregions)) {
                        pathId = pathIdMap.get(routes[i] + "-" + routes[i + 1]);
                    }
                }
            }
        }

			/*int pathId = 1;
   		 if(wpd.getWpdid().equals("GIWEL_SECI-II_RE") && wpdregions.equals("ER"))//ER
   		 {
   			 pathId = 48;
   		 }
   		 if(wpd.getWpdid().equals("Tuticorin_GIREL") && wpdregions.equals("WR"))//WR
   		 {
   			 pathId = 27;
   		 }
   		 if(wpd.getWpdid().equals("Tuticorin_Mytrah") && wpdregions.equals("WR"))//WR
   		 {
   			 pathId = 1;
   		 }
   		 if(wpd.getWpdid().equals("Tuticorin_Orange") && wpdregions.equals("wR"))//WR
   		 {
   			 pathId = 1;
   		 }
   		 if(wpd.getWpdid().equals("Tuticorin_Mytrah") && wpdregions.equals("NER"))//NER
   		 {
   			 pathId = 48;
   		 }*/

        return pathId;
    }

    public boolean isExternalUse(Discomschedulemaster schedule, String wpdregions, AdminDataService adminDataService) {
        boolean externalUse = false;
        List<Agreementmaster> sourcelist = adminDataService.getWpdActiveAgreementsListByWPDIDForSchedule(cdf.dataBaseFmt(schedule.getScheduleDate()), schedule.getId() + "", schedule.getLtoano());
        for (Agreementmaster agr : sourcelist) {
            ///Powerroute route =  searchDao.findRouteById(agr.getRouteId().getRouteId()+"");change
            Powerroute route = null;
            String routes[] = route.getRoute().split("->");
            System.out.println(route.getRoute() + " route" + routes.length);
            if (routes.length > 2) {
                for (int i = 1; i < routes.length - 1; i++) {
                    System.out.println(routes[i] + " route " + wpdregions);
                    if (routes[i].equals(wpdregions))
                        externalUse = true;
                }
            }
        }
        System.out.println(externalUse + " externalUse");
        return externalUse;
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
        String sellerid = "ALL";
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

    public List<String> getRldcDownloadParametersFetch(String regionId, String scheduleDate, String wpdId, String wpdregions, SearchDao searchDao) throws ParseException, Exception {
        JSONParser parser = new JSONParser();
        List<String> list = new ArrayList<String>();
        String rev = "0";
        String sellerid = "ALL";
        String datetime = "";
        String urlA = getRldcMap(searchDao).get(wpdregions + "LDCMAXREV");
        String urlAA = getRldcMap(searchDao).get(wpdregions + "LDCMAXREVDETAIL");

        urlA += "?regionid=" + regionId + "&ScheduleDate=" + scheduleDate;
        JSONObject revjson = (JSONObject) parser.parse(GetPageContent(urlA) + "");
        rev = revjson.get("MaxRevision") + "";
        urlAA += "?regionId=" + regionId + "&scheduleDate=" + scheduleDate + "&revision=" + rev;
        //old link not used
        urlAA = urlAA.replace("Report/GetLTAUtilsFromFullSchedule", "ReportNetSchedule/GetFullScheduleList");

        //JSONObject json =  (JSONObject) parser.parse(GetPageContent(urlAA)+"");
        JSONArray jsonSellers = (JSONArray) parser.parse(GetPageContent(urlAA) + "");//json.get("sellers");
        for (Object arr : jsonSellers) {
            //System.out.println("Arr: "+arr);
            JSONObject selldata = (JSONObject) arr;
            if ((selldata.get("Revision") + "").equals(rev)) {
                System.out.println("Revision: " + selldata.get("strScheduleCreationDate"));
                datetime = selldata.get("strScheduleCreationDate") + "";
            }
        }

//			JSONObject json =  (JSONObject) parser.parse(GetPageContent(urlAA)+"");
//			JSONArray jsonSellers =  (JSONArray) json.get("sellers");
//			for(Object arr:jsonSellers)
//			{
//				JSONObject selldata =  (JSONObject) arr;
//				if(selldata.get("Acronym").equals(wpdId))
//				{
//					sellerid = selldata.get("UtilId")+"";
//				}
//				if(selldata.get("Acronym").equals(wpdId))
//				{
//					datetime = selldata.get("CommissioningDate")+"";
//				}
//			}

        list.add(rev);
        list.add(sellerid);
        list.add(datetime);
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
        System.out.println(" URL =" + url + "=>");
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