package com.yueserver.service;

import com.yueserver.enity.noenity.ResultBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface MultipartFileIntereface {

    ResultBean<ArrayList<String>> saveProductFiles(MultipartFile[] multipartFiles, String filepath, String mctInfo);
    ResultBean<String> saveBrandFiles(MultipartFile multipartFile, String filepath, String brdName);
    ResultBean<Boolean> saveTodayTry(MultipartFile multipartFile, String filpath, String info);

}
