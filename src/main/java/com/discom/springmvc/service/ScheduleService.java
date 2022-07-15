package com.discom.springmvc.service;

public interface ScheduleService {
    public String newDiscomScheduleeexcelF(String date, String filepath);

    public String getScheduleMatchingData(String schedulemasterid);

    public String getScheduleDetailData(String schedulemasterid, String type);
}
