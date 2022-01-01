package com.back.productbackend.db.entity;

import lombok.Builder;

import java.util.Date;
import java.io.Serializable;

/**
 * (SystemUserRole)实体类
 *
 * @author makejava
 * @since 2022-01-01 22:27:53
 */
@Builder
public class SystemUserRole implements Serializable {
    private static final long serialVersionUID = -75918356018597982L;
    
    private Long id;
    
    private Long userId;
    
    private Long roleId;
    
    private Date createTime;
    
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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