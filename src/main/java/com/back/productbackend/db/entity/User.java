package com.back.productbackend.db.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-12-31 15:58:27
 */
public class User implements Serializable {
    private static final long serialVersionUID = -75255199162867547L;
    
    private Long id;
    
    private String openId;
    /**
    * 电话号码
    */
    private String phone;
    /**
    * 密码
    */
    private String password;
    
    private String remark;
    /**
    * 微信sessionkey
    */
    private String wxSessionKey;
    /**
    * 微信头像链接
    */
    private String wxFaceUrl;
    /**
    * 微信昵称
    */
    private String wxName;
    /**
    * 性别（0：空,1：男，2：女））
    */
    private Integer gender;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 身份证号
    */
    private String idNumber;
    
    private Date createTime;
    
    private Date updateTime;
    /**
    * unionid from wechat
    */
    private String unionId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWxSessionKey() {
        return wxSessionKey;
    }

    public void setWxSessionKey(String wxSessionKey) {
        this.wxSessionKey = wxSessionKey;
    }

    public String getWxFaceUrl() {
        return wxFaceUrl;
    }

    public void setWxFaceUrl(String wxFaceUrl) {
        this.wxFaceUrl = wxFaceUrl;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

}