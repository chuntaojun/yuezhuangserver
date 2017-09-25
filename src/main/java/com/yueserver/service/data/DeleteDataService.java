package com.yueserver.service.data;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.DeleteInterface;
import com.yueserver.sql.AdminSqlInterface;
import com.yueserver.sql.MerchantSqlInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @Override
    public ResultBean<Boolean> DelePrdInfo(int[] prdno) {
        List prdNos = Array2List(prdno);
        return new ResultBean<>(adminSqlInterface.deleBatchPrd(new ResultBean<>(prdNos)));
    }

    /**
     * 进行Post批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param postno
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @Override
    public ResultBean<Boolean> DelePostInfo(int[] postno) {
        List postNos = Array2List(postno);
        return new ResultBean<>(false);
    }

    /**
     * 进行Brand批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param brdno
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @Override
    public ResultBean<Boolean> DeleBrandInfo(int[] brdno) {
        List brdNos = Array2List(brdno);
        return new ResultBean<>(false);
    }

    private List Array2List(int[] array) {
        return Arrays.asList(array);
    }

}
