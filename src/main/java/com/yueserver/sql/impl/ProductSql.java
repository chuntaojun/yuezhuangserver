package com.yueserver.sql.impl;

import com.yueserver.enity.Product;
import com.yueserver.sql.ProductSqlInterface;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@Service("ProductSql")
public class ProductSql implements ProductSqlInterface {

    @Autowired(required = false)
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List queryPrdName() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.getNamedQuery("com.yueserver.enity.Product.queryPrdName");
            tx.commit();
            return query.list();
        } catch (HibernateException e) {
            tx.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean saveSinglePrd(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(product);
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
    public boolean saveBatchPrd(List<Product> prdList) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            int i = 0;
            for (Product product : prdList) {
                session.save(product);
                i ++;
                if (i == 50) {
                    session.flush();
                    session.clear();
                    i = 0;
                }
            }
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * 删除商品数据 (级联删除操作 商品图片以及视频操作)
     * @param prdNos
     * @return
     */
    @Override
    public boolean deleBatchPrd(List<Integer> prdNos) {
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
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateSinglePrd(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(product);
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
    public boolean updateBatchPrd(Map<String, Object> prdMap) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.doWork(connection -> {
                String sql = "";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            });
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
