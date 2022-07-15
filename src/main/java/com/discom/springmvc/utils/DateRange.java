/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discom.springmvc.utils;

import java.util.Calendar;

/**
 * @author Bijendra
 */
public class DateRange {
    public static void main(String ar[]) {


        String deliverydate = null;

        String fromdate = "01-01-2013";
        String day11 = "", month11 = "";
        int inlist, daycount = 0, flag = 0, lastday1, lastday;
        Calendar cal = Calendar.getInstance();
        int day1 = Integer.parseInt(fromdate.split("-")[0]);
        int month1 = Integer.parseInt(fromdate.split("-")[1]);
        int year1 = Integer.parseInt(fromdate.split("-")[2]);
        for (int i = 1; i <= 368 + 1; i++) {

            daycount++;

            //System.out.println("The value of i in starting of loop"+i);
            cal.set(year1, month1 - 1, day1); // 1999
            Calendar call1 = Calendar.getInstance();
            call1.set(year1, month1 - 1, 1);

            lastday1 = call1.getActualMaximum(Calendar.DAY_OF_MONTH);
            lastday = lastday1;

            if (daycount > lastday1) {
                daycount = 1;
                day1 = 1;
                month1++;
                if (month1 > 12) {
                    month1 = 1;
                    year1++;
                }
            }
            day11 = String.valueOf(day1);
            month11 = String.valueOf(month1);
                         /*
                            if (year == year1) {
                                year1 = (year);
                            }
                            if (year > year1) {
                                System.out.println("year "+year);
                                System.out.println("year1 "+year1);
                                
                               // year1 = (year - 1);
                            }
*/
            if (day1 < 10) {
                day11 = "0" + day1;
            }
            if (month1 < 10) {
                month11 = "0" + month1;
            }
            deliverydate = day11 + "-" + month11 + "-" + year1;
            day1++;
            System.out.println(deliverydate);


        }
    }
}
