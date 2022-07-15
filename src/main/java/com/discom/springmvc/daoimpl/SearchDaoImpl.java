package com.discom.springmvc.daoimpl;

import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.model.DataTableModel;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;


@Repository("searchDao")
@Transactional
public class SearchDaoImpl implements SearchDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public User findUserByMasterId(int id) {
        List<User> list = sessionFactory.getCurrentSession()
                .createQuery("from User where id=" + id + "")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public User findUserByUserId(String userid) {
        List<User> list = sessionFactory.getCurrentSession()
                .createQuery("from User where userid='" + userid + "'")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public List<User> checkEmail(String emailid) {
        List<User> list = sessionFactory.getCurrentSession().createQuery(" from User where email='" + emailid + "' ").list();

        return list;
    }


    public Permissionmaster getPermissionmaster(String id, String url) {

        List<Permissionmaster> list = sessionFactory.getCurrentSession()
                .createQuery("from Permissionmaster where userMasterId='" + id + "' and url='" + url + "' ").list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public List<Contacts> findContactsById(String candidateid) {
        List<Contacts> list = sessionFactory.getCurrentSession()
                .createQuery("from Contacts where candidateid='" + candidateid + "'")
                .list();

        return list;
    }

    @Transactional
    public Contacts getContactsById(String candidateid) {
        List<Contacts> list = sessionFactory.getCurrentSession()
                .createQuery("from Contacts where candidateid='" + candidateid + "'")
                .list();

        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public List<Constantslistsdetails> findMasterData() {
        List<Constantslistsdetails> list = sessionFactory.getCurrentSession()
                .createQuery("from Constantslistsdetails ")
                .list();

        return list;
    }


    @SuppressWarnings("unchecked")
    public DataTableModel findMasterData(int start, int length, String sSearch, String sList[]) {

        DataTableModel dataModel = new DataTableModel();
        String list2[] = new String[3];
        list2[0] = "type";
        list2[1] = "code";
        list2[2] = "label";

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Constantslistsdetails.class).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                criteria.add(Restrictions.eq(list2[i], sList[i]));
            }
        }
        if (sSearch != null && !sSearch.equals("")) {
            criteria.add(Restrictions.disjunction()
                    .add(Restrictions.like("label", "%" + sSearch + "%", MatchMode.START))
                    .add(Restrictions.like("code", "%" + sSearch + "%", MatchMode.START))
                    .add(Restrictions.like("type", "%" + sSearch + "%", MatchMode.START)));
        }
        criteria.setFirstResult(start);
        criteria.setMaxResults(length);
        List<Constantslistsdetails> constantslistsdetails = (List<Constantslistsdetails>) criteria.list();
        int total = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        dataModel.setEntities(constantslistsdetails);
        dataModel.setTotalCount(total);
        return dataModel;
    }

    public DataTableModel getConstantslistsdetailsDT(int start, int length, String sSearch, String sList[]) {

        String cList[] = {"type", "code", "label"};// column name as in pojo not in database
        String gscList[] = {"type", "code", "label"};// column name as in pojo not in database
        return executeDataTableObjectBuilder(Constantslistsdetails.class, start, length, sSearch, sList, cList, gscList);
    }

    public DataTableModel executeDataTableObjectBuilder(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]) {

        DataTableModel dataModel = new DataTableModel();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], sList[i]));
            }
        }
        if (sSearch != null && !sSearch.equals("")) {
            Disjunction disjunction = Restrictions.disjunction();
            for (String column : gscList) {
                disjunction.add(Restrictions.like(column, "%" + sSearch + "%", MatchMode.START));
            }
            criteria.add(disjunction);
        }
        criteria.setFirstResult(start);
        criteria.setMaxResults(length);
        List<?> dataList = (List<?>) criteria.list();
        dataModel.setEntities(dataList);
        criteria.setFirstResult(0);
        criteria.setMaxResults(1000000000);
        int total = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        dataModel.setTotalCount(total);
        return dataModel;
    }


    public DataTableModel executeDataTableObjectBuilderConstantsLists(Class<?> pojoClass, int start, int length, String sSearch, String sList[], String cList[], String gscList[]) {

        DataTableModel dataModel = new DataTableModel();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(pojoClass).addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                criteria.add(Restrictions.eq(cList[i], sList[i]));
            }
        }
        if (sSearch != null && !sSearch.equals("")) {
            Disjunction disjunction = Restrictions.disjunction();
            for (String column : gscList) {
                disjunction.add(Restrictions.like(column, "%" + sSearch + "%", MatchMode.START));
            }
            criteria.add(disjunction);
        }
        criteria.setFirstResult(start);
        criteria.setMaxResults(length);
        List<?> dataList = (List<?>) criteria.setProjection(Projections.groupProperty("type").as("type")).list();
        dataModel.setEntities(dataList);
        criteria.setFirstResult(0);
        criteria.setMaxResults(1000000000);
        System.out.println(dataList.size() + " dataListSIZEEE");
