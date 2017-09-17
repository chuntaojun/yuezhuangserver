package com.yueserver.service;

import com.yueserver.enity.nodao.Login;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpSession;

public interface ShowInterface {

    JSONObject QueryProdInfo(Login login, HttpSession session);
    JSONObject QueryBrandInfo(HttpSession session);
    JSONObject QueryPostInfo();
    JSONObject QueryUserInfo();
    JSONObject QuerySellerInfo();
}
