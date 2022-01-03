package com.back.productbackend.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (SystemUserRole)实体类
 *
 * @author makejava
 * @since 2022-01-01 22:27:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemUserRole implements Serializable {
    private static final long serialVersionUID = -75918356018597982L;
    
    private Long id;
    
    private Long userId;
    
    private Long roleId;

    private String shopId;
    
    private Date createTime;
    
    private Date updateTime;

}