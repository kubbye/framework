package com.wade.framework.admin.entity;

import com.wade.framework.base.entity.BaseEntity;

/**
 *  用户岗位关系entity<br> 
 * 〈功能详细描述〉
 *
 * @author allways
 */
public class UserPostEntity extends BaseEntity {
    /**
     * id
     */
    private Long id;
    
    /**
     * 用户id
     */
    private Long userId;
    
    /**
     * 岗位id
     */
    private Long postId;

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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
    
    
}
