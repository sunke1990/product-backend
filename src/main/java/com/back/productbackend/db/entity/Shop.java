package com.back.productbackend.db.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 店铺表(Shop)实体类
 *
 * @author makejava
 * @since 2022-01-01 22:28:21
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = -83421995563681214L;
    /**
    * pk
    */
    private String id;
    /**
    * 店名
    */
    private Integer name;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getReputationGrade() {
        return reputationGrade;
    }

    public void setReputationGrade(Integer reputationGrade) {
        this.reputationGrade = reputationGrade;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}