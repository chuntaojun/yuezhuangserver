package com.yueserver.controller;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.enity.Brand;
import com.yueserver.enity.Product;
import com.yueserver.enity.nodao.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.*;

import com.yueserver.service.UploadInterface;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liaochuntao on 17-7-18.
 * 品牌、商品信息上传的controller
 */
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@Controller
@RequestMapping(value = {"/admin/upload", "/user/upload"})
public class UploadController {

    @Autowired
    @Resource(name = "UploadData")
    private UploadInterface uploadInterface;

    @ResponseBody
    @RequestMapping(value = "/Brand", method = RequestMethod.POST)
    public ResultBean<Boolean> UploadBrandInfo(@RequestParam(name = "logo") MultipartFile multipartFile, @ModelAttribute Brand brand,
                                      HttpSession session) throws MethodNourtFoundException {
        String brdLogo = uploadInterface.SaveBrdLogo(multipartFile, session, brand.getBrdname()).getData();
        if ("".equals(brdLogo) || brdLogo == null)
            return new ResultBean<>(false);
        brand.setBrdlogo(brdLogo);
        return uploadInterface.AddBrandInfo(brand);
    }

    /**
     * 上传商品的文字信息
     * @param product
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/Product", method = {RequestMethod.POST, RequestMethod.GET})
    public ResultBean<Boolean> UploadPrdInfo(@ModelAttribute Product product, String brdname, String submittype) throws ServletException, IOException {
        if ("upload".equalsIgnoreCase(submittype))
            return uploadInterface.AddProductInfo(product, brdname);
        return uploadInterface.UpdateProductInfo(product);
    }

    /**
     * 上传商品图片到服务器
     * @param multipartFiles
     * @param brdname
     * @param prdname
     * @param session
     * @return
     * @throws MethodNourtFoundException
     */
    @ResponseBody
    @RequestMapping(value = "/ProductPicture", method = {RequestMethod.POST, RequestMethod.GET})
    public ResultBean<Boolean> UploadPrdFile(@RequestParam(value = "file") MultipartFile[] multipartFiles, @RequestParam(name = "brdname") String brdname,
                                 @RequestParam(name = "prdname") String prdname, HttpSession session) throws MethodNourtFoundException {
        return uploadInterface.SavePrdPic(multipartFiles, brdname, prdname, session);
    }

    /**
     * 上传的商品视频文件到服务器
     * @param multipartFile
     * @param brdname
     * @param prdname
     * @param session
     * @throws IOException
     * @throws MethodNourtFoundException
     */
    @ResponseBody
    @RequestMapping(value = "/ProductVideos", method = RequestMethod.POST)
    public ResultBean<Boolean> UploadPrdVideo(@RequestParam(name = "prdvideo") MultipartFile multipartFile, @RequestParam(name = "brdname") String brdname,
                                        @RequestParam(name = "prdname") String prdname, HttpSession session)
            throws IOException, MethodNourtFoundException {
        return uploadInterface.SavePrdVideo(multipartFile, brdname, prdname, session);
    }

}
