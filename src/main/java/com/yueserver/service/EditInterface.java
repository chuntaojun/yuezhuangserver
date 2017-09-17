package com.yueserver.service;

import com.yueserver.enity.Brand;
import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;
import com.yueserver.enity.User;

import net.sf.json.JSONObject;

/**
 * admin 相关操作接口
 */
public interface EditInterface {

    JSONObject updateProInfo(Product product);
    JSONObject updateMerchantAuthorize(Merchant merchant);
    JSONObject updateBrandInfo(Brand brand);
    JSONObject updateUserInfo(User user);

    JSONObject addProductInfo(Product product);
    JSONObject addBrandInfo(Brand brand);

}
