/**
 * PageInfo.java
 */
package com.wade.framework.base;

/**
 * <p>ClassName: PageInfo</p>
 * <p>Description: 分页参数信息</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-5-20</p>
 */
public class PageInfo {
    /**
     * <p>Field page: 页码</p>
     */
    private int page;
    /**
     * <p>Field pageSize: 每页记录数</p>
     */
    private int pageSize;
    /**
     * <p>Field total: 总记录数</p>
     */
    private long total;
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    
    
}
