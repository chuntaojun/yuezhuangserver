package com.yueserver.database.dao;

import com.yueserver.enity.Merchant;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantMapper {

    List<Merchant> queryMerchantInfo();
    Merchant MerchantLogin(String account);
    boolean insertMerchant(@Param("Merchant") Merchant merchant);
    boolean updateMerchant(@Param("Merchant") Merchant merchant);
    boolean updateMctStates(Merchant merchant);

}
