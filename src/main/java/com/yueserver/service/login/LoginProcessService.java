package com.yueserver.service.login;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.adaper.encryption.base64.Base64;
import com.yueserver.adaper.encryption.mdfive.MD5;
import com.yueserver.enity.nodao.ForgotPassword;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.database.LoginSqlInterface;
import com.yueserver.enity.Merchant;
import com.yueserver.service.LoginInterface;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.Date;

import static com.yueserver.adaper.AdaperFactory.getSingleAdaperFactory;

@Service("LoginProcessService")
public class LoginProcessService implements LoginInterface {

    @Autowired
    @Resource(name = "LoginSql")
    private LoginSqlInterface loginSqlInterface;

    /**
     * 登录时根据用户名取出一个对象
     * @param username
     * @return
     * @throws MethodNourtFoundException
     */
    @Override
    public ResultBean<Object> getLoginObject(String username) throws MethodNourtFoundException {
        Base64 base64 = (Base64) getSingleAdaperFactory().getEncryption("Base64");
        username = base64.Base64Encode(username);
        return new ResultBean<>(loginSqlInterface.getLoginObject(username, username));
    }

    /**
     * 商家更改密码操作
     * @param forgotPassword
     * @param session
     * @return
     */
    @Override
    public ResultBean<JSONObject> ChangePasswordIsWork(ForgotPassword forgotPassword, HttpSession session) {
        JSONObject resultJson = new JSONObject();
        if (loginSqlInterface.updatePassword(forgotPassword)){
            resultJson.put("isWork", "yes");
            return new ResultBean<>(resultJson);
        }
        resultJson.put("isWork", "no");
        return new ResultBean<>(resultJson);
    }

    /**
     * 商家用户注册
     * @param mctaccount
     * @param password
     * @return
     */
    @Override
    public ResultBean<Boolean> AddNewMerchant(String mctaccount, String password) throws MethodNourtFoundException {
        Base64 base64 = (Base64) getSingleAdaperFactory().getEncryption("Base64");
        MD5 md5 = (MD5) getSingleAdaperFactory().getEncryption("MD5");
        Merchant merchant = new Merchant();
        merchant.setMctaccount(base64.Base64Encode(mctaccount));
        merchant.setMctpassword(md5.Md5Password(password));
        merchant.setMcttime(new Date());
        //商家注册后需管理员设定商家权限以及审核账户
        merchant.setMctstate(0);
        if (TheMerchantExist(merchant.getMctaccount()).getData()) {
            return new ResultBean<>(false);
        }
        return new ResultBean<>(loginSqlInterface.saveNewAccount(merchant));
    }

    /**
     * 注册防止用户名重复
     * @param username
     * @return
     */
    @Override
    public ResultBean<Boolean> TheMerchantExist(String username) {
        return new ResultBean<>(loginSqlInterface.getExistUser(username));
    }


}
