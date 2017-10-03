package com.yueserver.database.impl;

import com.yueserver.enity.Product;
import com.yueserver.database.ProductSqlInterface;

import net.sf.json.JSONArray;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("ProductSql")
public class ProductSql implements ProductSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public Product getPrdInfo(String prdName) {
        return null;
    }

    @Override
    public List queryProductInfo(JSONArray prdId) {
        return null;
    }

    @Override
    public List queryPrdName() {
        return null;
    }

    @Override
    public boolean saveSinglePrd(Product product) {
        return false;
    }

    @Override
    public boolean saveBatchPrd(List<Product> prdList) {
        return false;
    }

    @Override
    public boolean deleBatchPrd(List<Integer> prdNos) {
        return false;
    }

    @Override
    public boolean updateSinglePrd(Product product) {
        return false;
    }

    @Override
    public boolean updateBatchPrd(Map<String, Object> prdMap) {
        return false;
    }
}
