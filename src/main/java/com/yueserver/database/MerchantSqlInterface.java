package com.yueserver.database;

import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;

import java.util.List;
import java.util.Map;

public interface MerchantSqlInterface {

    Product getPrdInfo(String prdName);
    List queryBrd_PrdInfo(int mctNo);

    boolean saveSinglePrd(Product product, String brdName);
    boolean saveBatchPrd(Map<String, Object> prdJson);
    boolean saveBatchPrdPic(Map<String, Object> prdpicMap);
    boolean saveBatchPrdVid(Map<String, Object> prdvidJson);

    boolean updateSingleMerchant(Merchant merchant);
    boolean updateSinglePrd(Product product);
    boolean updateBatchPrd(Map<String, Object> prdJson);

    boolean deleBatchPrdVid(Map<String, Object> prdvidJson);
    boolean deleBatchPrdPic(Map<String, Object> prdpicJson);
    boolean deleBatchPrd(Map<String, Object> prdJson);
}
