package com.yueserver.database.dao;

import com.yueserver.enity.Product;
import net.sf.json.JSONArray;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Repository
public interface ProductMapper {

    Product getPrdInfo(String prdName);

    List queryProductInfo(Integer mctNo);
    List queryProductInfo(JSONArray prdIds);
    List queryProductInfo();
    List queryPrdName();

    boolean saveBatchPrd(List<Product> products);
    boolean deleBatchPrd(HashSet<Integer> products);
    boolean updateBatchPrd(List<Product> products);

}
