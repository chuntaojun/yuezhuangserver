package com.yueserver.database.impl;

import com.yueserver.database.dao.ProductMapper;
import com.yueserver.enity.Product;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

@Service("ProductSql")
public class ProductSql implements ProductMapper {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product getPrdInfo(String prdName) {
        return this.productMapper.getPrdInfo(prdName);
    }

    @Override
    public List queryMerchantPrd(int mctNo) {
        return this.productMapper.queryMerchantPrd(mctNo);
    }

    @Override
    public List queryRecommendPrd(JSONArray prdIds) {
        return this.productMapper.queryRecommendPrd(prdIds);
    }

    @Override
    public List queryProductInfo() {
        return this.productMapper.queryProductInfo();
    }


    @Override
    public List queryPrdName(int mctNo) {
        return this.productMapper.queryPrdName(mctNo);
    }

    @Override
    public boolean saveBatchPrd(List<Product> products) {
        return this.saveBatchPrd(products);
    }

    @Override
    public boolean deleBatchPrd(HashSet<Integer> products) {
        return this.productMapper.deleBatchPrd(products);
    }

    @Override
    public boolean updateBatchPrd(List<Product> products) {
        return this.productMapper.updateBatchPrd(products);
    }
}
