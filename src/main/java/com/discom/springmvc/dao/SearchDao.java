package com.discom.springmvc.dao;

import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;

import java.util.List;


public interface SearchDao {
    public User findUserByMasterId(int id);

    public User findUserByUserId(String userid);

    List<User> checkEmail(String emailid);

    public Permissionmaster getPermissionmaster(String id, String url);

    public List<Constantslistsdetails> findMasterData();

    public DataTableModel getConstantslistsdetailsDT(int start, int length, String sSearch, String sList[]);

    public DataTableModel executeDataTableObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]);

    public DataTableModel executeDataTableObjectBuilderConstantsLists(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]);

    public DataTableModel findMasterData(int start, int length, String sSearch, String sList[]);

    public List<Constantslistsdetails> findMasterDataa(int start, int length, String sSearch, String sList[]);

    public int findMasterDataCountt(String sSearch, String sList[]);

    public Constantslistsdetails findMasterDataById(String id);

    public List<Constantslistsdetails> findMasterDataByType(String type);

    public Constantslistsdetails findMasterDataByType(String type, String code);

    public List<Constantslistsdetails> findMasterDataTypes();

    public Agreementmastersnapshot findLastAgreementSnapShotByAgreementId(String id);

    public Agreementmastersnapshot findLastAgreementSnapShotByAgreementSnapshotMasterId(String agreementSnapshotMasterId);

    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String sellerportfolio, String ltoano);

    public List<Agreementmaster> getWpdActiveAgreementsListByApprovalNoForSchedule(String date, String ppadiscomname, String psadiscomname, String approvalno);
//scheduling


    public List<Discomschedulemaster> findDiscomschedulemasterByForDownloadRLDC(List<String> dates);

    public List<Discomschedulesources> findByScheduleMasterId(String scheduleid);

    public List<Discomscheduledetail> findBySourceMasterId(String id);

    public List<Discomschedulesourcestotal> getREAReportData(String sellerportfolio, String buyerportfolio, String fromdate, String todate);

    public Discomschedulemaster getLastRevOfDiscomSchedule(String date, String id, String ltoano);

    public Discomschedulemaster findDiscomScheduleById(String scheduleid);

    public List<Rldcsetting> getRldcList();

    public Scheduledatafile getScheduledatafile(String wpdid, String scheduleDate);

    public Wpdregionnames getWpdregionnamesListByWPDIDRID(String id, String regionid);

    public Wpdregionnames getWpdregionnamesByWPDMIDRegionShortName(String id, String regionshortname);

    public Rldcdownloads getRldcDownloaddatafileRegionWise(String scheduleid, String scheduleDate, String revno, String wpdmasterid, String regionfor);

    public Setting getSettingByLabel(String label);

    public Schedulesetting getScheduleSettingByLabel(String label);

    public Emergencyschedulerevision getEmergencyschedulerevision(String wpdmasterid, String scheduleDate, String ltoano);

    public List<Rldcschedulesources> findByRldcScheduleMasterId(String scheduledate, String buyer, String seller, String approvalno);

    public List<Rldcschedulesources> findByRldcScheduleMasterId(String schedulemasterid);

    public List<Rldcscheduledetail> findByRldcSourceMasterId(String id);
}
