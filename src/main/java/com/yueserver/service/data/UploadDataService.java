package com.yueserver.service.data;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.adaper.conver.UrlConverter;
import com.yueserver.adaper.conver.impl.AdminPic;
import com.yueserver.adaper.conver.impl.AdminVid;
import com.yueserver.adaper.conver.impl.MctPic;
import com.yueserver.adaper.conver.impl.MctVid;
import com.yueserver.adaper.encryption.base64.Base64;
import com.yueserver.enity.Brand;
import com.yueserver.enity.Product;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.UploadInterface;
import com.yueserver.sql.BrandSqlInterface;
import com.yueserver.sql.MerchantSqlInterface;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.yueserver.adaper.AdaperFactory.getSingleAdaperFactory;
import static com.yueserver.controller.LoginController.getPrincipal;

@Service("UploadData")
public class UploadDataService implements UploadInterface {

    @Autowired
    @Resource(name = "MerchantSql")
    private MerchantSqlInterface merchantSqlInterface;

    @Autowired
    @Resource(name = "BrandSql")
    private BrandSqlInterface brandSqlInterface;

    private  UrlConverter urlConverter = (UrlConverter) getSingleAdaperFactory().getConverter("URL");
    private Base64 base64 = (Base64) getSingleAdaperFactory().getEncryption("Base64");

    public UploadDataService() throws MethodNourtFoundException {
    }

    /**
     * 添加品牌信息
     * @param brand
     * @return
     */
    @Override
    public ResultBean<Boolean> AddBrandInfo(Brand brand) {
        return new ResultBean<>(brandSqlInterface.saveSingleBrand(brand));
    }

    /**
     * 商家上传商品信息
     * @param product
     */
    @Override
    public ResultBean<Boolean> AddProductInfo(Product product, String brdname) {
        return new ResultBean<>(merchantSqlInterface.saveSinglePrd(product, brdname));
    }

    /**
     * 商家更新商品信息
     * @param product
     */
    @Override
    public ResultBean<Boolean> UpdateProductInfo(Product product) {
        return new ResultBean<>(merchantSqlInterface.updateSinglePrd(product));
    }

    /**
     * 保存品牌信息
     * @param multipartFile
     * @return
     */
    @Override
    public ResultBean<String> SaveBrdLogo(MultipartFile multipartFile, HttpSession session, String brdName) throws MethodNourtFoundException {
        brdName = urlConverter.UrlEncode(brdName);
        UrlConverter _urlConverter;
        HashMap hashMap = UserResources(session);
        String filepath = (String) hashMap.get("logo") + "/" + brdName;
        System.out.println(filepath);
        if (hashMap.get("role").equals("user"))
            _urlConverter = new UrlConverter(new MctPic());
        else
            _urlConverter = new UrlConverter(new AdminPic());
        File dir = new File(filepath);
        if (!dir.exists())
            dir.mkdirs();
        try {
            multipartFile.transferTo(new File(filepath, multipartFile.getOriginalFilename()));
            String brdLogo = _urlConverter.BrandReourcesHttpUrl(multipartFile.getOriginalFilename(), brdName);
            return new ResultBean<>(brdLogo);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultBean<>("");
        }
    }

    /**
     * 上传图片文件写入服务器存储 (根据用户角色不同保存至不同文件夹)
     * @param multipartFiles
     * @param brdname
     * @param prdname
     * @param session
     * @return
     * @throws MethodNourtFoundException
     */
    @Override
    public ResultBean<Boolean> SavePrdPic(MultipartFile[] multipartFiles, String brdname, String prdname, HttpSession session) throws MethodNourtFoundException {
        UrlConverter _urlConverter;
        int prdno = getPrdNo(prdname);
        if (prdno == -1)
            return new ResultBean<>(false);
        HashMap hashMap = UserResources(session);
        String filepath = (String) hashMap.get("resources");
        if ("admin".equals(hashMap.get("role")))
            _urlConverter = new UrlConverter(new AdminPic());
        else
            _urlConverter = new UrlConverter(new MctPic());
        prdname = urlConverter.UrlEncode(prdname);
        String merinfo = brdname + "/" + prdname;
        ArrayList<String> picurllist = new ArrayList<>();
        try {
            filepath += "/" + getPrincipal().getUsername() + "/" + merinfo;
            File dir = new File(filepath);
            if (!dir.exists())
                dir.mkdirs();
            for (MultipartFile multipartFile : multipartFiles){
                multipartFile.transferTo(new File(filepath, multipartFile.getOriginalFilename()));
                picurllist.add(_urlConverter.ReourcesHttpUrl(multipartFile.getOriginalFilename(),
                        base64.Base64Encode(getPrincipal().getUsername()) + "/" + merinfo));
            }
            return new ResultBean<>(ImageStorageDatabase(picurllist,  prdno, 1));
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ResultBean<>(false);
        }
    }

