package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: PostEntity</p>
 * <p>Description: 岗位实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
 */
public class PostEntity extends BaseEntity {
    
    /**
     * <p>Field id: 岗位ID</p>
     */
    private Long id;
    
    /**
     * <p>Field orgId: 机构ID</p>
     */
    private Long orgId;
    
    /**
     * <p>Field parentId: 上级岗位ID</p>
     */
    private Long parentId;
    
    /**
     * <p>Field postPath: 岗位路径</p>
     */
    private String postPath;
    
    /**
     * <p>Field postName: 岗位名称</p>
     */
    private String postName;
    
    /**
     * <p>Field postDesc: 岗位描述</p>
     */
    private String postDesc;
    
    /**
     * <p>Field avaliable: 状态：Y 可用，N 不可用</p>
     */
    private String avaliable;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getOrgId() {
        return orgId;
    }
    
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public String getPostPath() {
        return postPath;
    }
    
    public void setPostPath(String postPath) {
        this.postPath = postPath;
    }
    
    public String getPostName() {
        return postName;
    }
    
    public void setPostName(String postName) {
        this.postName = postName;
    }
    
    public String getPostDesc() {
        return postDesc;
    }
    
    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }
    
    public String getAvaliable() {
        return avaliable;
    }
    
    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
    
    
}
