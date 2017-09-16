package com.yueserver.service;

import com.yueserver.bean.Brand;
import com.yueserver.bean.Merchant;
import com.yueserver.bean.Product;
import com.yueserver.bean.User;

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
