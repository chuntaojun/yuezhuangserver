package com.yueserver.sql;

import com.yueserver.enity.Product;

import java.util.List;
import java.util.Map;

public interface ProductSqlInterface {

    Product getPrdInfo(String prdName);

    List queryProductInfo();
    List queryPrdName();

    boolean saveSinglePrd(Product product);
    boolean saveBatchPrd(List<Product> prdList);

    boolean deleBatchPrd(List<Integer> prdNos);

    boolean updateSinglePrd(Product product);
    boolean updateBatchPrd(Map<String, Object> prdMap);

}
