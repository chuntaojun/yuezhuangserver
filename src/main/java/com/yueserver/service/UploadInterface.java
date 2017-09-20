package com.yueserver.service;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.enity.Brand;
import com.yueserver.enity.Product;
import com.yueserver.enity.nodao.ResultBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Merchant 相关操作接口
 */
public interface UploadInterface {

    ResultBean<Boolean> AddBrandInfo(Brand brand);
    ResultBean<Boolean> AddProductInfo(Product product, String brdname);
    ResultBean<Boolean> UpdateProductInfo(Product product);

    ResultBean<String> SaveBrdLogo(MultipartFile multipartFile, HttpSession brdName, String session) throws MethodNourtFoundException;
    ResultBean<Boolean> SavePrdPic(MultipartFile[] multipartFiles, String brdname, String prdname, HttpSession session) throws MethodNourtFoundException;
    ResultBean<Boolean> SavePrdVideo(MultipartFile multipartFile, String brdname, String prdname, HttpSession session) throws MethodNourtFoundException;

}
