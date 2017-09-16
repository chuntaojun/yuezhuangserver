package com.yueserver.sql;

import com.yueserver.bean.Brand;

import java.util.List;
import java.util.Map;

public interface BrandSqlInterface {

    Brand getBrand(String brdname);
    List queryBrd_PrdInfo();

    boolean saveSingleBrand(Brand brand);
    boolean saveBatchBrand();

    boolean delBatchBrand(Map<String, Object> brdMap);

    boolean updateSingleBrand(Brand brand);
    boolean updateBatchBrand(Map<String, Object> brdMap);

}