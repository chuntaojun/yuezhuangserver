package com.yueserver.database.dao;

import com.yueserver.enity.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BrandMapper {

    Brand getBrand(String brdname);
    List queryBrandInfo(int mctNo);
    List queryBrandInfoAdmin();
    List queryBrdName(int mctNo);

    boolean saveBatchBrand(List<Brand> brands);
    boolean delBatchBrand(Set<Integer> brands);
    boolean updateBatchBrand(Brand brand);

}
