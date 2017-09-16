package com.yueserver.sql.impl;

import com.yueserver.bean.Brand;
import com.yueserver.sql.BrandSqlInterface;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.yueserver.controller.LoginController.getPrincipal;

@Service("BrandSql")
public class BrandSql implements BrandSqlInterface {

    @Autowired(required = false)
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Brand getBrand(String brdname) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.getNamedQuery("com.yueserver.bean.Brand.querySingleBrand");
            query.setParameter("brdName", brdname);
            Brand brand = (Brand) query.list().iterator().next();
            transaction.commit();
            return brand;
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        } catch (NoSuchElementException e) {
            return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List queryBrd_PrdInfo() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            if (getPrincipal().getRole(getPrincipal().getAuthorities()).equals("ROLE_ADMIN")) {
                String hql = "FROM Brand";
                List list = session.createQuery(hql).list();
                transaction.commit();
                return list;
            } else {
                String hql = "FROM Brand b WHERE b.mctno=:mctno";
                Query query = session.createQuery(hql);
                query.setParameter("mctno", getPrincipal().getMctno());
                List list = query.list();
                transaction.commit();
                return list;
            }
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean saveSingleBrand(Brand brand) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(brand);
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

    @Override
    public boolean saveBatchBrand() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.doWork(connection -> {
                String sql = "";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            });
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
    public boolean delBatchBrand(Map<String, Object> brdMap) {
        return false;
    }

    @Override
    public boolean updateSingleBrand(Brand brand) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(brand);
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

    @Override
    public boolean updateBatchBrand(Map<String, Object> brdMap) {
        return false;
    }
}