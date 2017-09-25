package com.yueserver.sql.impl;

import com.yueserver.enity.nodao.MerchantTicket;
import com.yueserver.sql.TicketSqlInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("TicketSql")
public class TicketSql implements TicketSqlInterface {

    @Autowired
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean SaveMerchantTicket(MerchantTicket ticket) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(ticket);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateMerchantTicket(MerchantTicket ticket) {
        return false;
    }

    @Override
    public boolean deleteMerchantTicket(MerchantTicket ticket) {
        return false;
    }
}
