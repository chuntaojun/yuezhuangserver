package com.yueserver.sql.impl;

import com.yueserver.enity.nodao.ForgotPassword;
import com.yueserver.sql.LoginSqlInterface;
import com.yueserver.enity.Merchant;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LoginSql")
public class LoginSql implements LoginSqlInterface {

    @Autowired(required = false)
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * 判断用户注册时用户名是否存在
     * @param mctaccount
     * @return
     */
    @Override
    public boolean getExistUser(String mctaccount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.getNamedQuery("resigterMerchant");
            query.setParameter("mctaccount", mctaccount);
            List list = query.list();
            transaction.commit();
            if (list.size() != 0)
                return true;
            return false;
        } catch (HibernateException e) {
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }

    /**
     * 根据用户名获取数据库对应的数据
     * @param mctaccount
     * @param adminaccount
     * @return
     */
    @Override
    public List getLoginObject(String mctaccount, String adminaccount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "FROM Administator a, Merchant m WHERE a.admaccount=:adminaccount or m.mctaccount=:mctaccount";
            Query query = session.createQuery(hql);
            query.setParameter("adminaccount", adminaccount);
            query.setParameter("mctaccount", mctaccount);
            return query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    /**
     * 用户更改密码
     * @param forgotPassword
     * @return
     */
    @Override
    public boolean updatePassword(ForgotPassword forgotPassword) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.getNamedQuery("resigterMerchant");
            query.setParameter("mctaccount", forgotPassword.getUsername());
            Merchant updateMerchant = (Merchant) query.list().iterator();
            updateMerchant.setMctpassword(forgotPassword.getPassword());
            session.save(updateMerchant);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }

    /**
     * 用户注册
     * @param merchant
     * @return
     */
    @Override
    public boolean saveNewAccount(Merchant merchant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(merchant);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }
}
