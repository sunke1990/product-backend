package com.back.productbackend.db;

import com.back.productbackend.db.ProductDetail;

/**
    * @author sunke
    * @DATE 2021/12/30
**/
public interface ProductDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
}