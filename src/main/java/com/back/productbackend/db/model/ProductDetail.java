package com.back.productbackend.db.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
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
@ApiModel(value="com-back-productbackend-db-ProductDetail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 订单id
    */
    @ApiModelProperty(value="订单id")
    private String orderId;

    /**
    * 商品id
    */
    @ApiModelProperty(value="商品id")
    private String productId;

    /**
    * 商品名
    */
    @ApiModelProperty(value="商品名")
    private String productName;

    /**
    * 商品价格
    */
    @ApiModelProperty(value="商品价格")
    private BigDecimal productPrice;

    /**
    * 商品数量
    */
    @ApiModelProperty(value="商品数量")
    private Integer productQuantity;

    /**
    * 图标
    */
    @ApiModelProperty(value="图标")
    private String productIcon;

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