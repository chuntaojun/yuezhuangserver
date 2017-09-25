package com.yueserver.service.data;

import com.yueserver.enity.Brand;
import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;
import com.yueserver.enity.User;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.EditInterface;
import com.yueserver.sql.AdminSqlInterface;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AdminEditData")
public class AdminEditDataService implements EditInterface {

    @Autowired
    @Resource(name = "AdminSql")
    private AdminSqlInterface adminSqlInterface;


    /**
     * 商品的增加操作（悦妆自营类型）
     * @param resultBean
     * @return
     */
    @Override
    @CacheEvict(value = "prdInfo", allEntries = true)
    public JSONObject addProductInfo(ResultBean<Product> resultBean) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.saveSinglePrd(resultBean.getData())) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 更新商品信息的操作（用于检查商家是否违规宣传商品）
     * @param resultBean
     * @return
     */
    @Override
    @CacheEvict(value = "prdInfo", allEntries = true)
    public JSONObject updateProInfo(ResultBean<Product> resultBean) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSinglePrd(resultBean.getData())) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 品牌的增，改操作
     * @param resultBean
     * @return
     */
    @Override
    @CacheEvict(value = "brdInfo", allEntries = true)
    public JSONObject addBrandInfo(ResultBean<Brand> resultBean) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.saveSingleBrand(resultBean.getData())) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 更新品牌信息
     * @param resultBean
     * @return
     */
    @Override
    @CacheEvict(value = "brdInfo", allEntries = true)
    public JSONObject updateBrandInfo(ResultBean<Brand> resultBean) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSingleBrand(resultBean.getData())) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 更新商家授权信息的操作
     * @param resultBean
     * @return
     */
    @Override
    @CacheEvict(value = "merchantInfo", allEntries = true)
    public JSONObject updateMerchantAuthorize(ResultBean<Merchant> resultBean) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSingleMerchant(resultBean.getData())) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 用户账户状态更改改操作
     * @param resultBean
     * @return
     */
    @Override
    @CacheEvict(value = "merchantInfo", allEntries = true)
    public JSONObject updateUserInfo(ResultBean<User> resultBean) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSingleUser(resultBean.getData())) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }
}
