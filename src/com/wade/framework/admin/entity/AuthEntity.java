package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: AuthEntity</p>
 * <p>Description: 授权实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-11</p>
 */
public class AuthEntity extends BaseEntity {
    
    /**
     * <p>Field id: 授权ID</p>
     */
    private Long id;
    
    /**
     * <p>Field resourceId: 资源ID</p>
     */
    private Long resourceId;
    
    /**
     * <p>Field authId: 授权对象ID</p>
     */
    private Long authId;
    
    /**
     * <p>Field authType: 授权类型：1，岗位；2，角色</p>
     */
    private Integer authType;
    
    /**
     * <p>Field restype: 权限类型：1，菜单；2，功能code</p>
     */
    private String restype;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getResourceId() {
        return resourceId;
    }
    
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    
    public Long getAuthId() {
        return authId;
    }
    
    public void setAuthId(Long authId) {
        this.authId = authId;
    }
    
    public Integer getAuthType() {
        return authType;
    }
    
    public void setAuthType(Integer authType) {
        this.authType = authType;
    }
    
    public String getRestype() {
        return restype;
    }
    
    public void setRestype(String restype) {
        this.restype = restype;
    }
    
    
}
