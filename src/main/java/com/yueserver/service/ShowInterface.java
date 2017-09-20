package com.yueserver.service;

import com.yueserver.enity.nodao.Login;
import com.yueserver.enity.nodao.ResultBean;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpSession;

public interface ShowInterface {

    ResultBean<JSONObject> QueryProdInfo(Login login, HttpSession session);
    ResultBean<JSONObject> QueryBrandInfo(HttpSession session);
    ResultBean<JSONObject> QueryPostInfo();
    ResultBean<JSONObject> QueryUserInfo();
    ResultBean<JSONObject> QuerySellerInfo();
}
