package com.yueserver.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface MultipartFileIntereface {

    ArrayList<String> saveProductFiles(MultipartFile[] multipartFiles, String filepath, String mctInfo);
    String saveBrandFiles(MultipartFile multipartFile, String filepath, String brdName);
    boolean saveTodayTry(MultipartFile multipartFile, String filpath, String info);

}
