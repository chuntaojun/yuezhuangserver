package com.yueserver.database.impl;

import com.yueserver.enity.MerchantTicket;
import com.yueserver.database.TicketSqlInterface;
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
    public boolean saveMerchantTicket(MerchantTicket ticket) {
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
        return VoucherTicket(ticket);
    }

    @Override
    public boolean deleteMerchantTicket(MerchantTicket ticket) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(ticket);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean VoucherTicket(MerchantTicket ticket) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(ticket);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            return false;
        } finally {
            session.close();
        }
    }
}
