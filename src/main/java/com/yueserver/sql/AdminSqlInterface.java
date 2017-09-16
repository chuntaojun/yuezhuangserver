package com.yueserver.sql;

import com.yueserver.bean.Brand;
import com.yueserver.bean.Merchant;
import com.yueserver.bean.Product;
import com.yueserver.bean.User;

import java.util.List;
import java.util.Map;

public interface AdminSqlInterface {

    List queryBrd_PrdInfo();
    List queryPostInfo();
    List queryMerchantInfo();
    List queryUserInfo();

    boolean saveSingleBrand(Brand brand);
    boolean saveBatchBrand();
    boolean saveBatchPrdPic(Map<String, Object> prdpicMap);
    boolean saveBatchPrdVid(Map<String, Object> prdvidMap);
    boolean saveSinglePrd(Product product);
    boolean saveBatchPrd(List<Product> prdList);

    boolean deleBatchPrd(Map<String, Object> prdMap);
    boolean deleBatchPrdVid(Map<String, Object> prdvidMap);
    boolean deleBatchPrdPic(Map<String, Object> prdpicMap);
    boolean delBatchBrand(Map<String, Object> brdMap);
    boolean deleBatchPost(Map<String, Object> postMap);

    boolean updateSingleMerchant(Merchant merchant);
    boolean updateSingleBrand(Brand brand);
    boolean updateBatchBrand(Map<String, Object> brdMap);
    boolean updateSingleUser(User user);
    boolean updateSinglePrd(Product product);
    boolean updateBatchPrd(List<Product> prdList);

}
