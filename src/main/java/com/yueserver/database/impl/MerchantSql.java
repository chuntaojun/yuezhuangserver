package com.yueserver.database.impl;

import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;
import com.yueserver.database.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("MerchantSql")
public class MerchantSql implements MerchantSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

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


    @Override
    public Product getPrdInfo(String prdName) {
        return null;
    }

    @Override
    public List queryBrd_PrdInfo(int mctNo) {
        return null;
    }

    @Override
    public boolean saveSinglePrd(Product product, String brdName) {
        return false;
    }

    @Override
    public boolean saveBatchPrd(Map<String, Object> prdJson) {
        return false;
    }

    @Override
    public boolean saveBatchPrdPic(Map<String, Object> prdpicMap) {
        return false;
    }

    @Override
    public boolean saveBatchPrdVid(Map<String, Object> prdvidJson) {
        return false;
    }

    @Override
    public boolean updateSingleMerchant(Merchant merchant) {
        return false;
    }

    @Override
    public boolean updateSinglePrd(Product product) {
        return false;
    }

    @Override
    public boolean updateBatchPrd(Map<String, Object> prdJson) {
        return false;
    }

    @Override
    public boolean deleBatchPrdVid(Map<String, Object> prdvidJson) {
        return false;
    }

    @Override
    public boolean deleBatchPrdPic(Map<String, Object> prdpicJson) {
        return false;
    }

    @Override
    public boolean deleBatchPrd(Map<String, Object> prdJson) {
        return false;
    }
}
