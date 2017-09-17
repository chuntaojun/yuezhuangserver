package com.yueserver.sql.impl;

import com.yueserver.enity.Post;
import com.yueserver.sql.PostSqlInterface;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("PostSql")
public class PostSql implements PostSqlInterface {

    @Autowired(required = false)
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List queryPostInfo() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "FROM Post";
            List list = session.createQuery(hql).list();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean deleSinglePost(Post post) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(post);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleBatchPost(Map<String, Object> postMap) {
        return false;
    }
}