    /**
     * 保存上传的视频文件 (根据用户角色不同保存至不同文件夹)
     * @param multipartFile
     * @param brdname
     * @param prdname
     * @param session
     * @return
     * @throws MethodNourtFoundException
     */
    @Override
    public ResultBean<Boolean> SavePrdVideo(MultipartFile multipartFile, String brdname, String prdname, HttpSession session) throws MethodNourtFoundException {
        UrlConverter _urlConverter;
        HashMap hashMap = UserResources(session);
        String filepath = (String) hashMap.get("resources");
        if (hashMap.get("role").equals("user"))
            _urlConverter = new UrlConverter(new MctVid());
        else
            _urlConverter = new UrlConverter(new AdminVid());
        prdname = urlConverter.UrlEncode(prdname);
        String merinfo = brdname + "/" + prdname;
        try {
            filepath += "/" + getPrincipal().getUsername() + "/" + merinfo;
            String filename = multipartFile.getOriginalFilename();
            File dir = new File(filepath);
            if (!dir.exists())
                dir.mkdirs();
            ArrayList<String> vidurllist = new ArrayList();
            vidurllist.add(_urlConverter.ReourcesHttpUrl(filename, base64.Base64Decode(getPrincipal().getUsername())
                    + "/" + merinfo));
            multipartFile.transferTo(new File(filepath, filename));
            return new ResultBean<>(true);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultBean<>(false);
        }
    }

    /**
     * 获取上传图片的相关商品，品牌信息并返回对应商品的 PrdNo
     * @param prdname
     * @return
     */
    private int getPrdNo(String prdname) {
        Product product = merchantSqlInterface.getPrdInfo(prdname);
        if (prdname != null)
            return product.getPrdno();
        return -1;
    }

    /**
     * 上传多媒体文件的url信息存储至数据库，数据存储采用批处理节省处理时间
     * 获取多媒体文件与之相关的商品编号
     * @param urllist
     * @param type type = 1 图片url存储； type = -1 视频url存储
     * @return
     */
    private boolean ImageStorageDatabase(ArrayList<String> urllist, int prdno, int type) {
        String[] urls = new String[urllist.size()];
        urllist.toArray(urls);
        switch (type){
            case 1:
                HashMap<String, Object> prdpicMap = new HashMap();
                prdpicMap.put("urls", urls);
                prdpicMap.put("prdNo", prdno);
                return merchantSqlInterface.saveBatchPrdPic(prdpicMap);
            case -1:
                JSONObject prdvidJson = new JSONObject();
                prdvidJson.put("urls", urls);
                prdvidJson.put("prdNo", prdno);
                return merchantSqlInterface.saveBatchPrdVid(prdvidJson);
            case 0:
        }
        return false;
    }

    private HashMap<String, Object> UserResources(HttpSession session) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (session.getAttribute("usertype").equals("商家")) {
            hashMap.put("role", "user");
            hashMap.put("resources", session.getServletContext().getInitParameter("mctprdpic"));
            hashMap.put("logo", session.getServletContext().getInitParameter("brdLogo"));
            return hashMap;
        }
        hashMap.put("role", "admin");
        hashMap.put("resources", session.getServletContext().getInitParameter("adminprdpic"));
        hashMap.put("logo", session.getServletContext().getInitParameter("brdLogo"));
        return hashMap;
    }

}
