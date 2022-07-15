package com.discom.springmvc.daoimpl;

import com.discom.springmvc.dao.ListDao;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository("listDao")
public class ListDaoImpl implements ListDao {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean checkUserId(String userid) {
        boolean res = false;
        //sessionFactory.getCurrentSession();
        return res;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllAdminList(int currPosition, int pageSize,
                                      String sSearch) {
        List<User> validAdminList = new ArrayList<User>();
        try {
            if (currPosition == 0 && pageSize == 0) {
                if (sSearch.trim().equals("")) {
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    " from User")

                            .list();
                } else {
                    System.out.println("in else part-" + sSearch);
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    "from User WHERE  (userid like '%"
                                            + sSearch + "%' or email like '%"
                                            + sSearch + "%' or firstName like '%"
                                            + sSearch + "%' or lastName like '%"
                                            + sSearch + "%') ")

                            .list();
                }
            } else {
                if (sSearch.trim().equals("")) {
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    " from User")
                            .setMaxResults(pageSize).setFirstResult(currPosition)
                            .list();
                } else {
                    System.out.println("in else part-" + sSearch);
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    "from User WHERE  (userid like '%"
                                            + sSearch + "%' or email like '%"
                                            + sSearch + "%' or firstName like '%"
                                            + sSearch + "%' or lastName like '%"
                                            + sSearch + "%') ")
                            .setMaxResults(pageSize).setFirstResult(currPosition)
                            .list();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return validAdminList;
    }

    public int getAllAdminListCount(String sSearch) {
        int total = (int) ((Long) sessionFactory.getCurrentSession().createQuery("select count(*) from  User ").iterate().next()).intValue();
        return total;
    }

    @SuppressWarnings("unchecked")
    public List<Constantslistsdetails> getAllConstantslistsdetailsList(int currPosition, int pageSize, String sSearch) {
        List<Constantslistsdetails> validAdminList = new ArrayList<Constantslistsdetails>();
        try {
            if (currPosition == 0 && pageSize == 0) {
                if (sSearch.trim().equals("")) {
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    " from Constantslistsdetails")

                            .list();
                } else {
                    System.out.println("in else part-" + sSearch);
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    "from Constantslistsdetails WHERE  (type like '%"
                                            + sSearch + "%' or code like '%"
                                            + sSearch + "%' or label like '%"
                                            + sSearch + "%') ")

                            .list();
                }
            } else {
                if (sSearch.trim().equals("")) {
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    " from Constantslistsdetails")
                            .setMaxResults(pageSize).setFirstResult(currPosition)
                            .list();
                } else {
                    System.out.println("in else part-" + sSearch);
                    validAdminList = sessionFactory
                            .getCurrentSession()
                            .createQuery(
                                    "from Constantslistsdetails WHERE  (type like '%"
                                            + sSearch + "%' or code like '%"
                                            + sSearch + "%' or label like '%"
                                            + sSearch + "%') ")
                            .setMaxResults(pageSize).setFirstResult(currPosition)
                            .list();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return validAdminList;
    }

    public int getAllConstantslistsdetailsListCount(String sSearch) {
        int total = (int) ((Long) sessionFactory.getCurrentSession().createQuery("select count(*) from  Constantslistsdetails ").iterate().next()).intValue();
        return total;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllAdminList(int currPosition, int pageSize, String sSearch, String list[]) {

        String list2[] = new String[4];
        list2[0] = "userid";
        list2[1] = "email";
        list2[2] = "user_profile_id";
        list2[3] = "joining_date";

        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " (a.userid like '%"
                    + sSearch + "%' or a.email like '%"
                    + sSearch + "%' or a.first_name like '%"
                    + sSearch + "%' or a.last_name like '%"
                    + sSearch + "%') ";
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (c == 0) {
                    if (list2[i].equals("user_profile_id")) {
                        qry += " where u." + list2[i] + " ='" + list[i] + "' ";
                    } else {
                        qry += " where a." + list2[i] + " ='" + list[i] + "' ";
                    }


                } else {
                    if (list2[i].equals("user_profile_id")) {
                        qry += " and u." + list2[i] + " ='" + list[i] + "' ";
                    } else {
                        qry += " and a." + list2[i] + " ='" + list[i] + "' ";
                    }
                }
                c++;
            }
        }
        //System.out.println("query is::"+qry);
        if (qry.equals("")) {
            if (qry2.equals("")) {

            } else {
                qry += " where ";
            }
        } else {
            if (qry2.equals("")) {

            } else {
                qry += " and ";
            }
        }

