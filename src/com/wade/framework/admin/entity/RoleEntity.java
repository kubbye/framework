package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: RoleEntity</p>
 * <p>Description: 角色实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-28</p>
 */
public class RoleEntity extends BaseEntity {
    
    /**
     * <p>Field roleId: 角色ID</p>
     */
    private Long roleId;
    
    /**
     * <p>Field roleName: 角色名称</p>
     */
    private String roleName;
    
    /**
     * <p>Field orgId: 机构ID</p>
     */
    private Long orgId;
    
    /**
     * <p>Field memo: 备注</p>
     */
    private String memo;
    
    /**
     * <p>Field avaliable: Y 可用，N 不可用</p>
     */
    private String avaliable;
    
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public Long getOrgId() {
        return orgId;
    }
    
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    
    public String getMemo() {
        return memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    public String getAvaliable() {
        return avaliable;
    }
    
    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
    
    
}
