package com.yueserver.adaper;

public class MethodNourtFoundException extends Exception {

    public MethodNourtFoundException() {
        super("method was not found");
    }

}
