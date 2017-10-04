package com.yueserver.service.file;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.adaper.conver.UrlConverter;
import com.yueserver.adaper.conver.impl.AdminPic;
import com.yueserver.adaper.conver.impl.MctPic;
import com.yueserver.adaper.encryption.base64.Base64;
import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.MultipartFileIntereface;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.yueserver.adaper.AdaperFactory.getSingleAdaperFactory;
import static com.yueserver.controller.LoginController.getPrincipal;

@Service("MultipartFileService")
public class MultipartFileService implements MultipartFileIntereface {

    private Base64 base64 = (Base64) getSingleAdaperFactory().getEncryption("Base64");

    public MultipartFileService() throws MethodNourtFoundException {
    }

    /**
     * 存储商品相关文件信息
     * @param multipartFiles
     * @param filepath
     * @param mctInfo
     * @return
     */
    @Override
    public ResultBean<ArrayList<String>> saveProductFiles(MultipartFile[] multipartFiles, String filepath, String mctInfo) {
        ArrayList<String> urlList = new ArrayList<>();
        CreatFileDir(filepath);
        for (MultipartFile multipartFile : multipartFiles) {
            try {
                multipartFile.transferTo(new File(filepath, multipartFile.getOriginalFilename()));
                urlList.add(CreateUrlConverter().ReourcesHttpUrl(multipartFile.getOriginalFilename(),
                        base64.Base64Encode(getPrincipal().getUsername()) + "/" + mctInfo));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return new ResultBean<>(urlList);
    }

    /**
     * 存储品牌相关信息
     * @param multipartFile
     * @param filepath
     * @param brdName
     * @return
     */
    @Override
    public ResultBean<String> saveBrandFiles(MultipartFile multipartFile, String filepath, String brdName) {
        CreatFileDir(filepath);
        try {
            multipartFile.transferTo(new File(filepath, multipartFile.getOriginalFilename()));
            String brdLogo = CreateUrlConverter().BrandReourcesHttpUrl(multipartFile.getOriginalFilename(), brdName);
            return new ResultBean<>(brdLogo);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 今日抢试相关图片
     * @param multipartFile
     * @param filpath
     * @param info
     * @return
     */
    @Override
    public ResultBean<Boolean> saveTodayTry(MultipartFile multipartFile, String filpath, String info) {
        CreatFileDir(filpath);
        try {
            multipartFile.transferTo(new File(filpath, multipartFile.getOriginalFilename()));
            return new ResultBean<>(true);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultBean<>(false);
        }
    }

    protected void CreatFileDir(String filepath) {
        File dir = new File(filepath);
        if (!dir.exists())
            dir.mkdirs();
    }

    private UrlConverter CreateUrlConverter() {
        if (getPrincipal().getAuthorities().equals("ROLE_ADMIN"))
            return new UrlConverter(new AdminPic());
        else
            return new UrlConverter(new MctPic());
    }

}
