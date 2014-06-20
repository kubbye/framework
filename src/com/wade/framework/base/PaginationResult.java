package com.wade.framework.base;

import java.util.List;

public class PaginationResult<T> {
    private int page;
    private long total;

    private List<T> rows;

    public PaginationResult(List<T> t,PageInfo pageInfo){
        this.rows=t;
        this.page = pageInfo.getPage();
        this.total = pageInfo.getTotal();
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> t) {
        this.rows = t;
    }
    
    
}
