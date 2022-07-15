/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.utils;

/**
 * @author bijendra.chauhan
 */
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class daysbetweendays {

    public static void main(String[] args) {
        daysbetweendays daysbetweendays1 = new daysbetweendays();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyyMMdd");
        Calendar augustfirst2008 = Calendar.getInstance();
        augustfirst2008.set(2008, 07, 01);  // 2008-08-01
        Calendar today = Calendar.getInstance();        // today
        String dd1 = "2008-7-1";
        String date1[] = dd1.split("-");
        // System.out.println(date1[2]);
        // System.out.println(date1[1]);
        // System.out.println(date1[0]);
        Calendar a = Calendar.getInstance();
        int year = Integer.parseInt(date1[0]);
        int month = Integer.parseInt(date1[1]);
        int day = Integer.parseInt(date1[2]);
        //System.out.println(year);
        //System.out.println(month);
        // System.out.println(day);

        //a.set(2008, 07, 01);
        a.set(year, month, day);
        System.out.println(daysbetweendays1.getDifference("2017-08-09", today, TimeUnit.DAYS));
        //  + " day(s) between "
        //  + sdf.format(augustfirst2008.getTime()) + " and "
        //  + sdf.format(today.getTime()));
    }

    public long getDifference(String dd1, Calendar b, TimeUnit units) {


        //System.out.println("dd1"+dd1);

        String date1[] = dd1.split("-");
        Calendar a = Calendar.getInstance();
        a.set(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[2]));
        // System.out.println("diff1 "+ units.convert(b.getTimeInMillis() - a.getTimeInMillis(), TimeUnit.MILLISECONDS));
        return units.convert(a.getTimeInMillis() - b.getTimeInMillis(), TimeUnit.MILLISECONDS);
    }

    public long getDifferenceDaysHoursMinSec(Date dd1, Calendar b, TimeUnit units) {

        Calendar a = Calendar.getInstance();
        a.setTime(dd1);
        a.add(Calendar.DATE, 45);
        //a.set(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[2]));
        // System.out.println("diff1 "+ units.convert(b.getTimeInMillis() - a.getTimeInMillis(), TimeUnit.MILLISECONDS));
        return units.convert(a.getTimeInMillis() - b.getTimeInMillis(), TimeUnit.MILLISECONDS);
    }

    public long getDifference1(String dd1, String dd2, TimeUnit units) {


        // System.out.println("dd1"+dd1);

        // dd1="2012-09-16";

        String date1[] = dd1.split("-");
//System.out.println(date1[2]);
//System.out.println(date1[1]);
//System.out.println(date1[0]);
//Integer.parseInt(date1[2])
        Calendar a = Calendar.getInstance();
        a.set(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[2]));
        String date2[] = dd2.split("-");
//System.out.println(date1[2]);
//System.out.println(date1[1]);
//System.out.println(date1[0]);
//Integer.parseInt(date1[2])
        Calendar b = Calendar.getInstance();
        b.set(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]) - 1, Integer.parseInt(date2[2]));
        //  System.out.println("diff1 "+ units.convert(b.getTimeInMillis() - a.getTimeInMillis(), TimeUnit.MILLISECONDS));
        return units.convert(a.getTimeInMillis() - b.getTimeInMillis(), TimeUnit.MILLISECONDS);
    }/*
     * testing
     */
    /*
     * output : 921 day(s) between 20080801 and 20110208
     */

    public String remainigTime(Date enddate) {
        long diff = enddate.getTime() - (new Date()).getTime();
        long sec = diff / (1000);
        long min = sec / (60);
        sec = sec % 60;

        String time = String.format("%02d", min) + ":" + String.format("%02d", sec);
        return time;
    }
}
