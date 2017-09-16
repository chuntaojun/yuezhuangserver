package com.yueserver.security.excption;

import org.springframework.security.core.AuthenticationException;

/**
 * 账户被禁止登陆异常
 */
public class ProhibitLandingException extends AuthenticationException {
    public ProhibitLandingException(String msg, Throwable t) {
        super(msg, t);
    }

    public ProhibitLandingException(String msg) {
        super(msg);
    }
}
