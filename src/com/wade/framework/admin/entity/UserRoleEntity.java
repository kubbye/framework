package com.wade.framework.admin.entity;

/**
 *  用户角色关系实体类<br> 
 * 〈功能详细描述〉
 *
 * @author allways
 */
public class UserRoleEntity {
    /**
     * id
     */
    private Long id;
    
    /**
     * 用户id
     */
    private Long userId;
    
    /**
     * 角色id
     */
    private Long roleId;

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
}
