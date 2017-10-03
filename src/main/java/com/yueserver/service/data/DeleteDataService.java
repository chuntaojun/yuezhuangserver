package com.yueserver.service.data;

import com.yueserver.database.dao.*;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.DeleteInterface;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("DeleteData")
public class DeleteDataService implements DeleteInterface {

    @Autowired
    @Resource(name = "ProductSql")
    private ProductMapper productDao;

    @Autowired
    @Resource(name = "BrandSql")
    private BrandMapper brandDao;

    @Autowired
    @Resource(name = "PostSql")
    private PostMapper postDao;

    /**
     * 进行Product批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param prdno
     * @return
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @Override
    public ResultBean<Boolean> DelePrdInfo(int[] prdno) {
        HashSet prdNos = (HashSet) Array2Set(prdno);
        return new ResultBean<>(productDao.deleBatchPrd(prdNos));
    }

    /**
     * 进行Post批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param postno
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @Override
    public ResultBean<Boolean> DelePostInfo(int[] postno) {
        HashSet postNos = (HashSet) Array2Set(postno);
        return new ResultBean<>(postDao.deleBatchPost(postNos));
    }

    /**
     * 进行Brand批量删除操作，启用批量删除操作 sqlservice.deleteRecode(String hql, type = BATCH_PROCESSING)
     * @param brdno
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @Override
    public ResultBean<Boolean> DeleBrandInfo(int[] brdno) {
        HashSet brdNos = (HashSet) Array2Set(brdno);
        return new ResultBean<>(brandDao.delBatchBrand(brdNos));
    }

    private Set Array2Set(int[] array) {
        Set set = new HashSet();
        set.add(Arrays.asList(array));
        return set;
    }

}