        List<User> scheduleList = sessionFactory.getCurrentSession()
                .createSQLQuery(" select a.id as id, a.userid as userid, a.email as email,"
                        + " a.first_name as firstName, a.last_name as lastName, DATE_FORMAT(a.joining_date,'%d-%m-%Y') as joiningDate, a.contact_no as contactNo, "
                        + " a.status as status, a.moduleno as consumerno, a.lastlogin_date as lastloginDate, "
                        + " DATE_FORMAT(a.lastlogin_date,'%d-%m-%Y %T') as lastlogin, a.isActive as isActive, IF(a.status, 'Active', 'Inactive') as status1, up.type as urole  "
                        + " from app_user a join app_user_user_profile u on a.id = u.user_id join user_profile up ON up.id = u.user_profile_id " + qry + qry2 + " order by a.joining_date desc ")

                .addScalar("id", IntegerType.INSTANCE)
                .addScalar("userid", StringType.INSTANCE)
                .addScalar("email", StringType.INSTANCE)
                .addScalar("firstName", StringType.INSTANCE)
                .addScalar("lastName", StringType.INSTANCE)
                .addScalar("joiningDate", StringType.INSTANCE)
                .addScalar("contactNo", StringType.INSTANCE)
                .addScalar("status", BooleanType.INSTANCE)
                .addScalar("consumerno", StringType.INSTANCE)
                .addScalar("lastloginDate", DateType.INSTANCE)
                .addScalar("lastlogin", StringType.INSTANCE)
                .addScalar("isActive", BooleanType.INSTANCE)
                .addScalar("status1", StringType.INSTANCE)
                .addScalar("urole", StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(User.class)).setMaxResults(pageSize).setFirstResult(currPosition).list();

