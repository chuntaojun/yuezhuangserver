package com.yueserver.security.excption;

import org.springframework.security.core.AuthenticationException;

public class AccountNotFoundException extends AuthenticationException {

    public AccountNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
