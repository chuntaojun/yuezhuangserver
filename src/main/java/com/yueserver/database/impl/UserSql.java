package com.yueserver.database.impl;

import com.yueserver.enity.User;
import com.yueserver.database.UserSqlInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserSql")
public class UserSql implements UserSqlInterface {

    @Autowired(required = false)
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List queryUserInfo() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "FROM User";
            Query query = session.createQuery(hql);
            transaction.commit();
            return query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean updateSingleUser(User user) {
        return false;
    }

}
