package com.yueserver.service;

import com.yueserver.enity.nodao.ResultBean;

public interface DeleteInterface {

    ResultBean<Boolean> DelePrdInfo(int[] prdno);
    ResultBean<Boolean> DelePostInfo(int[] postno);
    ResultBean<Boolean> DeleBrandInfo(int[] brdno);

}
