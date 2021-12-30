package com.back.productbackend.db;

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
@ApiModel(value="com-back-productbackend-db-ProductOrder")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
    @ApiModelProperty(value="")
    private String id;

    /**
    * 买家名
    */
    @ApiModelProperty(value="买家名")
    private String buyerName;

    /**
    * 买家手机号
    */
    @ApiModelProperty(value="买家手机号")
    private String buyerPhone;

    /**
    * 买家地址
    */
    @ApiModelProperty(value="买家地址")
    private String buyerAddress;

    /**
    * 买家微信openid
    */
    @ApiModelProperty(value="买家微信openid")
    private String buyerOpenid;

    /**
    * 订单总金额
    */
    @ApiModelProperty(value="订单总金额")
    private BigDecimal orderAmount;

    /**
    * 订单状态,默认0新下单
    */
    @ApiModelProperty(value="订单状态,默认0新下单")
    private Byte status;

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