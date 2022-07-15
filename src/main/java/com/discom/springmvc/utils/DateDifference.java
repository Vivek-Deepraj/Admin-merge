/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDifference {

    public static void main(String ar[]) {
        DateDifference dateDifference = new DateDifference();
        // System.out.println(daysBetween1("04-10-2015","01-04-2015"));
        System.out.println(dateDifference.daysBetween3("2016-01-01", "2015-12-28")); //output 4
    }

    public int daysBetween(String dd1, String dd2) {

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        String date1[] = dd1.split("-");
        String date2[] = dd2.split("-");

        cal1.set(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[0]));
        cal2.set(Integer.parseInt(date2[2]), Integer.parseInt(date2[1]) - 1, Integer.parseInt(date2[0]));
        Date d1 = cal1.getTime();
        Date d2 = cal2.getTime();


        return (int) ((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24));
    }

    public int daysBetween1(String dd1, String dd2) {


        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        String date1[] = dd1.split("-");
        String date2[] = dd2.split("-");

        cal1.set(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[0]));
        cal2.set(Integer.parseInt(date2[2]), Integer.parseInt(date2[1]) - 1, Integer.parseInt(date2[0]));
        Date d1 = cal1.getTime();
        Date d2 = cal2.getTime();
//System.out.println("d1 "+d1);
//System.out.println("d2 "+d2);


        return (int) ((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24));
    }

    public int daysBetween2(String dd1, String dd2) {

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        String date1[] = dd1.split("-");
        String date2[] = dd2.split("-");

        cal1.set(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[0]));
        cal2.set(Integer.parseInt(date2[2]), Integer.parseInt(date2[1]) - 1, Integer.parseInt(date2[0]));
        Date d1 = cal1.getTime();
        Date d2 = cal2.getTime();


        return (int) ((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24));
    }

    public long hoursBetweenDateTime(String fromdate, String todate) {

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        String dd1[] = fromdate.split(" ");
        String dd2[] = todate.split(" ");
        String date1[] = dd1[0].split("-");
        String time1[] = dd1[1].split(":");
        String date2[] = dd2[0].split("-");
        String time2[] = dd2[1].split(":");
        cal1.set(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[0]), Integer.parseInt(time1[0]), Integer.parseInt(time1[1]));
        cal2.set(Integer.parseInt(date2[2]), Integer.parseInt(date2[1]) - 1, Integer.parseInt(date2[0]), Integer.parseInt(time2[0]), Integer.parseInt(time2[1]));
        Date d1 = cal1.getTime();
        Date d2 = cal2.getTime();


        return (long) ((d1.getTime() - d2.getTime()) / (1000 * 60 * 60));
    }

    public int daysBetween3(String dd1, String dd2) {


        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        String date1[] = dd1.split("-");
        String date2[] = dd2.split("-");

        cal1.set(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]) - 1, Integer.parseInt(date1[2]));
        cal2.set(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]) - 1, Integer.parseInt(date2[2]));
        Date d1 = cal1.getTime();
        Date d2 = cal2.getTime();
//System.out.println("d1 "+d1);
//System.out.println("d2 "+d2);


        return (int) ((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24));
    }


}