package com.back.productbackend.db.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sunke
 * @DATE 2021/12/30
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    @ApiModelProperty(value="")
    private String id;

    /**
     * 商品名
     */
    @ApiModelProperty(value="商品名")
    private String name;

    /**
     * 商品价格
     */
    @ApiModelProperty(value="商品价格")
    private BigDecimal price;

    /**
     * 库存
     */
    @ApiModelProperty(value="库存")
    private Integer stock;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 图标
     */
    @ApiModelProperty(value="图标")
    private String icon;

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
