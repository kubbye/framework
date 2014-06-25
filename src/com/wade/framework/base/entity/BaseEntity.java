package com.wade.framework.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.wade.framework.base.PageInfo;

/**
 * <p>ClassName: BaseEntity</p>
 * <p>Description: entity基类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-6-16</p>
 */
public class BaseEntity implements Serializable {
    
    /**
     * <p>Field serialVersionUID: serialVersionUID</p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * <p>Field createUser: createUser</p>
     */
    private Long createUser;
    
    /**
     * <p>Field updateUser: updateUser</p>
     */
    private Long updateUser;
    
    /**
     * <p>Field createTime: createTime</p>
     */
    private Date createTime;
    
    /**
     * <p>Field updateTime: updateTime</p>
     */
    private Date updateTime;
    
    /**
     * <p>Field deleteMark:删除标记：0，未删除；1，已删除 </p>
     */
    private String deleteMark;
    
    private PageInfo pageInfo = new PageInfo();
    
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
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

    public String getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(String deleteMark) {
        this.deleteMark = deleteMark;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
    
    
}
