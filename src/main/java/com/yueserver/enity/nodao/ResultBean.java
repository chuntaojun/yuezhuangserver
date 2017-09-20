package com.yueserver.enity.nodao;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
