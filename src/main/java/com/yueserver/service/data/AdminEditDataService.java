package com.yueserver.service.data;

import com.yueserver.database.dao.BrandMapper;
import com.yueserver.database.dao.MerchantMapper;
import com.yueserver.database.dao.ProductMapper;
import com.yueserver.database.dao.UserMapper;
import com.yueserver.enity.Brand;
import com.yueserver.enity.Merchant;
import com.yueserver.enity.Product;
import com.yueserver.enity.User;
import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.EditInterface;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("AdminEditData")
public class AdminEditDataService implements EditInterface {

    @Autowired
    @Resource(name = "BrandSql")
    private BrandMapper brandDao;

    @Autowired
    @Resource(name = "ProductSql")
    private ProductMapper productDao;

    @Autowired
    @Resource(name = "MerchantSql")
    private MerchantMapper merchantDao;

    @Autowired
    @Resource(name = "UserSql")
    private UserMapper userDao;

    /**
     * 商品的增加操作（悦妆自营类型）
     * @param resultBean
     * @return
     */
    @Override
    @CacheEvict(value = "prdInfo", allEntries = true)
    public JSONObject addProductInfo(ResultBean<Product> resultBean) {
        JSONObject resultJson = new JSONObject();
        List resultList = new ArrayList();
        resultList.add(resultBean.getData());
        if (productDao.saveBatchPrd(resultList)) {
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
        List resultList = new ArrayList();
        resultList.add(resultBean.getData());
        if (productDao.updateBatchPrd(resultList)) {
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
        List resultList = new ArrayList();
        resultList.add(resultBean.getData());
        if (brandDao.saveBatchBrand(resultList)) {
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
        if (brandDao.updateBatchBrand(resultBean.getData())) {
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
        if (merchantDao.updateMerchant(resultBean.getData())) {
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
        if (userDao.updateUserStatus(resultBean.getData().getUsrstatus(), resultBean.getData().getUserno())) {
            resultJson.put("result", true);
            return resultJson;
        }
        resultJson.put("result", false);
        return resultJson;
    }
}
