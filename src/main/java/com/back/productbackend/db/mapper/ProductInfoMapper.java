package com.back.productbackend.db.mapper;

import com.back.productbackend.db.model.ProductInfo;

/**
    * @author sunke
    * @DATE 2021/12/30
**/
public interface ProductInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}