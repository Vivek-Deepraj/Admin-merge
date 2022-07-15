package com.discom.springmvc.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";
    private List<String> cookies;
    private HttpURLConnection conn;

    public static void main(String[] args) throws Exception {

        //String url = "https://accounts.google.com/ServiceLoginAuth";
//	String gmail = "https://mail.google.com/mail/";

        HttpUrlConnectionExample http = new HttpUrlConnectionExample();
        http.gett();
        // make sure cookies is turn on
        //CookieHandler.setDefault(new CookieManager());
//	String sUrl ="http://scheduling.srldc.in:8080/wbes/Report/ExportMTOALTANewToPDF?regionId=4&scheduleDate=30-11-2018&sellerId=ALL&buyerId=ALL&traderId=ALL&revisionNumber=68&scheduleType=4&isEXPP=1&isDetails=0&getTokenValue=1543578586276&fileType=xlsx";

        // 1. Send a "GET" request, so that you can extract the form's data.
//	String page = http.GetPageContent(sUrl);
//	String postParams = http.getFormParams(page, "username@gmail.com", "password");

        // 2. Construct above post's content and then send a POST request for
        // authentication
        //http.sendPost(url, postParams);
        //String sUrl ="http://scheduling.srldc.in:8080/wbes/Report/ExportMTOALTANewToPDF?regionId=4&scheduleDate=30-11-2018&sellerId=ALL&buyerId=ALL&traderId=ALL&revisionNumber=68&scheduleType=4&isEXPP=1&isDetails=0&getTokenValue=1543578586276&fileType=xlsx";

        // 3. success then go to gmail.
        //String result = http.GetPageContent(sUrl);
        //System.out.println(result);
    }

    private void sendPost(String url, String postParams) throws Exception {

        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();

        // Acts like a browser
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Host", "accounts.google.com");
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        for (String cookie : this.cookies) {
            conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
        }
        conn.setRequestProperty("Connection", "keep-alive");
        conn.setRequestProperty("Referer", "https://accounts.google.com/ServiceLoginAuth");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));

        conn.setDoOutput(true);
        conn.setDoInput(true);

        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + postParams);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // System.out.println(response.toString());

    }

    private String GetPageContent(String url) throws Exception {

        URL obj = new URL(url);
        conn = (HttpURLConnection) obj.openConnection();

        // default is GET
        conn.setRequestMethod("GET");

        conn.setUseCaches(false);

        // act like a browser
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//	conn.setRequestProperty("Content-type","application/vnd.ms-excel");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        if (cookies != null) {
            for (String cookie : this.cookies) {
                conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
            }
        }
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);


        InputStream input = conn.getInputStream();


        FileOutputStream output = new FileOutputStream("D:/data/test.xlsx");

        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }

        input.close();
        output.close();

        BufferedReader in =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            System.out.println("inputLine" + inputLine);
            //response.append(inputLine);
        }
        in.close();

        // Get the response cookies
        setCookies(conn.getHeaderFields().get("Set-Cookie"));

        return response.toString();

    }

    public String getFormParams(String html, String username, String password)
            throws UnsupportedEncodingException {

        System.out.println("Extracting form's data...");

        Document doc = Jsoup.parse(html);

        // Google form id
        Element loginform = doc.getElementById("gaia_loginform");
        Elements inputElements = loginform.getElementsByTag("input");
        List<String> paramList = new ArrayList<String>();
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.attr("value");

            if (key.equals("Email"))
                value = username;
            else if (key.equals("Passwd"))
                value = password;
            paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
        }

        // build parameters list
        StringBuilder result = new StringBuilder();
        for (String param : paramList) {
            if (result.length() == 0) {
                result.append(param);
            } else {
                result.append("&" + param);
            }
        }
        return result.toString();
    }

    public List<String> getCookies() {
        return cookies;
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public void gett() {
        try {
            System.out.println("in get method");
            SSLUtilities.trustAllHostnames();
            SSLUtilities.trustAllHttpsCertificates();
            String weburl = "https://wbes.wrldc.in/ReportFullSchedule/ExportFullScheduleInjDetailToPDF?scheduleDate=31-10-2020&sellerId=7e2ecb35-c895-49d3-92f7-088a3222dacd&revisionNumber=1&getTokenValue=1600775287041&fileType=xlsx&schType=11";
            //String weburl="https://wbes.wrldc.in/ReportFullSchedule/ExportFullScheduleInjDetailToPDF?scheduleDate=31-10-2020&sellerId=7e2ecb35-c895-49d3-92f7-088a3222dacd&revisionNumber=-1&getTokenValue=1600775287041&fileType=xlsx&schType=11";
            //String weburl="https://wbes.wrldc.in/ReportFullSchedule/ExportFullScheduleInjDetailToPDF?scheduleDate=01-11-2020&sellerId=7e2ecb35-c895-49d3-92f7-088a3222dacd&revisionNumber=-1&getTokenValue=1600775287041&fileType=xlsx&schType=11";
            URL url = new URL(weburl);
            URLConnection con = url.openConnection();
            //con.setRequestMethod("GET");
            //con.setReadTimeout(10000);
            //con.setConnectTimeout(15000);
            //con.setRequestMethod("POST");
            //con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("charset", "utf-8");
            // act like a browser
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            //con.setRequestProperty("Content-Type", "application/json");

            InputStream input = con.getInputStream();
            FileOutputStream output = new FileOutputStream("/home/ptc/test4.xlsx");
            byte[] bufferr = new byte[4096];
            int n = 0;
            while (-1 != (n = input.read(bufferr))) {
                output.write(bufferr, 0, n);
            }
            input.close();
            output.close();
            //returne = true;
        } catch (Exception e) {
            e.printStackTrace();
            //returne = false;
        }
        System.out.println("weburl end");
        //	return returne;

    }

    public boolean gett(String weburl, String filepath) {
        boolean res = false;
        try {//gett();
            System.out.println("in gett method");
            System.out.println("weburl = " + weburl);
            System.out.println("filepath = " + filepath);

            SSLUtilities.trustAllHostnames();
            SSLUtilities.trustAllHttpsCertificates();
            URL url = new URL(weburl);
            URLConnection con = url.openConnection();
            //con.setRequestMethod("GET");
            //con.setReadTimeout(5000);
            //con.setConnectTimeout(15000);
            //con.setRequestMethod("POST");
            //con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("charset", "utf-8");
            // act like a browser
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            //con.setRequestProperty("Content-Type", "application/json");

            InputStream input = con.getInputStream();
            FileOutputStream output = new FileOutputStream("/" + filepath);
            byte[] bufferr = new byte[8096];
            int n = 0;
            while (-1 != (n = input.read(bufferr))) {
                output.write(bufferr, 0, n);
            }
            input.close();
            output.close();
            res = true;
            //returne = true;
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
            //returne = false;
        }
        System.out.println("weburl end");
        return res;

    }
}
