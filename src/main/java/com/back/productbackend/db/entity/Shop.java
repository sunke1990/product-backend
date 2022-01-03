package com.back.productbackend.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 店铺表(Shop)实体类
 *
 * @author makejava
 * @since 2022-01-01 22:28:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shop implements Serializable {
    private static final long serialVersionUID = -83421995563681214L;
    /**
    * pk
    */
    private String id;
    /**
    * 店名
    */
    private String name;
    /**
    * 店铺头像
    */
    private String icon;
    /**
    * 类型
    */
    private Integer type;
    /**
    * 店铺规模
    */
    private Integer size;
    /**
    * 信誉分
    */
    private Integer reputationGrade;
    /**
    * 粉丝数
    */
    private Integer fansNum;
    /**
    * 发布时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

}