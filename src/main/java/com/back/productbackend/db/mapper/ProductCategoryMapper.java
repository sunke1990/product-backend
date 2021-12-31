package com.back.productbackend.db.mapper;

import com.back.productbackend.db.entity.ProductCategory;

/**
    * @author sunke
    * @DATE 2021/12/30
**/
public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}