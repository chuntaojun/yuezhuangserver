package com.yueserver.database.impl;

import com.yueserver.database.dao.BrandMapper;
import com.yueserver.enity.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("BrandSql")
public class BrandSql implements BrandMapper {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public Brand getBrand(String brdname) {
        return this.brandMapper.getBrand(brdname);
    }

    @Secured("ROLE_USER")
    @Override
    public List queryBrandInfo(int mctNo) {
        return this.brandMapper.queryBrandInfo(mctNo);
    }

    @Secured("ROLE_ADMIN")
    @Override
    public List queryBrandInfoAdmin() {
        return this.brandMapper.queryBrandInfoAdmin();
    }

    @Override
    public List queryBrdName(int mctNo) {
        return this.brandMapper.queryBrdName(mctNo);
    }

    @Override
    public boolean saveBatchBrand(List<Brand> brands) {
        return this.brandMapper.saveBatchBrand(brands);
    }

    @Override
    public boolean delBatchBrand(Set<Integer> brands) {
        return this.brandMapper.delBatchBrand(brands);
    }

    @Override
    public boolean updateBatchBrand(Brand brand) {
        return this.brandMapper.updateBatchBrand(brand);
    }


}
