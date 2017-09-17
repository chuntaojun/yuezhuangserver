package com.yueserver.service.data;

import com.yueserver.service.DeleteInterface;
import com.yueserver.sql.AdminSqlInterface;
import com.yueserver.sql.MerchantSqlInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("DeleteData")
public class DeleteDataService implements DeleteInterface {

    @Autowired
    @Resource(name = "AdminSql")
    private AdminSqlInterface adminSqlInterface;

    @Autowired
    @Resource(name = "MerchantSql")
    private MerchantSqlInterface merchantSqlInterface;

    /**
     * 进行Product批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param prdno
     * @return
     */
    @Override
    public boolean DelePrdInfo(int[] prdno) {
        return false;
    }

    /**
     * 进行Post批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param postno
     * @return
     */
    @Override
    public boolean DelePostInfo(int[] postno) {

        return false;
    }

    /**
     * 进行Brand批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param brdno
     * @return
     */
    @Override
    public boolean DeleBrandInfo(int[] brdno) {

        return false;
    }

}
