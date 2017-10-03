package com.yueserver.service.data;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.adaper.conver.JsonConverter;
import com.yueserver.adaper.conver.ListConverter;
import com.yueserver.database.dao.*;
import com.yueserver.enity.Product;
import com.yueserver.enity.nodao.Login;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.ShowInterface;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.yueserver.adaper.AdaperFactory.getSingleAdaperFactory;

@Service
public class ShowDataInfoService implements ShowInterface {

    @Autowired
    @Resource(name = "ProductSql")
    private ProductMapper productDao;

    @Autowired
    @Resource(name = "BrandSql")
    private BrandMapper brandDao;

    @Autowired
    @Resource(name = "PostSql")
    private PostMapper postDao;

    @Autowired
    @Resource(name = "UserSql")
    private UserMapper userDao;

    @Autowired
    @Resource(name = "MerchantSql")
    private MerchantMapper merchantDao;

    private JSONObject jsonObject;

    /**
     * 显示商品数据
     * @param login
     * @param session
     * @return
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @Override
    @Cacheable(value = "prdInfo")
    public ResultBean<JSONObject> QueryProdInfo(Login login, HttpSession session) {
        JSONObject prdJson = getSingleJson();
        if ("ROLE_USER".equals(login.getRole(login.getAuthorities()))){
            List list = productDao.queryProductInfo(login.getMctno());
            List infoList = getListConverter().setPrdList(list, session);
            prdJson.put("prdList", getJsonConverter().setMessage(infoList));
            return new ResultBean<>(prdJson);
        } else {
            /*
                 管理员取出品牌与商品信息
             */
            List list = productDao.queryProductInfo();
            List infoList = getListConverter().setPrdList(list, session);
            prdJson.put("prdList", getJsonConverter().setMessage(infoList));
            return new ResultBean<>(prdJson);
        }
    }

    /**
     * 显示品牌数据(在查询商品数据时就已经一并查出)
     * @param session
     * @return
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @Cacheable(value = "brdInfo")
    public ResultBean<JSONObject> QueryBrandInfo(HttpSession session){
        JSONObject brdJson = getSingleJson();
        brdJson.put("brdList", getJsonConverter().setMessage((List) session.getAttribute("brdlist")));
        session.removeAttribute("brdlist");
        return new ResultBean<>(brdJson);
    }

    /**
     * 显示帖子数据
     * @return
     */
    @Secured("ROLE_ADMIN")
    @Override
    @Cacheable(value = "postInfo")
    public ResultBean<JSONObject> QueryPostInfo() {
        JSONObject postJson = getSingleJson();
        List list = postDao.queryPostInfo();
        List infoList = getListConverter().setPostList(list);
        postJson.put("postList", getJsonConverter().setMessage(infoList));
        return new ResultBean<>(postJson);
    }

    /**
     * 显示用户数据
     * @return
     */
    @Secured("ROLE_ADMIN")
    @Override
    @Cacheable(value = "userInfo")
    public ResultBean<JSONObject> QueryUserInfo() {
        JSONObject userJson = getSingleJson();
        List list = userDao.queryUserInfo();
        List infoList = getListConverter().setUserList(list);
        userJson.put("usrList", infoList);
        return new ResultBean<>(userJson);
    }

    /**
     * 显示商家数据
     * @return
     */
    @Secured("ROLE_ADMIN")
    @Override
    @Cacheable(value = "merchantInfo")
    public ResultBean<JSONObject> QuerySellerInfo() {
        JSONObject mctJson = getSingleJson();
        List list = merchantDao.queryMerchantInfo();
        List infoList = getListConverter().setSellerList(list);
        mctJson.put("mctList", getJsonConverter().setMessage(infoList));
        return new ResultBean<>(mctJson);
    }

    protected JSONObject getSingleJson() {
        if (jsonObject == null)
            return new JSONObject();
        return jsonObject;
    }

    protected ListConverter getListConverter() {
        try {
            return (ListConverter) getSingleAdaperFactory().getConverter("List");
        } catch (MethodNourtFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected JsonConverter getJsonConverter() {
        try {
            return (JsonConverter) getSingleAdaperFactory().getConverter("JSON");
        } catch (MethodNourtFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
