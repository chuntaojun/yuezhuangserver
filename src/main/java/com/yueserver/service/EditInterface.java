package com.yueserver.service;

import com.yueserver.enity.Brand;
import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;
import com.yueserver.enity.User;

import com.yueserver.enity.nodao.ResultBean;
import net.sf.json.JSONObject;

/**
 * admin 相关操作接口
 */
public interface EditInterface {

    JSONObject updateProInfo(ResultBean<Product> resultBean);
    JSONObject updateMerchantAuthorize(ResultBean<Merchant> resultBean);
    JSONObject updateBrandInfo(ResultBean<Brand> resultBean);
    JSONObject updateUserInfo(ResultBean<User> resultBean);

    JSONObject addProductInfo(ResultBean<Product> resultBean);
    JSONObject addBrandInfo(ResultBean<Brand> brandResultBean);

}
