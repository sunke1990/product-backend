package com.back.productbackend.db.mapper;

import com.back.productbackend.db.model.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 批量插入
     * @param infos
     */
    void insertBatch(@Param("infos") List<ProductInfo> infos);

    /**
     * 根据商品类别获取列表
     * @param type
     * @return
     */
    List<ProductInfo> queryProsByCategoryType(@Param("type") Integer type);
}