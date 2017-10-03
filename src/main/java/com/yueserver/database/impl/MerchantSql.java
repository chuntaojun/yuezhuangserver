package com.yueserver.database.impl;

import com.yueserver.database.dao.MerchantMapper;
import com.yueserver.enity.Merchant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MerchantSql")
public class MerchantSql implements MerchantMapper {

    @Resource
    private MerchantMapper merchantMapper;

    @Override
    public List<Merchant> queryMerchantInfo() {
        return null;
    }

    @Override
    public Merchant MerchantLogin(String account) {
        return this.merchantMapper.MerchantLogin(account);
    }

    @Override
    public boolean insertMerchant(Merchant merchant) {
        return this.merchantMapper.insertMerchant(merchant);
    }

    @Override
    public boolean updateMerchant(Merchant merchant) {
        return this.merchantMapper.updateMerchant(merchant);
    }
}
