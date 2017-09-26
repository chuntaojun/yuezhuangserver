package com.yueserver.sql.impl;

import com.yueserver.enity.PrdFav;
import com.yueserver.sql.PrdFavSqlInterface;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PrdFavSql")
public class PrdFavSql implements PrdFavSqlInterface {

    @Autowired
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean savePrdFav(PrdFav prdFav) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(prdFav);
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
    public List queryPrdFavData() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String sql = "SELECT UsrName, PrdLike, PrdNo FROM PrdFav";
            Query query = session.createNativeQuery(sql);
            return query.list();
        } catch (HibernateException e) {
            tx.rollback();
            return null;
        } finally {
            session.close();
        }
    }

}
