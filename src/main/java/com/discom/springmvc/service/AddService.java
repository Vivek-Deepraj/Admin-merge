package com.discom.springmvc.service;

import com.discom.springmvc.model.DateTimeQuantumModel;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;

import java.util.Collection;


public interface AddService {
    public boolean UpdateUser(User user);

    public void addPasswordHistory(Passwordhistorymaster passwordhistorymaster);

    public boolean updatePermission(Permissionmaster permissionmaster);

    public boolean savePermission(Permissionmaster permissionmaster);

    boolean saveActivitylog(Activitylog activitylog, String activity);

    public String getIomDetails(String id, String filePath);

    boolean saveDateTimeQuantumModel(DateTimeQuantumModel obj);

    boolean saveAgreementTariff(DateTimeQuantumModel obj);

    public String saveLosses(boolean newloss, String id, String issueDate, String fromDate, String toDate, String lossType, String filePath, String fileName);

    String hello();

    boolean updateRecordStatus(String id, String type, String status);

    boolean saveDiscomScheduleee(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollection);

    boolean saveDiscomSchedule(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollection, Emergencyschedulerevision emergencyschedulerevision);

    }

