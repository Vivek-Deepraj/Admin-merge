/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CurrentDate {

    public static void main(String ar[]) {
        //getCurrentTime();    
    }

    public double Round(double Rval) {
        double value = Math.round(Rval * 10000.0) / 10000.0;
        return value;
    }

    public String getCurrentTime() {
        Calendar cal = new GregorianCalendar();

        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int ampm = cal.get(Calendar.AM_PM);

        String time = null;
        if (ampm == 1) {
            hour = 12 + hour;
        }
        if (min < 10) {
            time = hour + ":0" + min;
        } else {
            time = hour + ":" + min;
        }
        return time;

    }

    public String getCurrentTimeInSeconds() {
        Calendar cal = new GregorianCalendar();

        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int ampm = cal.get(Calendar.AM_PM);
        String sec1 = "";
        if (sec < 10)
            sec1 = "0" + sec;
        else
            sec1 = "" + sec;

        String time = null;
        if (ampm == 1) {
            hour = 12 + hour;
        }
        if (min < 10) {
            time = hour + ":0" + min + ":" + sec1;
        } else {
            time = hour + ":" + min + ":" + sec1;
        }
        return time;

    }

    public String getCurrentDate() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.get(Calendar.HOUR);
        cal.get(Calendar.MINUTE);
        String day1 = String.valueOf(day);
        if (day < 10) {
            day1 = "0" + day;
        }
        String month1 = String.valueOf(month + 1);
        if ((month + 1) < 10) {
            month1 = "0" + month1;
        }


        String date = day1 + "-" + (month1) + "-" + year;
        return date;
    }

    public String getCurrentDate1() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String day1 = String.valueOf(day);
        if (day < 10) {
            day1 = "0" + day;
        }
        String month1 = String.valueOf(month + 1);
        if ((month + 1) < 10) {
            month1 = "0" + month1;
        }
        String date = year + "-" + (month1) + "-" + day1;
        return date;
    }

    public List getNintySixBlockFromToTime() {
        List list = new ArrayList();
        list.add("00:00-00:15");
        list.add("00:15-00:30");
        list.add("00:30-00:45");
        list.add("00:45-01:00");
        list.add("01:00-01:15");
        list.add("01:15-01:30");
        list.add("01:30-01:45");
        list.add("01:45-02:00");
        list.add("02:00-02:15");
        list.add("02:15-02:30");
        list.add("02:30-02:45");
        list.add("02:45-03:00");
        list.add("03:00-03:15");
        list.add("03:15-03:30");
        list.add("03:30-03:45");
        list.add("03:45-04:00");
        list.add("04:00-04:15");
        list.add("04:15-04:30");
        list.add("04:30-04:45");
        list.add("04:45-05:00");
        list.add("05:00-05:15");
        list.add("05:15-05:30");
        list.add("05:30-05:45");
        list.add("05:45-06:00");
        list.add("06:00-06:15");
        list.add("06:15-06:30");
        list.add("06:30-06:45");
        list.add("06:45-07:00");
        list.add("07:00-07:15");
        list.add("07:15-07:30");
        list.add("07:30-07:45");
        list.add("07:45-08:00");
        list.add("08:00-08:15");
        list.add("08:15-08:30");
        list.add("08:30-08:45");
        list.add("08:45-09:00");
        list.add("09:00-09:15");
        list.add("09:15-09:30");
        list.add("09:30-09:45");
        list.add("09:45-10:00");
        list.add("10:00-10:15");
        list.add("10:15-10:30");
        list.add("10:30-10:45");
        list.add("10:45-11:00");
        list.add("11:00-11:15");
        list.add("11:15-11:30");
        list.add("11:30-11:45");
        list.add("11:45-12:00");
        list.add("12:00-12:15");
        list.add("12:15-12:30");
        list.add("12:30-12:45");
        list.add("12:45-13:00");
        list.add("13:00-13:15");
        list.add("13:15-13:30");
        list.add("13:30-13:45");
        list.add("13:45-14:00");
        list.add("14:00-14:15");
        list.add("14:15-14:30");
        list.add("14:30-14:45");
        list.add("14:45-15:00");
        list.add("15:00-15:15");
        list.add("15:15-15:30");
        list.add("15:30-15:45");
        list.add("15:45-16:00");
        list.add("16:00-16:15");
        list.add("16:15-16:30");
        list.add("16:30-16:45");
        list.add("16:45-17:00");
        list.add("17:00-17:15");
        list.add("17:15-17:30");
        list.add("17:30-17:45");
        list.add("17:45-18:00");
        list.add("18:00-18:15");
        list.add("18:15-18:30");
        list.add("18:30-18:45");
        list.add("18:45-19:00");
        list.add("19:00-19:15");
        list.add("19:15-19:30");
        list.add("19:30-19:45");
        list.add("19:45-20:00");
        list.add("20:00-20:15");
        list.add("20:15-20:30");
        list.add("20:30-20:45");
        list.add("20:45-21:00");
        list.add("21:00-21:15");
        list.add("21:15-21:30");
        list.add("21:30-21:45");
        list.add("21:45-22:00");
        list.add("22:00-22:15");
        list.add("22:15-22:30");
        list.add("22:30-22:45");
        list.add("22:45-23:00");
        list.add("23:00-23:15");
        list.add("23:15-23:30");
        list.add("23:30-23:45");
        list.add("23:45-24:00");

        return list;
    }

    public List getNintySixBlockTime() {
        List list = new ArrayList();
        list.add("00:15:00");
        list.add("00:30:00");
        list.add("00:45:00");
        list.add("01:00:00");
        list.add("01:15:00");
        list.add("01:30:00");
        list.add("01:45:00");
        list.add("02:00:00");
        list.add("02:15:00");
        list.add("02:30:00");
        list.add("02:45:00");
        list.add("03:00:00");
        list.add("03:15:00");
        list.add("03:30:00");
        list.add("03:45:00");
        list.add("04:00:00");
        list.add("04:15:00");
        list.add("04:30:00");
        list.add("04:45:00");
        list.add("05:00:00");
        list.add("05:15:00");
        list.add("05:30:00");
        list.add("05:45:00");
        list.add("06:00:00");
        list.add("06:15:00");
        list.add("06:30:00");
        list.add("06:45:00");
        list.add("07:00:00");
        list.add("07:15:00");
        list.add("07:30:00");
        list.add("07:45:00");
        list.add("08:00:00");
        list.add("08:15:00");
        list.add("08:30:00");
        list.add("08:45:00");
        list.add("09:00:00");
        list.add("09:15:00");
        list.add("09:30:00");
        list.add("09:45:00");
        list.add("10:00:00");
        list.add("10:15:00");
        list.add("10:30:00");
        list.add("10:45:00");
        list.add("11:00:00");
        list.add("11:15:00");
        list.add("11:30:00");
        list.add("11:45:00");
        list.add("12:00:00");
        list.add("12:15:00");
        list.add("12:30:00");
        list.add("12:45:00");
        list.add("13:00:00");
        list.add("13:15:00");
        list.add("13:30:00");
        list.add("13:45:00");
        list.add("14:00:00");
        list.add("14:15:00");
        list.add("14:30:00");
        list.add("14:45:00");
        list.add("15:00:00");
        list.add("15:15:00");
        list.add("15:30:00");
        list.add("15:45:00");
        list.add("16:00:00");
        list.add("16:15:00");
        list.add("16:30:00");
        list.add("16:45:00");
        list.add("17:00:00");
        list.add("17:15:00");
        list.add("17:30:00");
        list.add("17:45:00");
        list.add("18:00:00");
        list.add("18:15:00");
        list.add("18:30:00");
        list.add("18:45:00");
        list.add("19:00:00");
        list.add("19:15:00");
        list.add("19:30:00");
        list.add("19:45:00");
        list.add("20:00:00");
        list.add("20:15:00");
        list.add("20:30:00");
        list.add("20:45:00");
        list.add("21:00:00");
        list.add("21:15:00");
        list.add("21:30:00");
        list.add("21:45:00");
        list.add("22:00:00");
        list.add("22:15:00");
        list.add("22:30:00");
        list.add("22:45:00");
        list.add("23:00:00");
        list.add("23:15:00");
        list.add("23:30:00");
        list.add("23:45:00");
        list.add("00:00:00");
        return list;
    }

    public String getCurrentDatetimeForFileName() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        String datetime = "" + year + month + day + hour + min + sec;
        return datetime;
    }
}
