package com.discom.springmvc.dao;

import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;

import java.util.Collection;
import java.util.List;


public interface AddDao {
    boolean UpdateUser(User user);

    public void addPasswordHistory(Passwordhistorymaster passwordhistorymaster);

    boolean updatePermission(Permissionmaster permissionmaster);

    boolean savePermission(Permissionmaster permissionmaster);

    boolean saveActivitylog(Activitylog activitylog);

    boolean saveIomDetails(List<IomDetails> iomDetailsList);

    boolean deleteRecords(String query);

    boolean updateRecordsStaus(String query);

    boolean saveDiscomScheduleee(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollectiontemp);

    boolean saveDiscomSchedule(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollectiontemp, Emergencyschedulerevision emergencyschedulerevision);

    boolean saveRLDCdataSchedule(Rldcschedulesources Rldcschedulesources);

    public boolean saveRldcdownloads(Rldcdownloads rldcdownloads);

}
