package com.discom.springmvc.daoimpl;

import com.discom.springmvc.dao.AddDao;
import com.discom.springmvc.dao.SearchDao;
import com.discom.springmvc.interceptor.AuditLogInterceptor;
import com.discom.springmvc.model.User;
import com.discom.springmvc.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;


@Repository("addDao")
@Transactional
public class AddDaoImpl implements AddDao {


    @Autowired
    SearchDao searchDao;
    @Autowired
    HttpServletRequest request;
    AuditLogInterceptor interceptor = new AuditLogInterceptor();
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean UpdateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        return true;
    }

    public void addPasswordHistory(Passwordhistorymaster passwordhistorymaster) {
        try {

            sessionFactory.getCurrentSession().save(passwordhistorymaster);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public boolean updatePermission(Permissionmaster permissionmaster) {
        sessionFactory.getCurrentSession().update(permissionmaster);
        return true;
    }

    @Transactional
    public boolean savePermission(Permissionmaster permissionmaster) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().save(permissionmaster);
            status = true;
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    @Transactional
    public boolean saveActivitylog(Activitylog activitylog) {
        boolean status = false;
        try {
            sessionFactory.getCurrentSession().save(activitylog);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean saveIomDetails(List<IomDetails> iomDetailsList) {
        boolean status = false;
        try {
            for (IomDetails iomDetails : iomDetailsList)
                sessionFactory.getCurrentSession().save(iomDetails);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }

    @Transactional
    public boolean deleteRecords(String query) {
        boolean status = false;
        try {
            int f = sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return status;
    }

//scheduling

    @Transactional
    public boolean updateRecordsStaus(String query) {
        boolean status = false;
        try {
            int f = sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return status;
    }

    @Transactional
    public boolean saveDiscomScheduleee(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollectiontemp) {
        boolean status = false;
        Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
        interceptor.setSession(session);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Collection<Discomschedulesources> scheduleSoucesCollection = schedulemaster.getDiscomschedulesourcesCollection();
            schedulemaster.setDiscomschedulesourcesCollection(null);

            session.save(schedulemaster);
            for (Discomschedulesources discomschedulesources : scheduleSoucesCollection) {
                discomschedulesources.setScheduleMasterid(schedulemaster);
                Collection<Discomscheduledetail> list = discomschedulesources.getDiscomscheduledetailCollection();
                discomschedulesources.setDiscomscheduledetailCollection(null);
                session.save(discomschedulesources);
                for (Discomscheduledetail discomscheduledetail : list) {
                    discomscheduledetail.setId(discomschedulesources);
                    session.save(discomscheduledetail);
                }
            }

            /*
             * List<Wpdfaxphoneemailmaster> faxphoneemail =
             * session.createQuery("from Wpdfaxphoneemailmaster where id='"+
             * schedulemaster.getId() + "'").list(); if(faxphoneemail.size()>0) { int k=0;
             * for(int i=0;i<faxphoneemail.size();i++) {
             * if(faxphoneemail.get(i).getType().equals("Email")) { Wpdmaster wpd =
             * faxphoneemail.get(i).getId(); String emailid =
             * faxphoneemail.get(i).getDetails(); SendingMail mail = new SendingMail();
             * String
             * str="<style type='text/css'><!--.style1 {font-family: Arial, Helvetica, sans-serif}--></style><p class='style1'><strong>Dear "
             * + wpd.getWpdname() +",</strong><br> <br> " +
             * " Welcome to PTC India Ltd.<br> " + " New Schedule Added. <br>" +
             * " Schedule Date : "+cdf.dataBaseFmt(schedulemaster.getScheduleDate())
             * +"  <br>" + " Rev No        : "+schedulemaster.getRevisionno()+". <br>" +
             * " Created on    : "+cdf.getScheduleCreatedOn(schedulemaster.getCreatedOn()+""
             * )+" <br>  <br>" +
             * " Should you not find what you are looking for,  please feel free to&nbsp;get in touch with  our"
             * + " support team at info@ptcindia.com. <br>  <br>" +
             * " <br> Best regards,<br> PTC India Ltd.<br> </p>";
             *
             * String subject="", from="", cc="", to=""; List<EmailMaster> emaildata =
             * session.createQuery(" from EmailMaster where title='NewScheduleMail' ").list(
             * ); if(emaildata!=null){ for(int j=0;j<emaildata.size();j++){ subject =
             * emaildata.get(j).getSubject(); from = emaildata.get(j).getFrom(); cc =
             * emaildata.get(j).getCc(); to = emaildata.get(j).getTo(); } }
             * mail.sendMailWithoutFile(wpd.getSetting(), emailid, from, subject, str,"");
             * if(k==0) mail.sendMailWithoutFile(wpd.getSetting(), to, from, subject,
             * str,cc);
             *
             * k++; } } }
             */

            //  Discomschedulemaster schedulemasterattached=searchDao.findDiscomScheduleById(schedulemaster.getDrawlmasterid()+"");

            //Discomschedulemaster schedulemasterattached= searchDao.getLastDiscomSchedule(schedulemaster.getScheduleDate());

            //session.update(schedulemasterattached);
            tx.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = false;

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    @Transactional
    public boolean saveDiscomSchedule(Discomschedulemaster schedulemaster, Collection<Discomschedulesources> scheduleSoucesCollectiontemp, Emergencyschedulerevision emergencyschedulerevision) {
        boolean status = false;
        Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
        interceptor.setSession(session);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Collection<Discomschedulesources> scheduleSoucesCollection = schedulemaster.getDiscomschedulesourcesCollection();
            schedulemaster.setDiscomschedulesourcesCollection(null);

            session.save(schedulemaster);
            for (Discomschedulesources discomschedulesources : scheduleSoucesCollection) {
                discomschedulesources.setScheduleMasterid(schedulemaster);
                Collection<Discomscheduledetail> list = discomschedulesources.getDiscomscheduledetailCollection();
                discomschedulesources.setDiscomscheduledetailCollection(null);
                session.save(discomschedulesources);
                for (Discomscheduledetail discomscheduledetail : list) {
                    discomscheduledetail.setId(discomschedulesources);
                    session.save(discomscheduledetail);
                }
            }
            System.out.println("DISCOMWITHEMERGENCY: " + emergencyschedulerevision);
            if (emergencyschedulerevision != null) {
                session.saveOrUpdate(emergencyschedulerevision);
            }

            tx.commit();
            status = true;
        } catch (Exception e) {
            if (!tx.getRollbackOnly())
                tx.rollback();
            e.printStackTrace();
            status = false;
        }
        if (status == true) {
            try {
                //	sendMailAfterScheduleConfirmation(schedulemaster, session);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }

    public boolean saveRLDCdataSchedule(Rldcschedulesources Rldcschedulesources) {
        boolean status = false;
        Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
        interceptor.setSession(session);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Collection<Rldcscheduledetail> rldcscheduledetailCollection = Rldcschedulesources.getRldcscheduledetailCollection();
            Rldcschedulesources.setRldcscheduledetailCollection(null);
            List<Rldcschedulesources> rldclist = sessionFactory.getCurrentSession().createQuery(" from Rldcschedulesources where scheduledate='" + Rldcschedulesources.getScheduledate() + "' and applicantname='" + Rldcschedulesources.getApplicantname() + "' and fromUtility='" + Rldcschedulesources.getFromUtility() + "' and toUtility='" + Rldcschedulesources.getToUtility() + "'  and approvalNo='" + Rldcschedulesources.getApprovalNo() + "'").list();
            if (rldclist.size() > 0) {
                Rldcschedulesources.setId(rldclist.get(0).getId());
                sessionFactory.getCurrentSession().evict(rldclist.get(0));

            }
            session.saveOrUpdate(Rldcschedulesources);
            for (Rldcscheduledetail eldcscheduledetail : rldcscheduledetailCollection) {
                List<Rldcscheduledetail> detaillist = sessionFactory.getCurrentSession().createQuery(" from Rldcscheduledetail where id='" + Rldcschedulesources.getId() + "' and timeslot='" + eldcscheduledetail.getTimeslot() + "'").list();
                if (detaillist.size() > 0) {
                    eldcscheduledetail.setRldcScheduleId(detaillist.get(0).getRldcScheduleId());
                    sessionFactory.getCurrentSession().evict(detaillist.get(0));
                }
                eldcscheduledetail.setId(Rldcschedulesources);

                session.saveOrUpdate(eldcscheduledetail);
            }

            tx.commit();
            status = true;
        } catch (Exception e) {
            if (!tx.getRollbackOnly())
                tx.rollback();
            e.printStackTrace();
            status = false;
        }
        if (status == true) {
            try {
                //	sendMailAfterScheduleConfirmation(schedulemaster, session);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }

    public boolean saveRldcdownloads(Rldcdownloads rldcdownloads) {
        boolean status = false;
        try {
            System.out.println("insaving ");
            sessionFactory.getCurrentSession().save(rldcdownloads);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return status;
    }


}
