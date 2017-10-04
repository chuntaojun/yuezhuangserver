package com.yueserver.service;

import com.yueserver.enity.noenity.Login;
import com.yueserver.enity.noenity.ResultBean;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpSession;

public interface ShowInterface {

    ResultBean<JSONObject> QueryProdInfo(Login login);
    ResultBean<JSONObject> QueryBrandInfo(Login login);
    ResultBean<JSONObject> QueryPostInfo();
    ResultBean<JSONObject> QueryUserInfo();
    ResultBean<JSONObject> QuerySellerInfo();
}
