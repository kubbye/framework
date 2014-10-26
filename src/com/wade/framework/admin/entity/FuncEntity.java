package com.wade.framework.admin.entity;

import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: FuncEntity</p>
 * <p>Description: 菜单功能实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-10-19</p>
 */
public class FuncEntity extends BaseEntity {
    
    /**
     * <p>Field id: 功能ID</p>
     */
    private Long id;
    
    /**
     * <p>Field funcName: 功能名称</p>
     */
    private String funcName;
    
    /**
     * <p>Field funcCode: 代码，唯一</p>
     */
    private String funcCode;
    
    /**
     * <p>Field url: 路径</p>
     */
    private String url;
    
    /**
     * <p>Field menuId: 菜单代码</p>
     */
    private String menuCode;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFuncName() {
        return funcName;
    }
    
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
    
    public String getFuncCode() {
        return funcCode;
    }
    
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
   
    
    
}
