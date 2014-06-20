package com.wade.framework.base.entity;

import java.io.Serializable;

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
    
    private PageInfo pageInfo = new PageInfo();
    
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
    
}
