package com.back.productbackend.db;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * @author sunke
    * @DATE 2021/12/30
**/
/**
    * 商品表
    */
@ApiModel(value="com-back-productbackend-db-ProductCategory")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 类目名
    */
    @ApiModelProperty(value="类目名")
    private String name;

    /**
    * 类目编号
    */
    @ApiModelProperty(value="类目编号")
    private Integer categoryType;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date updateTime;

    /**
    * 0 未删除 1 删除
    */
    @ApiModelProperty(value="0 未删除 1 删除")
    private Byte delFlag;
}