package com.yueserver.service;

import com.yueserver.enity.noenity.ResultBean;

public interface DeleteInterface {

    ResultBean<Boolean> DelePrdInfo(int[] prdno);
    ResultBean<Boolean> DelePostInfo(int[] postno);
    ResultBean<Boolean> DeleBrandInfo(int[] brdno);

}