//		  DetachedCriteria dcrit = DetachedCriteria.forClass(pojoClass);
//		  dcrit.setProjection(Projections.projectionList().add(Projections.groupProperty("type")).add(Projections.max("id").as("id")));
//		  
//		  DetachedCriteria dcritt = DetachedCriteria.forClass(pojoClass);
//		  dcritt.setProjection(Projections.projectionList().add(Projections.max("id").as("id")));
//		  dcritt.add(Subqueries.propertyIn("id", dcrit));
//		  criteria.add(Subqueries.propertyIn("id", dcritt));
        int total = ((Number) criteria.setProjection(Projections.countDistinct("type")).uniqueResult()).intValue();
        System.out.println(total + " Totalll");
        dataModel.setTotalCount(total);
        return dataModel;
    }

    @Transactional
    public boolean executePojoSaveObjectBuilder(Class<?> pojoClass) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().save(pojoClass);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean executePojoUpdateObjectBuilder(Class<?> pojoClass) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().update(pojoClass);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean executePojoDeleteObjectBuilder(Class<?> pojoClass) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().delete(pojoClass);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @SuppressWarnings("unchecked")
    public List<Constantslistsdetails> findMasterDataa(int start, int length, String sSearch, String sList[]) {

        String list2[] = new String[3];
        list2[0] = "type";
        list2[1] = "code";
        list2[2] = "label";

        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " (a.type like '%"
                    + sSearch + "%' or a.code like '%"
                    + sSearch + "%' or a.label like '%"
                    + sSearch + "%') ";
        }

        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                if (c == 0) {
                    qry += " where a." + list2[i] + " ='" + sList[i] + "' ";
                } else {
                    qry += " and a." + list2[i] + " ='" + sList[i] + "' ";
                }
                c++;
            }
        }
        //System.out.println("query is::"+qry);
        if (qry.equals("")) {
            if (!qry2.equals("")) {
                qry += " where ";
            }
        } else {
            if (!qry2.equals("")) {
                qry += " and ";
            }
        }

        List<Constantslistsdetails> scheduleList = sessionFactory.getCurrentSession()
                .createSQLQuery(" select a.id as id, a.type as type, a.code as code, a.label as label"
                        //+ " DATE_FORMAT(a.joining_date,'%d-%m-%Y') as joiningDate, "
                        //+ " DATE_FORMAT(a.lastlogin_date,'%d-%m-%Y %T') as lastlogin "
                        + " from constantslistsdetails a " + qry + qry2 + " order by id asc ")

                .addScalar("id", LongType.INSTANCE)
                .addScalar("type", StringType.INSTANCE)
                .addScalar("code", StringType.INSTANCE)
                .addScalar("label", StringType.INSTANCE)
                // .addScalar("joiningDate",StringType.INSTANCE)
                // .addScalar("lastlogin",StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(Constantslistsdetails.class)).setMaxResults(length).setFirstResult(start).list();

        return scheduleList;
    }

    public int findMasterDataCountt(String sSearch, String sList[]) {
        SQLQuery q = null;
        int total = 0;
        String list2[] = new String[3];
        list2[0] = "type";
        list2[1] = "code";
        list2[2] = "label";

        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " (a.type like '%"
                    + sSearch + "%' or a.code like '%"
                    + sSearch + "%' or a.label like '%"
                    + sSearch + "%') ";
        }

        for (int i = 0; i < sList.length; i++) {
            if (sList[i] != null && !sList[i].equals("")) {
                if (c == 0) {
                    qry += " where a." + list2[i] + " ='" + sList[i] + "' ";
                } else {
                    qry += " and a." + list2[i] + " ='" + sList[i] + "' ";
                }
                c++;
            }
        }
        //System.out.println("query is::"+qry);
        if (qry.equals("")) {
            if (!qry2.equals("")) {
                qry += " where ";
            }
        } else {
            if (!qry2.equals("")) {
                qry += " and ";
            }
        }

        q = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from  constantslistsdetails a " + qry + qry2);
        List reslist = q.list();
        total = ((BigInteger) reslist.get(0)).intValue();
        return total;
    }

    @Transactional
    public Constantslistsdetails findMasterDataById(String id) {
        List<Constantslistsdetails> list = sessionFactory.getCurrentSession()
                .createQuery("from Constantslistsdetails where id='" + id + "'")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public List<Constantslistsdetails> findMasterDataByType(String type) {
        List<Constantslistsdetails> list = sessionFactory.getCurrentSession()
                .createQuery("from Constantslistsdetails where type='" + type + "'")
                .list();

        return list;
    }

    @Transactional
    public Constantslistsdetails findMasterDataByType(String type, String code) {
        List<Constantslistsdetails> list = sessionFactory.getCurrentSession()
                .createQuery("from Constantslistsdetails where type='" + type + "' and code='" + code + "'")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public List<Constantslistsdetails> findMasterDataTypes() {
        List<Constantslistsdetails> list = sessionFactory.getCurrentSession()
                .createQuery("from Constantslistsdetails group by type")
                .list();

        return list;
    }

    //schedule

    @Transactional
    public Agreementmastersnapshot findLastAgreementSnapShotByAgreementId(String id) {
        List<Agreementmastersnapshot> list = sessionFactory.getCurrentSession()
                .createQuery("from Agreementmastersnapshot where agreementMasterId='" + id + "' order by agreementSnapshotMasterId desc")
                .list();
        //System.out.println("list l  "+list);
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public Agreementmastersnapshot findLastAgreementSnapShotByAgreementSnapshotMasterId(String agreementSnapshotMasterId) {
        List<Agreementmastersnapshot> list = sessionFactory.getCurrentSession()
                .createQuery("from Agreementmastersnapshot where agreementSnapshotMasterId='" + agreementSnapshotMasterId + "' ")
                .list();
        //System.out.println("list l  "+list);
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public List<Agreementmaster> getWpdActiveAgreementsListByWPDIDForSchedule(String date, String sellerportfolio, String ltoano) {
        System.out.println("isnide check");
        System.out.println("sellerportfolio "+sellerportfolio+" ltoano "+ltoano);
        List<Agreementmaster> list = sessionFactory.getCurrentSession()
                .createQuery("from Agreementmaster where sellerportfolio='" + sellerportfolio + "' and ltoano='" + ltoano + "' and revise=false and status='Active' and '" + date + "' between stratDate and endDate order by agreementorder asc ")
                .list();
        return list;
    }

    @Transactional
    public List<Agreementmaster> getWpdActiveAgreementsListByApprovalNoForSchedule(String date, String ppadiscomname, String psadiscomname, String approvalno) {
        System.out.println("ppadiscomname " + ppadiscomname + " psadiscomname " + psadiscomname + " approvalno " + approvalno);
        List<Agreementmaster> list = sessionFactory.getCurrentSession()
                .createQuery("from Agreementmaster where ppadiscomname='" + ppadiscomname + "' and psadiscomname='" + psadiscomname + "'  and approvalNo='" + approvalno + "'  and revise=false and status='Active' and '" + date + "' between stratDate and endDate order by agreementorder asc ")
                .list();
        return list;
    }


    //scheduling


    public List<Discomschedulemaster> findDiscomschedulemasterByForDownloadRLDC(List<String> dates) {

        List<Discomschedulemaster> scheduleList = sessionFactory.getCurrentSession().createSQLQuery("  select a.schedule_masterid as scheduleMasterid, a.id as id,DATE_FORMAT(a.created_on,'%d-%m-%Y %T') as creationDate, DATE_FORMAT(a.schedule_date,'%d-%m-%Y') as scheduleDate, a.revisionno as revisionno,a.sendmail as sendmail,a.download as download,b.wpdid as wpdid,b.wpdname as wpdname, b.region as region from Discomschedulemaster a join Wpdmaster b on a.id = b.id where (a.schedule_date='" + dates.get(0) + "' or a.schedule_date='" + dates.get(1) + "') and rldcdownload=false order by a.schedule_date desc, a.created_on desc")

                .addScalar("scheduleMasterid", LongType.INSTANCE)
                .addScalar("id", LongType.INSTANCE)
                .addScalar("creationDate", StringType.INSTANCE)
                .addScalar("scheduleDate", StringType.INSTANCE)
                .addScalar("revisionno", IntegerType.INSTANCE)
                .addScalar("sendmail", BooleanType.INSTANCE)
                .addScalar("download", BooleanType.INSTANCE)
                .addScalar("wpdid", StringType.INSTANCE)
                .addScalar("wpdname", StringType.INSTANCE)
                .addScalar("region", StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(Discomschedulemaster.class)).list();
        if (scheduleList.size() > 0)
            return scheduleList;
        else
            return null;
    }

    @Transactional
    public List<Discomschedulesources> findByScheduleMasterId(String scheduleid) {
        List<Discomschedulesources> list = sessionFactory.getCurrentSession().createQuery("from Discomschedulesources where scheduleMasterid='" + scheduleid + "' ").list();
        return list;
    }

    @Transactional
    public List<Discomscheduledetail> findBySourceMasterId(String id) {
        List<Discomscheduledetail> list = sessionFactory.getCurrentSession().createQuery("from Discomscheduledetail where id='" + id + "' ").list();
        return list;
    }

    @Transactional
    public List<Discomschedulesourcestotal> getREAReportData(String sellerportfolio, String buyerportfolio, String fromdate, String todate) {
        List<Discomschedulesourcestotal> list = sessionFactory.getCurrentSession().createQuery("from Discomschedulesourcestotal where sellerportfolio='" + sellerportfolio + "' and buyerportfolio='" + buyerportfolio + "' and scheduledate>='" + fromdate + "' and scheduledate<='" + todate + "' ").list();
        if (list.size() > 0)
            return list;
        else
            return null;
    }

    @Transactional
    public Discomschedulemaster getLastRevOfDiscomSchedule(String date, String id, String ltoano) {
        List<Discomschedulemaster> list = sessionFactory.getCurrentSession()
                .createQuery("from Discomschedulemaster where scheduleDate='" + date + "' and ltoano='" + ltoano + "' and id='" + id + "' order by revisionno desc").setMaxResults(1)
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public Discomschedulemaster findDiscomScheduleById(String scheduleid) {
        List<Discomschedulemaster> list = sessionFactory.getCurrentSession()
                .createQuery("from Discomschedulemaster where scheduleMasterid='" + scheduleid + "' ")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public List<Rldcsetting> getRldcList() {
        List<Rldcsetting> list = sessionFactory.getCurrentSession()
                .createQuery("from Rldcsetting ")
                .list();
        return list;
    }

    public Scheduledatafile getScheduledatafile(String wpdid, String scheduleDate) {
        List<Scheduledatafile> list = sessionFactory.getCurrentSession()
                .createQuery("from Scheduledatafile where wpdid='" + wpdid + "' and scheduleDate='" + scheduleDate + "' order by id desc ")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public Wpdregionnames getWpdregionnamesListByWPDIDRID(String id, String regionid) {
        List<Wpdregionnames> list = sessionFactory.getCurrentSession()
                .createQuery("from Wpdregionnames where id='" + id + "' and regionid='" + regionid + "' ").list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public Wpdregionnames getWpdregionnamesByWPDMIDRegionShortName(String id, String regionshortname) {
        List<Wpdregionnames> list = sessionFactory.getCurrentSession()
                .createQuery("from Wpdregionnames where id='" + id + "' and regionshortname='" + regionshortname + "' ").list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public Rldcdownloads getRldcDownloaddatafileRegionWise(String scheduleid, String scheduleDate, String revno, String wpdmasterid, String regionfor) {
        List<Rldcdownloads> list = sessionFactory.getCurrentSession()
                .createQuery("from Rldcdownloads where schedulemasterid='" + scheduleid + "' and scheduledate='" + scheduleDate + "' and revno='" + revno + "' and wpdmasterid='" + wpdmasterid + "' and regionfor='" + regionfor + "' order by masterid desc ")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public Setting getSettingByLabel(String label) {
        List<Setting> list = sessionFactory.getCurrentSession()
                .createQuery("from Setting where label='" + label + "'")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public Schedulesetting getScheduleSettingByLabel(String label) {
        List<Schedulesetting> list = sessionFactory.getCurrentSession()
                .createQuery("from Schedulesetting where label='" + label + "'")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public Emergencyschedulerevision getEmergencyschedulerevision(String wpdmasterid, String scheduleDate, String ltoano) {
        List<Emergencyschedulerevision> list = sessionFactory.getCurrentSession()
                .createQuery("from Emergencyschedulerevision where wpdmasterid='" + wpdmasterid + "' and ltoano='" + ltoano + "' and scheduleDate='" + scheduleDate + "' ")
                .list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public List<Rldcschedulesources> findByRldcScheduleMasterId(String scheduledate, String buyer, String seller, String approvalno) {
        List<Rldcschedulesources> list = sessionFactory.getCurrentSession().createQuery("from Rldcschedulesources where scheduledate='" + scheduledate + "' and fromUtility='" + seller + "' and toUtility='" + buyer + "' and approvalNo='" + approvalno + "' ").list();
        return list;
    }

    @Transactional
    public List<Rldcschedulesources> findByRldcScheduleMasterId(String schedulemasterid) {
        List<Rldcschedulesources> list = sessionFactory.getCurrentSession().createQuery("from Rldcschedulesources where id='" + schedulemasterid + "'").list();
        return list;
    }

    @Transactional
    public List<Rldcscheduledetail> findByRldcSourceMasterId(String id) {
        List<Rldcscheduledetail> list = sessionFactory.getCurrentSession().createQuery("from Rldcscheduledetail where id='" + id + "' ").list();
        return list;
    }

}
