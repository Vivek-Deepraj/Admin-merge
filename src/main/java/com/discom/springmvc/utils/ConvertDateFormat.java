package com.discom.springmvc.utils;

import com.discom.springmvc.dao.SearchDao;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ConvertDateFormat {

    public static long getDaysBetweenTwoDates(Date d1, Date d2) {

        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }

    public static long getDaysBetweenTwoDates2(String dd1, String dd2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(dd1));
        c2.setTime(sdf.parse(dd2));
        Date d1 = c1.getTime();
        Date d2 = c2.getTime();

        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static long getDaysBetweenTwoDates3(String dd1, String dd2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(dd1));
        c2.setTime(sdf2.parse(dd2));
        Date d1 = c1.getTime();
        Date d2 = c2.getTime();

        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static long getDaysBetweenTwoDates4(String dd1, String dd2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(dd1));
        c2.setTime(sdf.parse(dd2));
        Date d1 = c1.getTime();
        Date d2 = c2.getTime();

        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static long getNoOFDaysInMonth(String month, String year) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "1"));
        c.set(Calendar.DAY_OF_MONTH, 1);
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return daysInMonth;
    }

    public static List<String> getDatesBetweenTwoDates(String startdate, String enddate) throws ParseException {
        List<String> dates = new ArrayList<String>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(startdate));
        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(enddate));
        calendar2.add(Calendar.DATE, 1);
        while (calendar.getTime().before(calendar2.getTime())) {
            Date result = calendar.getTime();
            dates.add(new SimpleDateFormat("yyyy-MM-dd").format(result));
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }

    public String calTimePeriodForIndex(int rowindex) throws ParseException {
        String fromhour = "00";
        String frommin = "00";
        String tohour = "00";
        String tomin = "00";

        String hour = (rowindex / 4) + "";
        String min = ((rowindex) * 15) % 60 + "";
        String hour1 = ((rowindex + 1) / 4) + "";
        String min1 = (((rowindex + 1) * 15) % 60) + "";

        if (hour.length() == 1)
            fromhour = "0" + hour;
        else
            fromhour = hour;
        if (min.equals("0"))
            frommin = "00";
        else
            frommin = min;
        if (hour1.length() == 1)
            tohour = "0" + hour1;
        else
            tohour = hour1;
        if (min1.equals("0"))
            tomin = "0" + min1;
        else
            tomin = min1;

        String fromtime = fromhour + ":" + frommin;
        String totime = tohour + ":" + tomin;
        return fromtime + "-" + totime;

    }

    public List<String> getCurrAndNextDatee() throws ParseException {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1 = "", date2 = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate + ""));
        date1 = sdf1.format(c.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate + ""));
        c2.add(Calendar.DATE, 1);
        date2 = sdf1.format(c2.getTime());
        //  System.out.println(date1+" "+date2);
        dates.add(date1);
        dates.add(date2);

        return dates;
    }

    public String dataBaseFmt(String date) {
        String date1[] = date.split("-");
        date = date1[2].trim() + "-" + date1[1].trim() + "-" + date1[0].trim();
        return date;
    }

    public String dataBaseFmtInDot(String date) {
        String date1[] = date.split("-");
        date = date1[0].trim() + "." + date1[1].trim() + "." + date1[2].trim();
        return date;
    }

    public String dataBaseFmtInDotFromYYYY(String date) {
        String date1[] = date.split("-");
        date = date1[2].trim() + "." + date1[1].trim() + "." + date1[0].trim();
        return date;
    }

    public String dateDDAfterAddDay(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        //c.add(Calendar.DATE, 1);
        c.add(Calendar.DATE, days);  // number of days to add
        date = sdf.format(c.getTime());

        return date;
    }

    public String dateDDAfterAddDay2(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        //c.add(Calendar.DATE, 1);
        c.add(Calendar.DATE, days);  // number of days to add
        date = sdf.format(c.getTime());

        return date;
    }

    public String dateYYAfterAddDay(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        //c.add(Calendar.DATE, 1);
        c.add(Calendar.DATE, days);  // number of days to add
        date = sdf1.format(c.getTime());

        return date;
    }

    public String dateYYAfterAddDayYY(String date, int days) {


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            //c.add(Calendar.DATE, 1);
            c.add(Calendar.DATE, days);  // number of days to add
            date = sdf.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public String dateYYTTtoDD(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String getDateAfterSubtractXDay(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        Date dateBefore30Days = DateUtils.addDays(dd, -days);
        date = sdf1.format(dateBefore30Days);
        return date;
    }

    public String getDateAfterAddXDany(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        Date dateBefore30Days = DateUtils.addDays(dd, days);
        date = sdf1.format(dateBefore30Days);
        return date;
    }

    public String getDateAfterAddXDayy(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        Date dateBefore30Days = DateUtils.addDays(dd, days);
        date = sdf1.format(dateBefore30Days);
        return date;
    }

    public String dateYYTTMStoDD(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String dateYYTTMStoyyyyMMdd(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String dateYYTTtoDDMMYYTIME(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String dateYYHHMMAfterAddDayYYHHMM(String date, int min) {


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            //c.add(Calendar.DATE, 1);
            c.add(Calendar.MINUTE, min);  // number of days to add
            date = sdf.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public Timestamp dateYYHHMMAfterAddDayYYHHMM(Timestamp date, int min) {


        try {


            Calendar c = Calendar.getInstance();
            c.setTime((date));

            c.add(Calendar.MINUTE, min);  // number of days to add
            date = new Timestamp(c.getTimeInMillis());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public Date getParsedDate(String date) throws ParseException {
        java.util.Date asd11 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return asd11;
    }

    public Date getParsedDateAndTime(String date) throws ParseException { //12 February 2018 - 13:13

        String datee[] = date.split(" ");

        String newdate = datee[2] + "-" + datee[1].substring(0, 3) + "-" + datee[0] + " " + datee[4];

        System.out.println("NEWDATEANDTIEMPICKERCONVERSION: " + newdate);

        java.util.Date asd11 = new SimpleDateFormat("yyyy-MMM-dd hh:mm").parse(newdate);
        return asd11;
    }

    public boolean compareMonthAndYearIsInDate(String date, String month, String year) throws ParseException {
        boolean status = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        String monthfromdate = new SimpleDateFormat("MM").format(c.getTime());
        String yearfromdate = new SimpleDateFormat("yyyy").format(c.getTime());
        System.out.println("monthfromdate " + monthfromdate + " month " + month + " yearfromdate " + yearfromdate + " year " + year);
        if (monthfromdate.equalsIgnoreCase(month) && yearfromdate.equalsIgnoreCase(year)) {
            System.out.println("IN TRUE");
            status = true;
        } else {
            System.out.println("IN FALSE");
            status = false;
        }
        return status;
    }

    public String getLastDateOfMonthUsingMonthAndYear(String month, String year) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "15"));
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -1);
        String lastDateOfMonth = sdf.format(c.getTime());
        return lastDateOfMonth;
    }

    public List<List<String>> getLast3PrevMonthAndYear(String month, String year) throws ParseException {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> lt1 = new ArrayList<String>();
        List<String> lt2 = new ArrayList<String>();
        List<String> lt3 = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfm = new SimpleDateFormat("MM");
        SimpleDateFormat sdfM = new SimpleDateFormat("MMM");
        SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "15"));
        c.add(Calendar.MONTH, -1);  //addon if select sep then return jun, jul and aug
        lt1.add(sdfm.format(c.getTime()));
        lt1.add(sdfM.format(c.getTime()));
        lt1.add(sdfy.format(c.getTime()));
        c.setTime(sdf.parse(sdfy.format(c.getTime()) + "-" + sdfm.format(c.getTime()) + "-" + "15"));
        c.add(Calendar.MONTH, -1);
        lt2.add(sdfm.format(c.getTime()));
        lt2.add(sdfM.format(c.getTime()));
        lt2.add(sdfy.format(c.getTime()));
        c.setTime(sdf.parse(sdfy.format(c.getTime()) + "-" + sdfm.format(c.getTime()) + "-" + "15"));
        c.add(Calendar.MONTH, -1);
        lt3.add(sdfm.format(c.getTime()));
        lt3.add(sdfM.format(c.getTime()));
        lt3.add(sdfy.format(c.getTime()));
        list.add(0, lt1);
        list.add(1, lt2);
        list.add(2, lt3);
        return list;
    }

    public String getNextMonthAndYearUsingMonthAndYear(String month, String year) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "15"));
        c.add(Calendar.MONTH, 1);
        String lastDateOfMonth = sdf.format(c.getTime());
        return lastDateOfMonth;
    }

    public String getLastDateOfMonthUsingMonthAndYearr(String month, String year) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "15"));
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -1);
        String lastDateOfMonth = sdf1.format(c.getTime());
        return lastDateOfMonth;
    }

    public String getFirstDateOfMonthUsingMonthAndYear(String month, String year) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "25"));
        c.set(Calendar.DAY_OF_MONTH, 1);
        String lastDateOfMonth = sdf1.format(c.getTime());
        return lastDateOfMonth;
    }

    public String getFirstDateOfMonthUsingMonthAndYearr(String month, String year) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "25"));
        c.set(Calendar.DAY_OF_MONTH, 1);
        String lastDateOfMonth = sdf.format(c.getTime());
        return lastDateOfMonth;
    }

    public String getTimeStampToDBFormat(String timeStampDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate));
        String date = sdf1.format(c.getTime());
        return date;
    }

    public String getPrevMonth(String month) {
        switch (month) {
            case "01":
                month = "12";
                break;
            case "02":
                month = "01";
                break;
            case "03":
                month = "02";
                break;
            case "04":
                month = "03";
                break;
            case "05":
                month = "04";
                break;
            case "06":
                month = "05";
                break;
            case "07":
                month = "06";
                break;
            case "08":
                month = "07";
                break;
            case "09":
                month = "08";
                break;
            case "10":
                month = "09";
                break;
            case "11":
                month = "10";
                break;
            case "12":
                month = "11";
                break;
        }
        return month;
    }

    public String getIfFirstMonthGetPrevYear(String month, String year) {
        if (month.equals("01")) {
            year = String.valueOf(Integer.parseInt(year) - 1);
        }
        return year;
    }

    public String getLastDateOfPrevMonthUsingMonthAndYear(String month, String year) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year + "-" + month + "-" + "25"));
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -1);
        String lastDateOfMonth = sdf1.format(c.getTime());
        return lastDateOfMonth;
    }

    public String dateddMMyytoddMMMyy(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf1.parse(date));
        c.add(Calendar.DATE, 1);
        date = sdf.format(c.getTime());
        return date;
    }

    public String getDateAfterAddXDay2(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMMM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        Date dateBefore30Days = DateUtils.addDays(dd, days);
        date = sdf1.format(dateBefore30Days);
        return date;
    }

    public String getDateAfterAddXDay3(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        Date dateBefore30Days = DateUtils.addDays(dd, days);
        date = sdf1.format(dateBefore30Days);
        return date;
    }

    public String getDateAfterAddXDay3(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMMM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        //Date dateBefore30Days = DateUtils.addDays(dd,days);
        date = sdf1.format(dd);
        return date;
    }

    public String getDateAfterAddXDay33(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        //Date dateBefore30Days = DateUtils.addDays(dd,days);
        date = sdf1.format(dd);
        return date;
    }

    public String getNumberOfMonth(String charmonth) {
        switch (charmonth) {
            case "January":
                return "01";
            case "February":
                return "02";
            case "March":
                return "03";
            case "April":
                return "04";
            case "May":
                return "05";
            case "June":
                return "06";
            case "July":
                return "07";
            case "August":
                return "08";
            case "September":
                return "09";
            case "October":
                return "10";
            case "November":
                return "11";
            case "December":
                return "12";


        }
        return "00";
    }

    public String getNumberOfMonth2(String charmonth) {
        switch (charmonth) {
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
                return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";


        }
        return "00";
    }

    public String getDateForFileFormat(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String getLastDateOfPrevMonth(String date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf1.parse(date));
        c.add(Calendar.DATE, -1);
        date = sdf1.format(c.getTime());
        return date;
    }

    public String getManualReadingDate(String date) throws ParseException { //12 February 2018 - 13:13

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy - hh:mm");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String getManualReadingDate2(String date) throws ParseException { //12 February 2018 - 13:13

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy - hh:mm");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf1.parse(date));
        date = sdf.format(c.getTime());
        return date;
    }

    public String getManualReadingDate3(String date) throws ParseException { //12 February 2018 - 13:13

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf1.parse(date));
        date = sdf.format(c.getTime());
        return date;
    }

    public String getDateMonthYearFromDate(String date, String get) throws ParseException { //12 February 2018 - 13:13

        String returnvalue = "";
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("dd MMMM yyyy - hh:mm").parse(date));
        date = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        if (get.equals("date"))
            returnvalue = date.split("-")[2];
        if (get.equals("month"))
            returnvalue = date.split("-")[1];
        if (get.equals("year"))
            returnvalue = date.split("-")[0];

        return returnvalue;
    }

    public String getDateMonthYearFromDate3(String date, String get) throws ParseException { //12 February 2018 - 13:13

        String returnvalue = "";
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("dd-MM-yyyy hh:mm").parse(date));
        date = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        if (get.equals("date"))
            returnvalue = date.split("-")[2];
        if (get.equals("month"))
            returnvalue = date.split("-")[1];
        if (get.equals("year"))
            returnvalue = date.split("-")[0];

        return returnvalue;
    }

    public String getDateMonthYearFromDate2(String date, String get) throws ParseException { //12 February 2018 - 13:13

        String returnvalue = "";
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        date = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        if (get.equals("date"))
            returnvalue = date.split("-")[2];
        if (get.equals("month"))
            returnvalue = date.split("-")[1];
        if (get.equals("year"))
            returnvalue = date.split("-")[0];

        return returnvalue;
    }

    public String dateAddDayForEnergyVerification(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, days);  // number of days to add
        date = sdf1.format(c.getTime());
        return date;
    }

    public String dateAddDayForSkippingMonths(String date, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, days);  // number of days to add
        date = sdf1.format(c.getTime());
        return date;
    }

    public String getFinancialYear(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(date));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int yr = (month >= Calendar.APRIL) ? year : year - 1;
        return yr + "-" + (yr + 1);
    }

    public String getFinancialYRBYMonthYear(String mon, String yrr) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("01-" + mon + "-" + yrr));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int yr = (month >= Calendar.APRIL) ? year : year - 1;
        return yr + "-" + (yr + 1);
    }

    public String getSeqFinancialYRBYMonthYear(String mon, String yrr) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("01-" + mon + "-" + yrr));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int yr = (month >= Calendar.APRIL) ? year : year - 1;
        return (yr + "").substring(2, 4) + ((yr + 1) + "").substring(2, 4);
    }

    public String getSequenceNo(String prefix, int digit, int seq) {
        String sequenceNo = prefix + "";
        for (int i = String.valueOf(seq).length(); i < digit; i++) {
            sequenceNo += "0";
        }
        sequenceNo += seq;
        return sequenceNo;
    }

    public String getMonthYear(String date) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(date));
        return new SimpleDateFormat("MMM").format(c.getTime()) + "'" + new SimpleDateFormat("yy").format(c.getTime());
    }

    public boolean isSunday(String dueDate) throws ParseException {
        boolean status = false;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        cal.setTime(sdf.parse(dueDate));
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            status = true;
        }
        return status;
    }

    public boolean is2ndSaturday(String dueDate) throws ParseException {
        boolean status = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(dueDate));
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 2) {
            status = true;
        }
        return status;
    }

    public boolean isCustomerStartInCurrentFY(String month, String year, String startdate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("01-" + month + "-" + year));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        int monthh = calendar.get(Calendar.MONTH);
        int yearr = calendar.get(Calendar.YEAR);
        int yr = (monthh >= Calendar.APRIL) ? yearr : yearr - 1;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        c1.setTime(sdf.parse(startdate));
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        int monthhh = c1.get(Calendar.MONTH);
        int yearrr = c1.get(Calendar.YEAR);
        int yrr = (monthhh >= Calendar.APRIL) ? yearrr : yearrr - 1;
        String FY1 = yr + "-" + (yr + 1);
        String FY2 = yrr + "-" + (yrr + 1);
        System.out.println(FY1 + " || " + FY2);
        if (FY1.equals(FY2))
            return true;
        else
            return false;
    }

    public int[] passValidate(String password) {
        int data[] = new int[5];
        int numOfSpecial = 0;
        int numOfLetters = 0;
        int numOfUpperLetters = 0;
        int numOfLowerLetters = 0;
        int numOfDigits = 0;

        byte[] bytes = password.getBytes();
        for (byte tempByte : bytes) {
            if (tempByte >= 33 && tempByte <= 47) {
                numOfSpecial++;
            }

            char tempChar = (char) tempByte;
            if (Character.isDigit(tempChar)) {
                numOfDigits++;
            }

            if (Character.isLetter(tempChar)) {
                numOfLetters++;
            }

            if (Character.isUpperCase(tempChar)) {
                numOfUpperLetters++;
            }

            if (Character.isLowerCase(tempChar)) {
                numOfLowerLetters++;
            }
        }
        data[0] = numOfSpecial;
        data[1] = numOfLowerLetters;
        data[2] = numOfLetters;
        data[3] = numOfUpperLetters;
        data[4] = numOfDigits;


        return data;
    }

    public String getbillingmonthinMMM(String month) {
        String billingmonthinMMM = "";
        switch (month) {
            case "04":
                billingmonthinMMM = "April";
                break;
            case "05":
                billingmonthinMMM = "May";
                break;
            case "06":
                billingmonthinMMM = "June";
                break;
            case "07":
                billingmonthinMMM = "July";
                break;
            case "08":
                billingmonthinMMM = "August";
                break;
            case "09":
                billingmonthinMMM = "September";
                break;
            case "10":
                billingmonthinMMM = "October";
                break;
            case "11":
                billingmonthinMMM = "November";
                break;
            case "12":
                billingmonthinMMM = "December";
                break;
            case "01":
                billingmonthinMMM = "January";
                break;
            case "02":
                billingmonthinMMM = "February";
                break;
            case "03":
                billingmonthinMMM = "March";
                break;
        }
        return billingmonthinMMM;
    }

    public int getTarrifDays(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf2.parse(date1));
        c2.setTime(sdf2.parse(date2));
        Date d1 = c1.getTime();
        Date d2 = c2.getTime();

        long diff = d2.getTime() - d1.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }


    public List<String> getLastTwelveMonths() {
        List<String> allDates = new ArrayList<>();
        SimpleDateFormat monthDate = new SimpleDateFormat("MMM-yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.add(Calendar.MONTH, -1);
            int month1 = cal.get(Calendar.MONTH) + 1;
            int year1 = cal.get(Calendar.YEAR);

            String mon = getNickOfMonth(month1 + "");
            String maxDate = mon + "-" + year1;
            cal.setTime(monthDate.parse(maxDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (int i = 2; i <= 13; i++) {
            String month_name1 = monthDate.format(cal.getTime());
            allDates.add(month_name1);
            cal.add(Calendar.MONTH, -1);
        }
        Collections.reverse(allDates);

        return allDates;
    }

    public String getNickOfMonth(String month) {
        switch (month) {
            case "1":
                return "Jan";
            case "2":
                return "Feb";
            case "3":
                return "Mar";
            case "4":
                return "Apr";
            case "5":
                return "May";
            case "6":
                return "Jun";
            case "7":
                return "Jul";
            case "8":
                return "Aug";
            case "9":
                return "Sep";
            case "10":
                return "Oct";
            case "11":
                return "Nov";
            case "12":
                return "Dec";
        }
        return "00";
    }

    public String getNickOfMonthh(String month) {
        switch (month) {
            case "1":
                return "Jan";
            case "2":
                return "Feb";
            case "3":
                return "Mar";
            case "4":
                return "Apr";
            case "5":
                return "May";
            case "6":
                return "Jun";
            case "7":
                return "Jul";
            case "8":
                return "Aug";
            case "9":
                return "Sep";
            case "01":
                return "Jan";
            case "02":
                return "Feb";
            case "03":
                return "Mar";
            case "04":
                return "Apr";
            case "05":
                return "May";
            case "06":
                return "Jun";
            case "07":
                return "Jul";
            case "08":
                return "Aug";
            case "09":
                return "Sep";
            case "10":
                return "Oct";
            case "11":
                return "Nov";
            case "12":
                return "Dec";
        }
        return "00";
    }


    public String getMonthFromNick(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
        }
        return "00";
    }

    public List<String> getStartAndEndDateCurrentFYUsingMonthYear(String month, String year) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("01-" + month + "-" + year));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        int monthh = calendar.get(Calendar.MONTH);
        int yearr = calendar.get(Calendar.YEAR);
        int yr = (monthh >= Calendar.APRIL) ? yearr : yearr - 1;
        List<String> returnlist = new ArrayList<String>();
        returnlist.add(yr + "-04-01");
        returnlist.add((yr + 1) + "-03-31");
        //System.out.println(returnlist);
        return returnlist;
    }

    public List<String> getStartAndEndDateOf6MonthsDuration(String date) throws ParseException {
        List<String> returnlist = new ArrayList<String>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.MONTH, -6);
        c.add(Calendar.DATE, +1);
        String lastDateOfMonth = sdf.format(c.getTime());
        System.out.println(lastDateOfMonth + " || " + date);
        returnlist.add(lastDateOfMonth);
        returnlist.add(date);
        return returnlist;
    }

    public List<String> getYearList() throws ParseException {

        List<String> list = new ArrayList<String>();
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate + ""));
        int frstFY = Integer.parseInt(sdf1.format(c2.getTime()).split("-")[2]);
        for (int i = frstFY; i >= 2018; i--) {
            list.add(i + "");
        }
        return list;
    }

    public String getManualReadingDate4(String date) throws ParseException { //12 February 2018 - 13:13

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf1.parse(date));
        date = sdf.format(c.getTime());
        return date;
    }


    public String getAgreementEndDateForDailyReport(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdff = new SimpleDateFormat("dd-MMM-yy");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdff.format(c.getTime());

        return date;
    }

    public String getDateAfterAddXDay(String date,int days) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        Date dateBefore30Days = DateUtils.addDays(dd,days);
        date = sdf1.format(dateBefore30Days);
        return date;
    }

    public String getDateOfPrevScheduleDateAfterSubXDay(String date,int days) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        Date dd = c.getTime();
        Date dateBefore30Days = DateUtils.addDays(dd,days);
        date = sdf.format(dateBefore30Days);
        return date;
    }


    public String getDateTimeInSeconds(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String dateYYTTMStoDDLLD(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }


    public Date getParsedDateDDMMYYYY(String date) throws ParseException {
        java.util.Date asd11 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        return asd11;
    }

    public boolean checkEndDateGreaterFromStartDate(String startdate, String enddate) throws ParseException {
        java.util.Date sdate = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
        java.util.Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);
        if(edate.compareTo(sdate)>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public String getTimeStampForLog() throws Exception
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        String date = sdf1.format(c.getTime());
        return date;
    }

    public String getTimeStampForLog2(String datee) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(datee+""));
        String date = sdf1.format(c.getTime());
        return date;
    }


    public String getNumberOfMonth3(String charmonth)
    {
        switch(charmonth)
        {
            case "1":
                return "January";
            case "2":
                return "February";
            case "3":
                return "March";
            case "4":
                return "April";
            case "5":
                return "May";
            case "6":
                return "June";
            case "7":
                return "July";
            case "8":
                return "August";
            case "9":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";

        }
        return "00";
    }



    public String getFileNameWithCurrentDateTime(String date, MultipartFile fileName, String masterId) throws ParseException
    {
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(date+""));
        return new SimpleDateFormat("yyyyMMdd_hhmmss").format(c.getTime())+"_"+masterId+"_"+fileName.getOriginalFilename();
    }

    public String getFileNameWithCurrentDateTimeMS(String date, MultipartFile fileName) throws ParseException
    {
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(date+""));
        return new SimpleDateFormat("yyyyMMdd_hhmmssS").format(c.getTime())+"_"+fileName.getOriginalFilename();
    }


    String getDueDate2(String dueDate, String billing_cycle_day, String invoiceDate) {
        DateDifference diff = new DateDifference();
        Calendar sun = Calendar.getInstance();
        ConvertDateFormat cdf = new ConvertDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int holidayCount = 0;
            Date date1 = sdf.parse(dueDate);
            sun.setTime(date1);
            if (sun.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                if (billing_cycle_day.equals("Previous Day")) {
                    holidayCount--;
                    ;
                }
                if (billing_cycle_day.equals("Next Day")) {
                    holidayCount++;
                }
                Calendar c11 = Calendar.getInstance();
                c11.setTime(sdf.parse(dueDate));
                c11.add(Calendar.DATE, holidayCount); // number of days to add
                dueDate = sdf.format(c11.getTime());
            }
            List calenderList = null;//listService.getCalender();
            if (billing_cycle_day.equals("Next Day"))
                for (Object row1 : calenderList) {
                    Object[] recordArray = (Object[]) row1;
                    String holydayDate = (recordArray[0]).toString();
                    Date date11 = sdf.parse(holydayDate);
                    Date date12 = sdf.parse(dueDate);
                    if (date11.compareTo(date12) == 0) {
                        Calendar c111 = Calendar.getInstance();
                        c111.setTime(sdf.parse(dueDate));
                        c111.add(Calendar.DATE, 1); // number of days to add
                        dueDate = sdf.format(c111.getTime());
                        // System.out.println("due date in cal " + dueDate);
                    }
                    date1 = sdf.parse(dueDate);
                    sun.setTime(date1);
                    if (sun.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (billing_cycle_day.equals("Previous Day")) {
                            holidayCount--;
                            ;
                        }
                        if (billing_cycle_day.equals("Next Day")) {
                            holidayCount++;
                        }
                        Calendar c11 = Calendar.getInstance();
                        c11.setTime(sdf.parse(dueDate));
                        c11.add(Calendar.DATE, holidayCount); // number of days
                        // to add
                        dueDate = sdf.format(c11.getTime());

                        // System.out.println("due date in cal sun " + dueDate);

                    }
                    /*
                     * if (billing_cycle_day.equals("Previous Day")) {
                     * System.out.println("duedate " + dueDate);
                     * System.out.println("invoiceDate " + invoiceDate);
                     * if(dueDate.equals(invoiceDate)) break; }
                     */
                }
            if (billing_cycle_day.equals("Previous Day")) {
                List reverseCalendarList = new ArrayList();

                for (int i = calenderList.size() - 1; i > 0; i--) {
                    reverseCalendarList.add(calenderList.get(i));

                }
                for (Object row1 : reverseCalendarList) {
                    Object[] recordArray = (Object[]) row1;
                    String holydayDate = (recordArray[0]).toString();
                    Date date11 = sdf.parse(holydayDate);
                    Date date12 = sdf.parse(dueDate);
                    if (date11.compareTo(date12) == 0) {
                        Calendar c111 = Calendar.getInstance();
                        c111.setTime(sdf.parse(dueDate));
                        c111.add(Calendar.DATE, -1); // number of days to add
                        dueDate = sdf.format(c111.getTime());
                        // System.out.println("pre due date in cal " + dueDate);
                    }
                    date1 = sdf.parse(dueDate);
                    sun.setTime(date1);
                    if (sun.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (billing_cycle_day.equals("Previous Day")) {
                            holidayCount--;
                            ;
                        }
                        if (billing_cycle_day.equals("Next Day")) {
                            holidayCount++;
                        }
                        Calendar c11 = Calendar.getInstance();
                        c11.setTime(sdf.parse(dueDate));
                        c11.add(Calendar.DATE, holidayCount); // number of days
                        // to add
                        dueDate = sdf.format(c11.getTime());
                        // System.out.println("pre due date in cal sun " +
                        // dueDate);
                    }
                    if (diff.daysBetween1(cdf.dataBaseFmt(dueDate), cdf.dataBaseFmt(invoiceDate)) <= 1)
                        break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dueDate;
    }



    public String getDueDate(String dueDate, SearchDao searchDao) throws ParseException {

        String tempDate = dueDate;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        cal.setTime(sdf.parse(dueDate));
        if(isSunday(dueDate)==true)
        {
            System.out.println(dueDate+" SUNDAYYYYYYYYYY");
            cal.add(Calendar.DATE, 1);
            dueDate = sdf.format(cal.getTime());
        }
        if(is2ndSaturday(dueDate)==true)
        {
            System.out.println(dueDate+" 2ndSATRDAYYYYYYYYYY");
            cal.add(Calendar.DATE, 1);
            dueDate = sdf.format(cal.getTime());
        }
        /*
         * if(searchDao.isCalendarHoliday(new
         * SimpleDateFormat("yyyy-MM-dd").format(sdf.parse(dueDate)))==true) {
         * System.out.println(dueDate+" HOLIDAYYYYYYYYYY"); cal.add(Calendar.DATE, 1);
         * dueDate = sdf.format(cal.getTime()); }
         */
        if (sdf.parse(tempDate).compareTo(sdf.parse(dueDate)) == 0)
            return dueDate;
        return getDueDate(dueDate, searchDao);
    }


    public List<String> getCurrAndNextDate() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="", date2="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate+""));
        c2.add(Calendar.DATE, 1);
        date2 = sdf1.format(c2.getTime());
        // System.out.println(date1+" "+date2);
        Calendar c3 = Calendar.getInstance();
        c3.setTime(sdf.parse(timeStampDate+""));
        c3.add(Calendar.MONTH, -2);
        while (c3.getTime().before(c2.getTime()))
        {
            Date result = c3.getTime();
            dates.add(new SimpleDateFormat("dd-MM-yyyy").format(result));
            c3.add(Calendar.DATE, 1);
        }
        //dates.add(date1);
        dates.add(date2);

        return dates;
    }

    public List<String> getCurrAndNextDateOld() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="", date2="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate+""));
        c2.add(Calendar.DATE, 1);
        date2 = sdf1.format(c2.getTime());
        // System.out.println(date1+" "+date2);
        dates.add(date1);
        dates.add(date2);

        return dates;
    }

    public String getScheduleCreatedOn(String timeStampDate) throws ParseException
    {
        String date1="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate));
        date1 = sdf1.format(c.getTime());

        return date1;
    }

    public List<String> getLast6Months() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        dates.add(date1);
        for(int i=1;i<6;i++)
        {
            c.setTime(sdf.parse(timeStampDate+""));
            c.add(Calendar.MONTH, -i);
            date1 = sdf1.format(c.getTime());
            dates.add(date1);
        }
        return dates;
    }

    public List<String> getLast6MonthsDisplay() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM,YY");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        dates.add(date1);
        for(int i=1;i<6;i++)
        {
            c.setTime(sdf.parse(timeStampDate+""));
            c.add(Calendar.MONTH, -i);
            date1 = sdf1.format(c.getTime());
            dates.add(date1);
        }
        return dates;
    }

    public List<String> getLast12Months() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        dates.add(date1);
        for(int i=1;i<12;i++)
        {
            c.setTime(sdf.parse(timeStampDate+""));
            c.add(Calendar.MONTH, -i);
            date1 = sdf1.format(c.getTime());
            dates.add(date1);
        }
        return dates;
    }

    public List<String> getLast12MonthsDisplay() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM,YY");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        dates.add(date1);
        for(int i=1;i<12;i++)
        {
            c.setTime(sdf.parse(timeStampDate+""));
            c.add(Calendar.MONTH, -i);
            date1 = sdf1.format(c.getTime());
            dates.add(date1);
        }
        return dates;
    }

    public List<String> getPrev1MonthDays() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="", date2="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate+""));
        c2.add(Calendar.MONTH, -1);
        date2 = sdf1.format(c2.getTime());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(date1));
        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(date2));
        calendar2.add(Calendar.DATE, -1);
        while (calendar.getTime().after(calendar2.getTime()))
        {
            Date result = calendar.getTime();
            dates.add(new SimpleDateFormat("dd-MM-yyyy").format(result));
            calendar.add(Calendar.DATE, -1);
        }
        return dates;
    }

    public String getLoginTimeSess(String timeStampDate) throws ParseException
    {
        String date1="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate));
        date1 = sdf1.format(c.getTime());

        return date1;
    }


    public String getDateToCheckScheduleDataForREA(int days) throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        List<String> dates = new ArrayList<String>();
        String date1="", date2="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate+""));
        c2.add(Calendar.DATE, days);
        date2 = sdf1.format(c2.getTime());
        System.out.println(date1+" "+date2);
        dates.add(date1);
        dates.add(date2);

        return date2;
    }

    public String getCurrTimeInHHmm() throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        String time="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        time = sdf1.format(c.getTime());

        //  System.out.println(time +" Curr Time");
        return time;
    }

    public boolean isTimeInBetween(String time) throws ParseException
    {
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        String date1="",date2="",date3="",date4="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(timeStampDate+""));
        date1 = sdf1.format(c.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate+""));
        c2.add(Calendar.HOUR, 1);
        date2 = sdf1.format(c2.getTime());
        Calendar c3 = Calendar.getInstance();
        c3.setTime(sdf.parse(timeStampDate+""));
        c3.add(Calendar.HOUR, -1);
        date3 = sdf1.format(c3.getTime());
        Calendar c4 = Calendar.getInstance();
        c4.setTime(sdf.parse(timeStampDate+""));
        c4.set(Calendar.HOUR, Integer.parseInt(time.split(":")[0]));
        c4.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
        date4 = sdf1.format(c4.getTime());
        System.out.println(date3+" "+date1+" "+date2+" tocompare: "+date4);
        Date from = sdf1.parse(date3);
        Date to = sdf1.parse(date2);
        Date inbetween = sdf1.parse(date4);
        boolean ret = false;
        if(from.compareTo(inbetween)<=0 && to.compareTo(inbetween)>=0)
        {
            ret = true;
        }
        return ret;
    }


    public long getTimeDiffInMinutesBWTwoDatesOld(Date d1,Date d2) throws ParseException
    {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //change
        SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdftimeM = new SimpleDateFormat("HH:mm");
        Date actual = sdftime.parse(sdftime.format(d1));
        Date made = sdftime.parse(sdftime.format(d1));
        List<String> list = getTimeBlocks();
        for(String s:list)
        {
            String times[] = s.split("-");
            Date start = sdftimeM.parse(times[0]);
            Date end = sdftimeM.parse(times[1]);
            if(actual.compareTo(start)>0 && actual.compareTo(end)<=0)
            {
                made = sdftimeM.parse(times[1]);
            }
        }
        System.out.println(actual+" _____ "+made);
        d1.setHours(made.getHours());
        d1.setMinutes(made.getMinutes());
        d1.setSeconds(0);
        System.out.println(d1);
        //end
        Date dt1 = sdf.parse(sdf1.format(d1));
        Date dt2 = sdf.parse(sdf2.format(d2));

        long diff = dt2.getTime() - dt1.getTime();
        long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);//diff / (60 * 1000) % 60;
        //  diffMinutes = Math.abs(diffMinutes);
        System.out.println(diffMinutes+" diffMinutes");
        return diffMinutes;
    }

    //d1 shceduletime //d2 currenttime //openalot opentime
    public long getTimeDiffInMinutesBWTwoDatesNew(Date d1,Date d2,String openSlot, int dayToAdd) throws ParseException
    {
        System.out.print(d1+" ___ "+d2+" ___ "+openSlot+" ___ "+dayToAdd);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //change
        SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdftimeM = new SimpleDateFormat("HH:mm");
        String times[] = openSlot.split("-");
        Date actual = sdftime.parse(sdftime.format(d1));
        Date made = sdftime.parse(sdftime.format(d1));
        made = sdftimeM.parse(times[1]);
        System.out.println(actual+" _____ "+made);
        System.out.println(d1);
        d1.setHours(made.getHours());
        d1.setMinutes(made.getMinutes());
        d1.setSeconds(0);
        System.out.println(d1);
        d1.setDate(d1.getDate()+dayToAdd);
        System.out.println(d1);
        //end
        Date dt1 = sdf.parse(sdf1.format(d1));
        Date dt2 = sdf.parse(sdf2.format(d2));

        long diff = dt1.getTime() - dt2.getTime();
        long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);//diff / (60 * 1000) % 60;
        //  diffMinutes = Math.abs(diffMinutes);
        long diffSeconds = TimeUnit.MILLISECONDS.toSeconds(diff);
        System.out.println(diffSeconds+" diffSeconds");
        if(diffSeconds>0)
            diffMinutes = diffMinutes+1;
        System.out.println(diffMinutes+" diffMinutes");
        d1.setDate(d1.getDate()-dayToAdd);
        return diffMinutes;
    }

    public static List<String> getTimeBlocks() throws ParseException
    {
        List<String> timeblocks = new ArrayList<String>();
        for(int i=0;i<96;i++)
        {
            timeblocks.add(new ConvertDateFormat().calTimePeriodForIndex(i));
            //System.out.println(new ConvertDateFormat().calTimePeriodForIndex(i));
        }
        return timeblocks;
    }

    public String getNectDayScheduleTimeSlabToSave(String timeSlab,Date d2, int minutesAdd) throws ParseException
    {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar actualTime = Calendar.getInstance();
        actualTime.setTime(sdf.parse(sdf2.format(d2)));

        String timeSlabs[] = timeSlab.split("-");
        Calendar startTS = Calendar.getInstance();
        startTS.setTime(sdf.parse(sdf2.format(d2)));
        startTS.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeSlabs[0].split(":")[0]));
        startTS.set(Calendar.MINUTE, Integer.parseInt(timeSlabs[0].split(":")[1]));
        startTS.set(Calendar.SECOND, 0);

        Calendar endTS = Calendar.getInstance();
        endTS.setTime(sdf.parse(sdf2.format(d2)));
        endTS.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeSlabs[1].split(":")[0]));
        endTS.set(Calendar.MINUTE, Integer.parseInt(timeSlabs[1].split(":")[1]));
        endTS.set(Calendar.SECOND, 0);
        //System.out.println("startTS__ "+startTS.getTime()+" "+endTS.getTime()+" "+actualTime.getTime());
        if(endTS.getTime().compareTo(actualTime.getTime())<=0)
        {
            actualTime.add(Calendar.MINUTE, minutesAdd);
            //System.out.println("actualTime__ "+actualTime.getTime());
            List<String> list = getTimeBlocks();
            for(String s:list)
            {
                String times[] = s.split("-");
                Calendar start = Calendar.getInstance();
                start.setTime(actualTime.getTime());
                start.set(Calendar.HOUR_OF_DAY, Integer.parseInt(times[0].split(":")[0]));
                start.set(Calendar.MINUTE, Integer.parseInt(times[0].split(":")[1]));
                start.set(Calendar.SECOND, 0);
                Calendar end = Calendar.getInstance();
                end.setTime(actualTime.getTime());
                end.set(Calendar.HOUR_OF_DAY, Integer.parseInt(times[1].split(":")[0]));
                end.set(Calendar.MINUTE, Integer.parseInt(times[1].split(":")[1]));
                end.set(Calendar.SECOND, 0);
                if(actualTime.getTime().compareTo(start.getTime())>0 && actualTime.getTime().compareTo(end.getTime())<=0)
                {
                    timeSlab = s;
                }
            }
        }


        System.out.println("__timeSlab_____ "+timeSlab);

        return timeSlab;
    }

    public String getCreationDateTime(Date d) throws ParseException
    {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf2.parse(d+""));
        return sdf.format(c.getTime());
    }

    public long getTimeDiffInMinutesBWTwoDatess(Date dt1, Date dt2)
    {
        long diff = dt2.getTime() - dt1.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        return diffMinutes;
    }

    public List<String> getFinancialYearList(String date) throws ParseException {

        List<String> list = new ArrayList<String>();
        java.util.Date saveDate = new java.util.Date();
        java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(timeStampDate+""));
        String date2 = sdf1.format(c2.getTime());
        String frstFY = getFinancialYear(date);
        String tempFY = getFinancialYear(date);
        String currFY = getFinancialYear(date2);
        list.add(frstFY);
        while(!tempFY.equals(currFY))
        {
            Calendar c = Calendar.getInstance();
            c.setTime(sdf1.parse(date));
            c.add(Calendar.YEAR, 1);
            String tempdate = sdf1.format(c.getTime());
            date = tempdate;
            tempFY = getFinancialYear(tempdate);
            list.add(tempFY);
            /*if(tempFY==currFY)
            	break;*/
        }
        return list;
    }

    public boolean isDateLastDateOfMonth(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -1);
        String lastDateOfMonth = sdf.format(c.getTime());
        if(lastDateOfMonth.equals(date))
            return true;
        else
            return false;
    }

    public boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }



    public List<String> getFirstAndLastDateOfMonthUsingMonthAndYear(String month,String year) throws ParseException
    {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(year+"-"+month+"-"+"25"));
        c2.set(Calendar.DAY_OF_MONTH, 1);
        String firstDateOfMonth = sdf.format(c2.getTime());
        list.add(firstDateOfMonth);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(year+"-"+month+"-"+"15"));
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -1);
        String lastDateOfMonth = sdf.format(c.getTime());
        list.add(lastDateOfMonth);
        return list;
    }


}