        return scheduleList;
    }


    public int getAllAdminListCount(String sSearch, String list[]) {
        SQLQuery q = null;
        int total = 0;
        String list2[] = new String[4];
        list2[0] = "userid";
        list2[1] = "email";
        list2[2] = "user_profile_id";
        list2[3] = "joining_date";

        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";
        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " (a.userid like '%"
                    + sSearch + "%' or a.email like '%"
                    + sSearch + "%' or a.first_name like '%"
                    + sSearch + "%' or a.last_name like '%"
                    + sSearch + "%') ";
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (c == 0) {
                    if (list2[i].equals("user_profile_id")) {
                        qry += " where u." + list2[i] + " ='" + list[i] + "' ";
                    } else {
                        qry += " where a." + list2[i] + " ='" + list[i] + "' ";
                    }


                } else {
                    if (list2[i].equals("user_profile_id")) {
                        qry += " and u." + list2[i] + " ='" + list[i] + "' ";
                    } else {
                        qry += " and a." + list2[i] + " ='" + list[i] + "' ";
                    }
                }
                c++;
            }
        }
        //System.out.println("query is::"+qry);
        if (qry.equals("")) {
            if (qry2.equals("")) {

            } else {
                qry += " where ";
            }
        } else {
            if (qry2.equals("")) {

            } else {
                qry += " and ";
            }
        }

        q = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from  app_user a join app_user_user_profile u on a.id = u.user_id join user_profile up ON up.id = u.user_profile_id " + qry + qry2);
        List reslist = q.list();
        total = ((BigInteger) reslist.get(0)).intValue();
        return total;
    }


    @Transactional
    public List<EmailMaster> getRecordFromEmailMaster(String title, String type) {
        List<EmailMaster> list = sessionFactory.getCurrentSession().createQuery(" from EmailMaster where title='" + title + "' and setting='" + type + "' ").list();

        //System.out.println("email master list:"+list);

        return list;

    }


    @Transactional
    public List<Passwordhistorymaster> getPasswordHitory(String userid) {

        Query q = sessionFactory.getCurrentSession().createQuery("from Passwordhistorymaster where userMasterId='" + userid + "' order by createdOn DESC");
        q.setFirstResult(0);
        q.setMaxResults(5);
        return (List<Passwordhistorymaster>) q.list();

    }

    @Transactional
    public Passwordhistorymaster getLastPassword(String userid) {

        List<Passwordhistorymaster> q = sessionFactory.getCurrentSession().createQuery("from Passwordhistorymaster where userMasterId='" + userid + "' order by createdOn DESC").list();

        if (q.size() > 0)
            return (Passwordhistorymaster) q.get(0);
        else
            return null;

    }

    @Transactional
    public User getRecordByEmailId(String emailid) {
        List<User> list = sessionFactory.getCurrentSession().createQuery(" from User where email='" + emailid + "' ").list();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Transactional
    public List<Lossdata> getAllLossdataList(int ii, int j, String sSearch, String list[]) {
        String list2[] = new String[5];
        list2[0] = "issue_date";
        list2[1] = "start_date";
        list2[2] = "end_date";
        list2[3] = "loss_type";
        list2[4] = "file_name";
        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";

        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " ( a.id like '%" + sSearch + "%'  or a.issue_date like '%" + sSearch + "%'  or a.start_date like '%" + sSearch + "%'  or a.end_date like '%" + sSearch + "%'  or a.loss_type like '%" + sSearch + "%'  or a.file_name like '%" + sSearch + "%'  ) ";
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (c == 0) {
                    qry += " where a." + list2[i] + " ='" + list[i] + "' ";
                } else {
                    qry += " and a." + list2[i] + " ='" + list[i] + "' ";
                }
                c++;
            }
        }
        if (qry.equals("")) {
            if (!qry2.equals("")) {
                qry += " where ";
            }
        } else {
            if (!qry2.equals("")) {
                qry += " and ";
            }
        }
        List<Lossdata> recordList = sessionFactory.getCurrentSession()
                .createSQLQuery(" select  a.id as id, DATE_FORMAT(a.issue_date,'%d-%m-%Y') as issue_date1,DATE_FORMAT(a.start_date,'%d-%m-%Y')  as start_date1,DATE_FORMAT(a.end_date,'%d-%m-%Y')  as end_date1,a.loss_type as loss_type,a.file_name as file_name, a.status as status "
                        + " from lossdata a " + qry + qry2 + " order by a.id asc ")
                .addScalar("id", LongType.INSTANCE)
                .addScalar("issue_date1", StringType.INSTANCE)
                .addScalar("start_date1", StringType.INSTANCE)
                .addScalar("end_date1", StringType.INSTANCE)
                .addScalar("loss_type", StringType.INSTANCE)
                .addScalar("file_name", StringType.INSTANCE)
                .addScalar("status", StringType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(Lossdata.class)).setMaxResults(j).setFirstResult(ii).list();
        return recordList;
    }

    @Transactional
    public int getAllLossdataListCount(String sSearch, String list[]) {
        SQLQuery q = null;
        int total = 0;
        String list2[] = new String[5];
        list2[0] = "issue_date";
        list2[1] = "start_date";
        list2[2] = "end_date";
        list2[3] = "loss_type";
        list2[4] = "file_name";
        int c = 0;
        String qry = "", qry2 = "";
        if (sSearch == null)
            sSearch = "";

        if (sSearch.trim().equals("")) {
            qry2 += "";
        } else {
            qry2 += " ( a.id like '%" + sSearch + "%'  or a.issue_date like '%" + sSearch + "%'  or a.start_date like '%" + sSearch + "%'  or a.end_date like '%" + sSearch + "%'  or a.loss_type like '%" + sSearch + "%'  or a.file_name like '%" + sSearch + "%'  ) ";
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (c == 0) {
                    qry += " where a." + list2[i] + " ='" + list[i] + "' ";
                } else {
                    qry += " and a." + list2[i] + " ='" + list[i] + "' ";
                }
                c++;
            }
        }
        if (qry.equals("")) {
            if (!qry2.equals("")) {
                qry += " where ";
            }
        } else {
            if (!qry2.equals("")) {
                qry += " and ";
            }
        }
        q = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from  lossdata a  " + qry + qry2);
        List reslist = q.list();
        total = ((BigInteger) reslist.get(0)).intValue();
        return total;
    }

    @Transactional
    public List<Stateloss> getAllStateLossList(String id) {

        List list = new ArrayList();
        try {

            // list = sessionFactory.getCurrentSession().createQuery("from Stateloss where periodfrom='" + fromdate + "' and periodto='" + todate + "' and archive='" + status +
            // "'").list();
            list = sessionFactory.getCurrentSession().createQuery("from Stateloss where lossDataId='" + id + "'").list();

        } catch (Exception e) {

        }
        return list;
    }

    @Transactional
    public List<Newpocloss> getAllPOCLossList(String id) {
        List list = new ArrayList();

        try {
            list = sessionFactory.getCurrentSession().createQuery("from Newpocloss where lossDataId='" + id + "'").list();

        } catch (Exception e) {

        }
        return list;
    }


}
