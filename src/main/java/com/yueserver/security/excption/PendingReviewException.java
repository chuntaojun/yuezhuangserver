package com.yueserver.security.excption;

import org.springframework.security.core.AuthenticationException;

/**
 * 账户待审核异常
 */
public class PendingReviewException extends AuthenticationException {
    public PendingReviewException(String msg, Throwable t) {
        super(msg, t);
    }

    public PendingReviewException(String msg) {
        super(msg);
    }
}
