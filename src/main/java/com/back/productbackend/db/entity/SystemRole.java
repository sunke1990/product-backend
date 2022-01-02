package com.back.productbackend.db.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色表(SystemRole)实体类
 *
 * @author makejava
 * @since 2021-12-31 15:58:18
 */
public class SystemRole implements Serializable {
    private static final long serialVersionUID = 333567557310350497L;
    /**
    * pk
    */
    private String id;
    /**
    * 角色
    */
    private Integer role;

    private String name;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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