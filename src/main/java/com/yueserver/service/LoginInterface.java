package com.yueserver.service;


import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.enity.nodao.ForgotPassword;
import com.yueserver.enity.nodao.ResultBean;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

public interface LoginInterface {

    ResultBean<Boolean> TheMerchantExist(String username);
    ResultBean<Boolean> AddNewMerchant(String mctaccount, String password) throws MethodNourtFoundException;
    ResultBean<Object> getLoginObject(String username) throws MethodNourtFoundException;
    ResultBean<JSONObject> ChangePasswordIsWork(ForgotPassword forgotPassword, HttpSession session) throws ParseException;

}
