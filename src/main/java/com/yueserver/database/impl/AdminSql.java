package com.yueserver.database.impl;

import com.yueserver.enity.Brand;
import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;
import com.yueserver.enity.User;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.database.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("AdminSql")
public class AdminSql implements AdminSqlInterface {

    @Autowired(required = false)
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    @Resource(name = "BrandSql")
    private BrandSqlInterface brandSqlInterface;

    @Autowired
    @Resource(name = "ProductSql")
    private ProductSqlInterface productSqlInterface;

    @Autowired
    @Resource(name = "PostSql")
    private PostSqlInterface postSqlInterface;

    @Autowired
    @Resource(name = "UserSql")
    private UserSqlInterface userSqlInterface;

    /**
     *
     * @return
     */
    @Override
    public List queryBrd_PrdInfo() {
        return brandSqlInterface.queryBrd_PrdInfo();
    }

    /**
     *
     * @return
     */
    @Override
    public List queryPostInfo() {
        return postSqlInterface.queryPostInfo();
    }

    /**
     *
     * @return
     */
    @Override
    public List queryMerchantInfo() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List list = session.getNamedQuery("queryMerchantInfo").list();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List queryUserInfo() {
        return userSqlInterface.queryUserInfo();
    }

    @Override
    public boolean saveSingleBrand(Brand brand) {
        return brandSqlInterface.saveSingleBrand(brand);
    }

    @Override
    public boolean saveBatchBrand() {
        return brandSqlInterface.saveBatchBrand();
    }

    @Override
    public boolean saveBatchPrdPic(Map<String, Object> prdpicMap) {
        return false;
    }

    @Override
    public boolean saveBatchPrdVid(Map<String, Object> prdvidMap) {
        return false;
    }

    @Override
    public boolean saveSinglePrd(Product product) {
        return productSqlInterface.saveSinglePrd(product);
    }

    @Override
    public boolean saveBatchPrd(List<Product> prdList) {
        return productSqlInterface.saveBatchPrd(prdList);
    }

    @Override
    public boolean deleBatchPrd(ResultBean<List> prdNos) {
        return productSqlInterface.deleBatchPrd(prdNos.getData());
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
    public boolean delBatchBrand(Map<String, Object> brdMap) {
        return brandSqlInterface.delBatchBrand(brdMap);
    }

    @Override
    public boolean deleBatchPost(Map<String, Object> postMap) {
        return postSqlInterface.deleBatchPost(postMap);
    }

    @Override
    public boolean updateSingleMerchant(Merchant merchant) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Merchant merchant1 = session.get(merchant.getClass(), merchant.getMctno());
            merchant1.setMctstate(merchant.getMctstate());
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
    public boolean updateSingleBrand(Brand brand) {
        return brandSqlInterface.updateSingleBrand(brand);
    }

    @Override
    public boolean updateBatchBrand(Map<String, Object> brdMap) {
        return brandSqlInterface.updateBatchBrand(brdMap);
    }

    @Override
    public boolean updateSingleUser(User user) {
        return userSqlInterface.updateSingleUser(user);
    }

    @Override
    public boolean updateSinglePrd(Product product) {
        return productSqlInterface.updateSinglePrd(product);
    }

    @Override
    public boolean updateBatchPrd(List<Product> prdList) {
        return productSqlInterface.saveBatchPrd(prdList);
    }

}
