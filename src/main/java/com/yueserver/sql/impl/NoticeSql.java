package com.yueserver.sql.impl;

import com.sun.xml.internal.ws.handler.HandlerException;
import com.yueserver.enity.Notice;
import com.yueserver.sql.NoticeSqlInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Secured("ROLE_ADMIN")
@Service("NoticeSql")
public class NoticeSql implements NoticeSqlInterface {

    @Autowired
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean SaveNotice(Notice notice) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(notice);
            tx.commit();
            return true;
        } catch (HandlerException e) {
            tx.rollback();
            return false;
        } finally {
            session.close();
        }
    }
}
