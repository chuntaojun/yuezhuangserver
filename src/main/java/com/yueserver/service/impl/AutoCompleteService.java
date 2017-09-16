package com.yueserver.service.impl;

import com.yueserver.service.AutoCompleteServiceInterface;
import com.yueserver.sql.BrandSqlInterface;
import com.yueserver.sql.ProductSqlInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("AutoCompleteService")
public class AutoCompleteService implements AutoCompleteServiceInterface {

    @Autowired
    @Resource(name = "BrandSql")
    private BrandSqlInterface brandSqlInterface;

    @Autowired
    @Resource(name = "ProductSql")
    private ProductSqlInterface productSqlInterface;

    @Override
    public HashMap<String, List> AutoCompleteBrdName() {
        ArrayList<String> nameList = (ArrayList) brandSqlInterface.queryBrdName();
        HashMap<String, List> brdnameMap = new HashMap<>();
        brdnameMap.put("brdName", nameList);
        return brdnameMap;
    }

    @Override
    public HashMap<String, List> AutoCompletePrdName() {
        ArrayList<String> nameList = (ArrayList) productSqlInterface.queryPrdName();
        HashMap<String, List> prdnameMap = new HashMap<>();
        prdnameMap.put("prdName", nameList);
        return prdnameMap;
    }
}
