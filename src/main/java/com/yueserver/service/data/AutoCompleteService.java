package com.yueserver.service.data;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.AutoCompleteServiceInterface;
import com.yueserver.sql.BrandSqlInterface;
import com.yueserver.sql.ProductSqlInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("AutoCompleteService")
public class AutoCompleteService implements AutoCompleteServiceInterface {

    private HashMap<String, HashMap<String, List>> cacheMap = new HashMap<>();

    @Autowired
    @Resource(name = "BrandSql")
    private BrandSqlInterface brandSqlInterface;

    @Autowired
    @Resource(name = "ProductSql")
    private ProductSqlInterface productSqlInterface;

    @Override
    public ResultBean<HashMap<String, List>> AutoCompleteBrdName() {
        ArrayList<String> nameList = (ArrayList) brandSqlInterface.queryBrdName();
        if (!cacheMap.containsKey("brdMap")) {
            HashMap hashMap = new HashMap();
            hashMap.put("brdName", nameList);
            cacheMap.put("brdMap", hashMap);
        }
        return new ResultBean<>(cacheMap.get("brdMap"));
    }

    @Override
    public ResultBean<HashMap<String, List>> AutoCompletePrdName() {
        ArrayList<String> nameList = (ArrayList) productSqlInterface.queryPrdName();
        if (!cacheMap.containsKey("prdMap")) {
            HashMap<String, List> prdnameMap = new HashMap<>();
            prdnameMap.put("prdName", nameList);
            cacheMap.put("prdMap", prdnameMap);
        }
        return new ResultBean<>(cacheMap.get("prdMap"));
    }
}
