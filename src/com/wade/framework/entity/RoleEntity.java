package com.wade.framework.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: RoleEntity</p>
 * <p>Description: 角色实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-22</p>
 */
public class RoleEntity extends BaseEntity {
    
    /**
     * <p>Field roleId: roleId</p>
     */
    private Long roleId;
    
    /**
     * <p>Field roleName: roleName</p>
     */
    private String roleName;
    
    /**
     * <p>Field roleType: 类型：R 角色，P 部门岗位</p>
     */
    private String roleType;
    
    /**
     * <p>Field roleScope: 公共角色：D 默认角色,C 通用角色,P 部门私有角色，S 系统级角色</p>
     */
    private String roleScope;
    
    /**
     * <p>Field orgId: 类型 为 P 部门自定义时有效</p>
     */
    private Long orgId;
    
    /**
     * <p>Field orgSimpleName: orgSimpleName</p>
     */
    private String orgSimpleName;
    
    /**
     * <p>Field available: Y 可用，N 不可用</p>
     */
    private String available;
    
    /**
     * <p>Field memo: memo</p>
     */
    private String memo;
    
    /**
     * <p>Field createUser: createUser</p>
     */
    private String createUser;
    
    /**
     * <p>Field updateUser: updateUser</p>
     */
    private String updateUser;
    
    /**
     * <p>Field createTime: createTime</p>
     */
    private Date createTime;
    
    /**
     * <p>Field updateTime: updateTime</p>
     */
    private Date updateTime;
    
    
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
    
    public String getRoleType() {
        return roleType;
    }
    
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    
    public String getRoleScope() {
        return roleScope;
    }
    
    public void setRoleScope(String roleScope) {
        this.roleScope = roleScope;
    }
    
    public Long getOrgId() {
        return orgId;
    }
    
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    
    public String getOrgSimpleName() {
        return orgSimpleName;
    }
    
    public void setOrgSimpleName(String orgSimpleName) {
        this.orgSimpleName = orgSimpleName;
    }
    
    public String getAvailable() {
        return available;
    }
    
    public void setAvailable(String available) {
        this.available = available;
    }
    
    public String getMemo() {
        return memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    public String getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getUpdateUser() {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
