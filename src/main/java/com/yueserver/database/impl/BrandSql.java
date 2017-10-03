package com.yueserver.database.impl;

import com.yueserver.enity.Brand;
import com.yueserver.database.BrandSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("BrandSql")
public class BrandSql implements BrandSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public Brand getBrand(String brdname) {
        return null;
    }

    @Override
    public List queryBrd_PrdInfo() {
        return null;
    }

    @Override
    public List queryBrdName() {
        return null;
    }

    @Override
    public boolean saveSingleBrand(Brand brand) {
        return false;
    }

    @Override
    public boolean saveBatchBrand() {
        return false;
    }

    @Override
    public boolean delBatchBrand(Map<String, Object> brdMap) {
        return false;
    }

    @Override
    public boolean updateSingleBrand(Brand brand) {
        return false;
    }

    @Override
    public boolean updateBatchBrand(Map<String, Object> brdMap) {
        return false;
    }
}
