package com.yueserver.service;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.bean.Brand;
import com.yueserver.bean.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Merchant 相关操作接口
 */
public interface UploadInterface {

    boolean AddBrandInfo(Brand brand);
    boolean AddProductInfo(Product product, String brdname);
    boolean UpdateProductInfo(Product product);

    String SaveBrdLogo(MultipartFile multipartFile, HttpSession brdName, String session) throws MethodNourtFoundException;
    boolean SavePrdPic(MultipartFile[] multipartFiles, String brdname, String prdname, HttpSession session) throws MethodNourtFoundException;
    boolean SavePrdVideo(MultipartFile multipartFile, String brdname, String prdname, HttpSession session) throws MethodNourtFoundException;

}
