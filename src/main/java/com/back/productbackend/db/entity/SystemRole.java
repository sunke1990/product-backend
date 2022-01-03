package com.back.productbackend.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色表(SystemRole)实体类
 *
 * @author makejava
 * @since 2021-12-31 15:58:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}