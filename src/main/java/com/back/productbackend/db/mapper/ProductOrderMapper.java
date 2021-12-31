package com.back.productbackend.db.mapper;

import com.back.productbackend.db.entity.ProductOrder;

/**
    * @author sunke
    * @DATE 2021/12/30
**/
public interface ProductOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductOrder record);

    int insertSelective(ProductOrder record);

    ProductOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductOrder record);

    int updateByPrimaryKey(ProductOrder record);
}