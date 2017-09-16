package com.yueserver.service.data;

import com.yueserver.bean.Brand;
import com.yueserver.bean.Merchant;
import com.yueserver.bean.Product;
import com.yueserver.bean.User;
import com.yueserver.service.EditInterface;
import com.yueserver.sql.AdminSqlInterface;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AdminEditData")
public class AdminEditData implements EditInterface {

    @Autowired
    @Resource(name = "AdminSql")
    private AdminSqlInterface adminSqlInterface;


    /**
     * 商品的增加操作（悦妆自营类型）
     * @param product
     * @return
     */
    @Override
    public JSONObject addProductInfo(Product product) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.saveSinglePrd(product)) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 更新商品信息的操作（用于检查商家是否违规宣传商品）
     * @param product
     * @return
     */
    @Override
    public JSONObject updateProInfo(Product product) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSinglePrd(product)) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 品牌的增，改操作
     * @param brand
     * @return
     */
    @Override
    public JSONObject addBrandInfo(Brand brand) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.saveSingleBrand(brand)) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 更新品牌信息
     * @param brand
     * @return
     */
    @Override
    public JSONObject updateBrandInfo(Brand brand) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSingleBrand(brand)) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 更新商家授权信息的操作
     * @param merchant
     * @return
     */
    @Override
    public JSONObject updateMerchantAuthorize(Merchant merchant) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSingleMerchant(merchant)) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }

    /**
     * 用户账户状态更改改操作
     * @param user
     * @return
     */
    @Override
    public JSONObject updateUserInfo(User user) {
        JSONObject resultJson = new JSONObject();
        if (adminSqlInterface.updateSingleUser(user)) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }
}
