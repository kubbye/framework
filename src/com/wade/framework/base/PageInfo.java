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
     * <p>Field pagesize: 每页记录数</p>
     */
    private int rows;
    /**
     * <p>Field total: 总记录数</p>
     */
    private long total;
    
    public int getPage() {
        if(page==0){
            page = 1;
        }
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getRows() {
        if(rows==0){
            rows = 10;
        }
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    
    
}
