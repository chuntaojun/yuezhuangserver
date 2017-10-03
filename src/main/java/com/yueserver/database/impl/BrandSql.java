package com.yueserver.database.impl;

import com.yueserver.database.dao.BrandMapper;
import com.yueserver.enity.Brand;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public List queryBrd_PrdInfo() {
        return null;
    }

    @Override
    public List queryBrdName() {
        return this.brandMapper.queryBrdName();
    }

    @Override
    public boolean saveBatchBrand(@Param("brands") List<Brand> brands) {
        return this.brandMapper.saveBatchBrand(brands);
    }

    @Override
    public boolean delBatchBrand(@Param("brands") Set<Integer> brands) {
        return this.brandMapper.delBatchBrand(brands);
    }

    @Override
    public boolean updateBatchBrand(@Param("brands") List<Brand> brands) {
        return this.brandMapper.updateBatchBrand(brands);
    }


}
