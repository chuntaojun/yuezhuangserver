package com.yueserver.service;

import com.yueserver.enity.noenity.ResultBean;

import java.util.HashMap;
import java.util.List;

public interface AutoCompleteServiceInterface {

    ResultBean<HashMap<String, List>> AutoCompleteBrdName();
    ResultBean<HashMap<String, List>> AutoCompletePrdName();

}
