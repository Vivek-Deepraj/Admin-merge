package com.discom.springmvc.serviceimpl;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.ListDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.pojo.*;
//import com.discom.springmvc.service.ApiService;
import com.discom.springmvc.service.ListService;
import com.discom.springmvc.service.RldcFileDownloadService;
import com.discom.springmvc.utils.ConvertDateFormat;
import com.discom.springmvc.utils.UtilityClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;


@Service("rldcFileDownloadService")
public class RldcFileDownloadServiceImpl implements RldcFileDownloadService {

    private static final int BUFFER_SIZE = 4096;
    private final String USER_AGENT = "Mozilla/5.0";
    @Autowired
    HttpServletRequest request;
    @Autowired
    ListService listService;
    @Autowired
    ListDao listDao;
    //@Autowired
    //ApiService apiService;
    ConvertDateFormat cdf = new ConvertDateFormat();
    @Autowired
    private AddDao addDao;
    @Autowired
    private SearchDao searchDao;
    private HttpURLConnection conn;

    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = "MMM.xlsx";
                fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length());
            }

            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }

    public static void downloadFilee(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
        OutputStream os = httpConn.getOutputStream();
        //os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = "MMM.xlsx";
                fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length());
            }

            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }

    public static String getPath() {
        String path = "";
        path = UtilityClass.dataPath();

        return path;
    }

    public boolean downloadALLRLDCScedule(String scheduledate) {
        String status = "";
        try {
            java.util.Date saveDate = new java.util.Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());
            List<String> dates = new ConvertDateFormat().getCurrAndNextDatee();
            String region = "", term = "";
            List<String> regionList = new ArrayList<String>();
            List<String> termList = new ArrayList<String>();
            Map<String, String> regionIdMapList = new HashMap<String, String>();
            Map<String, String> scheduleTypeMapList = new HashMap<String, String>();
            regionIdMapList.put("NRLDC", "3");
            regionIdMapList.put("WRLDC", "2");
            regionIdMapList.put("SRLDC", "4");
            regionIdMapList.put("ERLDC", "1");
            regionIdMapList.put("NERLDC", "5");
            //region
            regionList.add("NRLDC");
            regionList.add("WRLDC");
            regionList.add("SRLDC");
            regionList.add("ERLDC");
            regionList.add("NERLDC");
            //term
            termList.add("STOA");
            termList.add("MTOA");
            termList.add("LTOA");
            //scheduletype
            scheduleTypeMapList.put("STOA", "3");
            scheduleTypeMapList.put("MTOA", "2");
            scheduleTypeMapList.put("LTOA", "4");
            for (int i = 0; i < regionList.size(); i++) {
                region = regionList.get(i);
                for (int j = 0; j < termList.size(); j++) {
                    int rldcrevno = 0;
                    term = termList.get(j);
                    String rldcsellerid = "ALL";
                    String parameters = "", regionURL = "", regionId = "", scheduleType = "";
                    scheduleType = scheduleTypeMapList.get(term);
                    regionURL = getRldcMap().get(region);
                    //for NR
                    regionId = regionIdMapList.get(region);
                    {
                        List<String> list = getRldcDownloadParameter(regionURL, regionId, scheduledate);
                        rldcrevno = Integer.parseInt(list.get(0));
                        System.out.println("rldcrevno " + rldcrevno);
                        parameters = "regionId=" + regionId + "&scheduleDate=" + scheduledate + "&sellerId=ALL&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=" + scheduleType + "&isEXPP=1&isDetails=0&getTokenValue=1543574936007&fileType=xlsx";
                    }

                    String urlPath = getRldcMap().get(region) + "/" + getRldcMap().get(term) + "?" + parameters;
                    System.out.println("Downoad PATH: " + urlPath);
                    String downloadFileName = region + "_" + term + ".xlsx";
                    String downloadroute = scheduledate + "/" + region + "/";
                    File dir = new File(getPath() + "/schedule/downloadrldcfile/" + downloadroute);
                    if (!dir.exists())
                        dir.mkdirs();

                    String downloadPath = getPath() + "/schedule/downloadrldcfile/" + downloadroute + downloadFileName;
                    System.out.println("befoe download ");
                    boolean download = urlDownload(urlPath, downloadPath);
                    System.out.println("after download ");
                    // if(download==true)
                    try {
                        Rldcdownloads rldcdownloads = new Rldcdownloads();
                        rldcdownloads.setMasterid(null);
                        rldcdownloads.setDownloadby("System");
                        rldcdownloads.setIsdownloaded(download);
                        rldcdownloads.setDownloaddate(timeStampDate);
                        rldcdownloads.setFilename(downloadFileName);
                        // rldcdownloads.setSchedulemasterid(schedule.getScheduleMasterid());
                        rldcdownloads.setRldc(region);
                        rldcdownloads.setScheduledate(cdf.dataBaseFmt(scheduledate));
                        // rldcdownloads.setWpdid(schedule.getWpdid());
                        // rldcdownloads.setWpdname(schedule.getWpdname());
                        rldcdownloads.setRevno(rldcrevno);
                        rldcdownloads.setRldcrevno(rldcrevno);
                        // rldcdownloads.setWpdmasterid(schedule.getId());
                        rldcdownloads.setRegionfor(region);
                        addDao.saveRldcdownloads(rldcdownloads);

                        processRldcDataDetailRecord(downloadPath, scheduledate, rldcdownloads);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            /// addDao.updateDiscomScheduleRLDCDownload(schedule.getScheduleMasterid()+"");
            status = "success";

        } catch (Exception e) {
            status = "failed";
            e.printStackTrace();
        }

        return true;
    }

    @Transactional
    public String downloadRLDCFiles() {

        String status = "";
        try {
            java.util.Date saveDate = new java.util.Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());
            List<String> dates = new ConvertDateFormat().getCurrAndNextDatee();
            List<Discomschedulemaster> schedules = searchDao.findDiscomschedulemasterByForDownloadRLDC(dates);
            if (schedules != null)
                for (Discomschedulemaster schedule : schedules) {
                    String schedulemasterid = schedule.getScheduleMasterid() + "";
                    List<Discomschedulesources> sourcelist = searchDao.findByScheduleMasterId(schedulemasterid);
                    Portfoliomaster wpd = null;//apiService.getPortfoliomaster(schedule.getId()+"");
                    List<String> routes = new ArrayList<String>();
                    for (Discomschedulesources srmaster : sourcelist) {
                        String route[] = srmaster.getRoute().split("->");
                        for (String rt : route) {
                            if (!routes.contains(rt))
                                routes.add(rt);
                        }
                    }
                    for (String wpdregions : routes) {
                        int rldcrevno = 0;
                        String rldcsellerid = "ALL";
                        String parameters = "";
                        if (wpdregions.equals("SR")) {
                            List<String> list = getRldcDownloadParameters("4", (schedule.getScheduleDate()), wpd.getPortfolioId());
                            rldcrevno = Integer.parseInt(list.get(0));
                            if (list.get(1) != null && !list.get(1).equals(""))
                                rldcsellerid = list.get(1);
                            parameters = "regionId=4&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=4&isEXPP=1&isDetails=0&getTokenValue=1543574936007&fileType=xlsx";
                        }
                        if (wpdregions.equals("NR")) {
                            List<String> list = getRldcDownloadParameters("3", (schedule.getScheduleDate()), wpd.getPortfolioId());
                            rldcrevno = Integer.parseInt(list.get(0));
                            if (list.get(1) != null && !list.get(1).equals(""))
                                rldcsellerid = list.get(1);
                            parameters = "regionId=3&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=4&isEXPP=1&isDetails=0&getTokenValue=1544444866229&fileType=xlsx";
                        }
                        if (wpdregions.equals("ER")) {
                            List<String> list = getRldcDownloadParameters("1", (schedule.getScheduleDate()), wpd.getPortfolioId());
                            rldcrevno = Integer.parseInt(list.get(0));
                            if (list.get(1) != null && !list.get(1).equals(""))
                                rldcsellerid = list.get(1);
                            parameters = "regionId=1&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=4&isEXPP=1&isDetails=0&getTokenValue=1544445226301&fileType=xlsx";
                        }
                        if (wpdregions.equals("WR")) {
                            List<String> list = getRldcDownloadParameters("2", (schedule.getScheduleDate()), wpd.getPortfolioId());
                            rldcrevno = Integer.parseInt(list.get(0));
                            if (list.get(1) != null && !list.get(1).equals(""))
                                rldcsellerid = list.get(1);
                            parameters = "regionId=2&scheduleDate=" + (schedule.getScheduleDate()) + "&sellerId=" + rldcsellerid + "&buyerId=ALL&traderId=ALL&revisionNumber=" + rldcrevno + "&scheduleType=4&isEXPP=1&isDetails=0&getTokenValue=1544688408695&fileType=xlsx";
                        }
                        String urlPath = getRldcMap().get(schedule.getRegion() + "LDC") + parameters;
                        System.out.println("Downoad PATH: " + urlPath);
                        String downloadFileName = schedule.getScheduleDate() + "_" + schedule.getWpdid() + "_" + " REV_" + schedule.getRevisionno() + ".xlsx";
                        String downloadroute = schedule.getScheduleDate() + "/" + schedule.getWpdid() + "/" + "R-" + schedule.getRevisionno() + "/" + wpdregions + "/";
                        File dir = new File(getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute);
                        if (!dir.exists())
                            dir.mkdirs();

                        String downloadPath = getPath() + "static/alldata/schedule/downloadrldcfile/" + downloadroute + downloadFileName;
                        boolean download = urlDownload(urlPath, downloadPath);
                        if (download == true) {
                            Rldcdownloads rldcdownloads = new Rldcdownloads();
                            rldcdownloads.setMasterid(null);
                            rldcdownloads.setDownloadby("System");
                            rldcdownloads.setIsdownloaded(download);
                            rldcdownloads.setDownloaddate(timeStampDate);
                            rldcdownloads.setFilename(downloadFileName);
                            rldcdownloads.setSchedulemasterid(schedule.getScheduleMasterid());
                            rldcdownloads.setRldc(schedule.getRegion() + "LDC");
                            rldcdownloads.setScheduledate(cdf.dataBaseFmt(schedule.getScheduleDate()));
                            rldcdownloads.setWpdid(schedule.getWpdid());
                            rldcdownloads.setWpdname(schedule.getWpdname());
                            rldcdownloads.setRevno(schedule.getRevisionno());
                            rldcdownloads.setRldcrevno(rldcrevno);
                            rldcdownloads.setWpdmasterid(schedule.getId());
                            rldcdownloads.setRegionfor(wpdregions);
                            /// addDao.saveRldcdownloads(rldcdownloads);
                        }
                    }
                    /// addDao.updateDiscomScheduleRLDCDownload(schedule.getScheduleMasterid()+"");
                    status = "success";
                }
        } catch (Exception e) {
            status = "failed";
            //	e.printStackTrace();
        }
        return status;
    }

    public boolean saveFileFromUrl(String downloadPath, String urlPath) throws MalformedURLException, IOException {
        boolean download = false;
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlPath).openStream());
            fout = new FileOutputStream(downloadPath);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
            download = true;
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
        return download;
    }

    public void doDownload1(String filename, String losstyp, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pdffile = "";
        if (losstyp.equals("STU"))
            pdffile = "/static/data/losses/stu/" + filename;
        if (losstyp.equals("CTU"))
            pdffile = "/static/data/losses/ctu/" + filename;
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("appPath = " + appPath);
        String fullPath = appPath + pdffile;
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();
    }

    public boolean urlDownload(String weburl, String filepath) throws IOException {
        boolean returne = false;
        try {

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
        return returne;
    }

    public Map<String, String> getRldcMap() {
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

    public List<String> getRldcDownloadParameter(String regionURL, String regionId, String scheduleDate) throws ParseException, Exception {
        JSONParser parser = new JSONParser();
        List<String> list = new ArrayList<String>();
        String rev = "0";

        String urlA = "Report/GetNetScheduleRevisionNoForSpecificRegion?regionid=3&ScheduleDate=04-02-2022";
        urlA = regionURL + "/" + "Report/GetNetScheduleRevisionNoForSpecificRegion";


        urlA += "?regionid=" + regionId + "&ScheduleDate=" + scheduleDate;
        //JSONObject revjson =  (JSONObject) parser.parse(GetPageContent(urlA)+"");
        //rev = revjson.get("MaxRevision")+"";

        JSONArray json = (JSONArray) parser.parse(GetPageContent(urlA) + "");
        rev = "" + (Long) json.get(0);


        list.add(rev);

        return list;
    }

    public List<String> getRldcDownloadParameters(String regionId, String scheduleDate, String wpdId) throws ParseException, Exception {
        JSONParser parser = new JSONParser();
        List<String> list = new ArrayList<String>();
        String rev = "0";
        String sellerid = "";
        String urlA = "https://schedule.erldc.in/Report/GetFullScheduleMaxRevision";
        String urlB = "http://scheduling.wrldc.in/wbes/Report/GetCurrentDayFullScheduleMaxRev";
        String urlC = "http://103.7.128.190/wbes/Report/GetCurrentDayFullScheduleMaxRev";
        String urlD = "http://scheduling.srldc.in:8080/wbes/Report/GetFullScheduleMaxRevision";
        String urlAA = "https://schedule.erldc.in/Report/GetLTAUtilsFromFullSchedule";
        String urlBB = "http://scheduling.wrldc.in/wbes/Report/GetLTAUtilsFromFullSchedule";
        String urlCC = "http://103.7.128.190/wbes/Report/GetLTAUtilsFromFullSchedule";
        String urlDD = "http://scheduling.srldc.in:8080/wbes/Report/GetLTAUtilsFromFullSchedule";
        if (regionId.equals("1")) {
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
        }
        if (regionId.equals("2")) {
            urlB += "?regionid=" + regionId + "&ScheduleDate=" + scheduleDate;
            JSONObject revjson = (JSONObject) parser.parse(GetPageContent(urlB) + "");
            rev = revjson.get("MaxRevision") + "";
            urlBB += "?regionId=" + regionId + "&scheduleDate=" + scheduleDate + "&revision=" + rev;
            JSONObject json = (JSONObject) parser.parse(GetPageContent(urlBB) + "");
            JSONArray jsonSellers = (JSONArray) json.get("sellers");
            for (Object arr : jsonSellers) {
                JSONObject selldata = (JSONObject) arr;
                if (selldata.get("Acronym").equals(wpdId)) {
                    sellerid = selldata.get("UtilId") + "";
                }
            }
        }
        if (regionId.equals("3")) {
            urlC += "?regionid=" + regionId + "&ScheduleDate=" + scheduleDate;
            JSONObject revjson = (JSONObject) parser.parse(GetPageContent(urlC) + "");
            rev = revjson.get("MaxRevision") + "";
            urlCC += "?regionId=" + regionId + "&scheduleDate=" + scheduleDate + "&revision=" + rev;
            JSONObject json = (JSONObject) parser.parse(GetPageContent(urlCC) + "");
            JSONArray jsonSellers = (JSONArray) json.get("sellers");
            for (Object arr : jsonSellers) {
                JSONObject selldata = (JSONObject) arr;
                if (selldata.get("Acronym").equals(wpdId)) {
                    sellerid = selldata.get("UtilId") + "";
                }
            }
        }
        if (regionId.equals("4")) {
            urlD += "?regionid=" + regionId + "&ScheduleDate=" + scheduleDate;
            JSONObject revjson = (JSONObject) parser.parse(GetPageContent(urlD) + "");
            rev = revjson.get("MaxRevision") + "";
            urlDD += "?regionId=" + regionId + "&scheduleDate=" + scheduleDate + "&revision=" + rev;
            JSONObject json = (JSONObject) parser.parse(GetPageContent(urlDD) + "");
            JSONArray jsonSellers = (JSONArray) json.get("sellers");
            for (Object arr : jsonSellers) {
                JSONObject selldata = (JSONObject) arr;
                if (selldata.get("Acronym").equals(wpdId)) {
                    sellerid = selldata.get("UtilId") + "";
                }
            }
        }
        list.add(rev);
        list.add(sellerid);
        return list;
    }

    private String GetPageContent(String url) throws Exception {

        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();
        // default is GET
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        int responseCode = conn.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            // System.out.println("inputLine"+inputLine);
            response.append(inputLine);
        }
        in.close();
        System.out.println(url);
        System.out.println(response.toString());
        return response.toString();
    }

    void processRldcDataDetailRecord(String filepath, String scheduledate, Rldcdownloads rldcdownloads) {
        try {
            //String filepath = path+tempfilename;
            String seller_state, buyer_state, seller_utilty, buyer_utility, approval_no, applicant_name, rl_link;
            HashMap<String, String> result = new HashMap<String, String>();

            List<String> datelist = new ArrayList<String>();
            List<String> timelist = new ArrayList<String>();
            List<String> sellerlist = new ArrayList<String>();
            List<String> buyerlist = new ArrayList<String>();
            List<String> sourcedestlist = new ArrayList<String>();
            List<String> reqlist = new ArrayList<String>();
            List<String> energylist = new ArrayList<String>();
            List<List<String>> allenergylist = new ArrayList<List<String>>();
            List<String> dataList = new ArrayList<String>();
            List<List<String>> allDataList = new ArrayList<List<String>>();
            Workbook wb1 = null;
            Row row;
            Cell cell;
            int rows; // No of rows
            int cols = 0; // No of columns
            try {

                wb1 = new XSSFWorkbook(filepath);

                Sheet sheet = wb1.getSheetAt(0);
                //  System.out.println(" sheet  "+sheet.getSheetName());
                rows = sheet.getPhysicalNumberOfRows();
                //  System.out.println(" rows  "+rows);
                for (int r1 = 4; r1 < rows; r1++) {
                    row = sheet.getRow(r1);
                    if (row != null) {
                        cols = sheet.getRow(5).getLastCellNum();//getPhysicalNumberOfCells();
                        dataList = new ArrayList<String>();
                        //for (int c = 0; c < (2+sourcelist.size()); c++) {
                        for (int c = 0; c < (cols); c++) {
                            cell = row.getCell((short) c);

                            if (cell != null) { // System.out.println(" cell val  "+c+"  "+cell.toString()+" type "+cell.getCellType());
                                if (r1 != 0)
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (r1 == 0) {
                                    dataList.add(cell.toString().trim());
                                } else
                                // if(!cell.getStringCellValue().equals(""))
                                {
                                    dataList.add(cell.getStringCellValue().trim());
                                }
                            }
                        }
                        allDataList.add(dataList);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //  System.out.println(" allDataList  "+allDataList);
            //   System.out.println(" allDataList  "+allDataList.size());
            String wpdname = "";

            Sheet sheet = wb1.getSheetAt(0);
            cols = sheet.getRow(7).getPhysicalNumberOfCells();

            /*
             * for(int j=1;j<cols;j++) { for(int i=4;i<11;i++) { if(i==0) if(j>=1) {
             * datelist.add(allDataList.get(i).get(j)); } if(i==2) if(j>=0) {
             * sellerlist.add(allDataList.get(i).get(j)); } if(i==3) if(j>=0) {
             * buyerlist.add(allDataList.get(i).get(j)); } if(i==4) if(j>=0) {
             * sourcedestlist.add(allDataList.get(i).get(j)); } } }
             */
            for (int i = 8; i < 104; i++) {

                timelist.add(allDataList.get(i).get(1));

            }
            for (int j = 2; j < allDataList.get(0).size(); j++) {
                energylist = new ArrayList<String>();
                seller_state = "";
                buyer_state = "";
                seller_utilty = "";
                buyer_utility = "";
                approval_no = "";
                applicant_name = "";
                rl_link = "";
                //  System.out.println(" allDataList.get(0).get(j) "+allDataList.get(0).get(j));
                if (allDataList.get(0).get(j).equals("PTC")) {
                    for (int i = 0; i < 104; i++) {

                        String psadiscomname = "", ppadiscomname = "", approvalno = "";
                        if (i == 0) {
                            applicant_name = allDataList.get(i).get(j);
                        }
                        if (i == 1) {
                            seller_state = allDataList.get(i).get(j);
                        }
                        if (i == 2) {
                            seller_utilty = allDataList.get(i).get(j);
                        }
                        if (i == 3) {
                            buyer_state = allDataList.get(i).get(j);
                        }
                        if (i == 4) {
                            buyer_utility = allDataList.get(i).get(j);
                        }
                        if (i == 5) {
                            rl_link = allDataList.get(i).get(j);
                        }
                        if (i == 6) {
                            approval_no = allDataList.get(i).get(j);
                        }


                        if (i >= 8 && i < 104) {
                            energylist.add(allDataList.get(i).get(j));
                        }
                    }
                    System.out.println(" energylist " + energylist);

                    System.out.println(" timelist " + timelist);
                    System.out.println(" applicant_name " + applicant_name);
                    if (applicant_name.equals("PTC")) {
                        Collection<Rldcscheduledetail> scheduleDetailCollection = new ArrayList<Rldcscheduledetail>();
                        int i = 0;
                        for (String list : energylist) {
                            Rldcscheduledetail rldcscheduledetail = new Rldcscheduledetail();
                            rldcscheduledetail.setPower(list);
                            rldcscheduledetail.setDiscompower(list);
                            rldcscheduledetail.setPowerwithoutloss(list);

                            rldcscheduledetail.setTimeslot(timelist.get(i++));
                            rldcscheduledetail.setScheduledate(cdf.dataBaseFmt(scheduledate));
                            rldcscheduledetail.setRldcScheduleId(null);
                            scheduleDetailCollection.add(rldcscheduledetail);
                        }
                        Rldcschedulesources rldcschedulesources = new Rldcschedulesources();
                        rldcschedulesources.setId(null);
                        rldcschedulesources.setApplicantname(applicant_name);
                        rldcschedulesources.setFromState(seller_state);
                        rldcschedulesources.setFromUtility(seller_utilty);
                        rldcschedulesources.setToState(buyer_state);
                        rldcschedulesources.setToUtility(buyer_utility);
                        rldcschedulesources.setRoute(rl_link);
                        rldcschedulesources.setApprovalNo(approval_no);
                        rldcschedulesources.setRldcscheduledetailCollection(scheduleDetailCollection);
                        rldcschedulesources.setScheduledate(cdf.dataBaseFmt(scheduledate));
                        rldcschedulesources.setRldcDownloadMasterid(rldcdownloads);
                        rldcschedulesources.setRevisionno(rldcdownloads.getRevno());

                        addDao.saveRLDCdataSchedule(rldcschedulesources);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}