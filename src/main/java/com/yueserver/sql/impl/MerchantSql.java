package com.yueserver.sql.impl;

import com.yueserver.bean.Merchant;
import com.yueserver.bean.Product;
import com.yueserver.sql.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.yueserver.controller.LoginController.getPrincipal;

@Service("MerchantSql")
public class MerchantSql implements MerchantSqlInterface {

    @Autowired(required = false)
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    @Resource(name = "BrandSql")
    private BrandSqlInterface brandSqlInterface;

    @Autowired
    @Resource(name = "ProductSql")
    private ProductSqlInterface productSqlInterface;

    @Autowired
    @Resource(name = "PrdPicSql")
    private PrdPicSqlInterface prdPicSqlInterface;

    @Autowired
    @Resource(name = "PrdVidSql")
    private PrdVidSqlInterface prdVidSqlInterface;

    /**
     *
     * @param prdName
     * @return
     */
    @Override
    public Product getPrdInfo(String prdName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "SELECT DISTINCT p FROM Product p, Brand b WHERE p in elements(b.products) and b.mctno=? and p.prdname=?";
            Query query = session.createQuery(hql);
            query.setInteger(0, getPrincipal().getMctno());
            query.setString(1, prdName);
            Product product = (Product) query.list().iterator().next();
            transaction.commit();
            return product;
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List queryBrd_PrdInfo(int mctNo) {
        return brandSqlInterface.queryBrd_PrdInfo();
    }

    @Override
    public boolean saveSinglePrd(Product product, String brdName) {
        int brdNo = brandSqlInterface.getBrand(brdName).getBrdno();
        product.setBrdno(brdNo);
        return productSqlInterface.saveSinglePrd(product);
    }

    @Override
    public boolean saveBatchPrd(Map<String, Object> prdMap) {
        return false;
    }

    @Override
    public boolean saveBatchPrdPic(Map<String, Object> prdpicMap) {
        return prdPicSqlInterface.saveBatchPrdPic(prdpicMap);
    }

    @Override
    public boolean saveBatchPrdVid(Map<String, Object> prdvidMap) {
        return prdVidSqlInterface.saveBatchPrdVid(prdvidMap);
    }

    @Override
    public boolean updateSingleMerchant(Merchant merchant) {
        Session session = sessionFactory.openSession();
        try {
            session.update(merchant);
            session.beginTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
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
        return false;
    }

    @Override
    public boolean deleBatchPrdVid(Map<String, Object> prdvidMap) {

        return false;
    }

    @Override
    public boolean deleBatchPrdPic(Map<String, Object> prdpicMap) {
        return false;
    }

    @Override
    public boolean deleBatchPrd(Map<String, Object> prdMap) {
        return false;
    }

}
