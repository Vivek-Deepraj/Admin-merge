/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTime {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-ddd-HH-mm-ss";
    public static String dt;

    public static void main(String[] args) throws ParseException {

        DateAndTime dAT = new DateAndTime();
        dt = dAT.DateTime();

        // System.out.println("rt                                  ".substring(0, 19));
        System.out.println(dAT.ddmmyyhhmmtoyyyymmdd2("01/09/17 13:31"));

    }

    public String DateTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd-HH-mm-ss");
        return sdf.format(cal.getTime());
    }

    public String DateTime(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(date.getTime());
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

    public String ddmmyyhhmmtoyyyymmdd(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        date = sdf1.format(c.getTime());
        return date;
    }

    public String ddmmyyhhmmtoyyyymmdd2(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, -1);
        date = sdf1.format(c.getTime());
        return date;
    }

    public String ddmmyyhhmmtoyyyymmdd3(String date) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf1.parse(date));
        c.add(Calendar.DATE, -1);
        date = sdf1.format(c.getTime());
        return date;
    }
}