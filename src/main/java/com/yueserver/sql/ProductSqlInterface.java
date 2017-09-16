package com.yueserver.sql;

import com.yueserver.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductSqlInterface {

    boolean saveSinglePrd(Product product);
    boolean saveBatchPrd(List<Product> prdList);

    boolean deleBatchPrd(List<Integer> prdNos);

    boolean updateSinglePrd(Product product);
    boolean updateBatchPrd(Map<String, Object> prdMap);

}
