package com.discom.springmvc.interceptor;

import com.discom.springmvc.dao.IAuditLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
//import com.discom.springmvc.pojo.Auditlog;


public class AuditLogUtil {
    @Autowired
    private SessionFactory sessionFactory;

    public void LogIt(String action,
                      IAuditLog entity, Session conn) {

        Session tempSession = conn;

        try {
            Date saveDate = new Date();
            Timestamp timeStampDate = new Timestamp(saveDate.getTime());

            //Auditlog auditRecord = new Auditlog(action,entity.getLogDeatil(), timeStampDate,entity.getAUId(), entity.getClass().toString());
            //	tempSession.save(auditRecord);
            //tempSession.flush();

        } finally {
            //tempSession.close();
        }
    }
}
