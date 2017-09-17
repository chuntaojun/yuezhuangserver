package com.yueserver.service;

import javax.servlet.http.HttpSession;

public interface EmailInterface {

    void SendVerificationCodeEmail(String address, boolean cansend, HttpSession session);
    void SendRegistere(String address);
    void SendMerchantCanLogin(String address);
    void VerificationCodeExpired(HttpSession session);

    boolean SendIssueFeedBack(String address, String context);

    String setVerificationCode();
}
