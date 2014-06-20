package com.wade.framework.admin.entity;

import com.wade.framework.base.entity.BaseEntity;

public class UserEntity extends BaseEntity {
    
    /**
     * <p>Field userId: 用户id</p>
     */
    private Long userId;
    
    /**
     * <p>Field orgId: 组织id</p>
     */
    private Long orgId;
    
    /**
     * <p>Field lgName: 登录名称</p>
     */
    private String lgName;
    
    /**
     * <p>Field userName: 用户名称</p>
     */
    private String userName;
    
    /**
     * <p>Field available: 状态</p>
     */
    private String available;
    
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getOrgId() {
        return orgId;
    }
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    public String getLgName() {
        return lgName;
    }
    public void setLgName(String lgName) {
        this.lgName = lgName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAvailable() {
        return available;
    }
    public void setAvailable(String available) {
        this.available = available;
    }
   
    
    
}
