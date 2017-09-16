package com.yueserver.service.impl;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.adaper.conver.JsonConverter;
import com.yueserver.adaper.conver.ListConverter;
import com.yueserver.bean.nodao.Login;
import com.yueserver.service.ShowInterface;
import com.yueserver.sql.AdminSqlInterface;
import com.yueserver.sql.MerchantSqlInterface;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.yueserver.adaper.AdaperFactory.getSingleAdaperFactory;

@Service
public class ShowDataInfo implements ShowInterface {

    @Autowired
    @Resource(name = "MerchantSql")
    private MerchantSqlInterface merchantSqlInterface;

    @Autowired
    @Resource(name = "AdminSql")
    private AdminSqlInterface adminSqlInterface;

    private JSONObject jsonObject;

    /**
     * 显示商品数据
     * @param login
     * @param session
     * @return
     */
    @Override
    public JSONObject QueryProdInfo(Login login, HttpSession session) {
        JSONObject prdJson = getSingleJson();
        if ("ROLE_USER".equals(login.getRole(login.getAuthorities()))){
            List list = merchantSqlInterface.queryBrd_PrdInfo(login.getMctno());
            List infoList = getListConverter().setPrdList(list, session);
            prdJson.put("prdList", getJsonConverter().setMessage(infoList));
            return prdJson;
        } else {
            /*
                 管理员取出品牌与商品信息
             */
            List list = adminSqlInterface.queryBrd_PrdInfo();
            List infoList = getListConverter().setPrdList(list, session);
            prdJson.put("prdList", getJsonConverter().setMessage(infoList));
            return prdJson;
        }
    }

    /**
     * 显示品牌数据(在查询商品数据时就已经一并查出)
     * @param session
     * @return
     */
    public JSONObject QueryBrandInfo(HttpSession session){
        JSONObject brdJson = getSingleJson();
        brdJson.put("brdList", getJsonConverter().setMessage((List) session.getAttribute("brdlist")));
        session.removeAttribute("brdlist");
        return brdJson;
    }

    /**
     * 显示帖子数据
     * @return
     */
    @Secured("ROLE_ADMIN")
    @Override
    public JSONObject QueryPostInfo() {
        JSONObject postJson = getSingleJson();
        List list = adminSqlInterface.queryPostInfo();
        List infoList = getListConverter().setPostList(list);
        postJson.put("postList", getJsonConverter().setMessage(infoList));
        return postJson;
    }

    /**
     * 显示用户数据
     * @return
     */
    @Secured("ROLE_ADMIN")
    @Override
    public JSONObject QueryUserInfo() {
        JSONObject userJson = getSingleJson();
        List list = adminSqlInterface.queryUserInfo();
        List infoList = getListConverter().setUserList(list);
        userJson.put("usrList", infoList);
        return userJson;
    }

    /**
     * 显示商家数据
     * @return
     */
    @Secured("ROLE_ADMIN")
    @Override
    public JSONObject QuerySellerInfo() {
        JSONObject mctJson = getSingleJson();
        List list = adminSqlInterface.queryMerchantInfo();
        List infoList = getListConverter().setSellerList(list);
        mctJson.put("mctList", getJsonConverter().setMessage(infoList));
        return mctJson;
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
