package com.wade.framework.admin.entity;

import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: MenuEntity</p>
 * <p>Description: 菜单实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-09-01</p>
 */
public class MenuEntity extends BaseEntity {
    
    /**
     * <p>Field id: 菜单代码</p>
     */
    private String code;
    
    /**
     * <p>Field parentId: 上级菜单代码</p>
     */
    private String parentCode;
    
    /**
     * <p>Field iconCls: 图标样式</p>
     */
    private String iconCls;
    
    /**
     * <p>Field picUrl: 桌面图标</p>
     */
    private String picUrl;
    
    /**
     * <p>Field menuPath: 菜单路径</p>
     */
    private String menuPath;
    
    /**
     * <p>Field mlevel: 菜单层级</p>
     */
    private Integer mlevel;
    
    /**
     * <p>Field mname: 菜单名称</p>
     */
    private String mname;
    
    /**
     * <p>Field url: 菜单路径</p>
     */
    private String url;
    
    /**
     * <p>Field menuSort: 菜单排序字段：越小越靠前</p>
     */
    private Integer menuSort;
    
    /**
     * <p>Field menuType: 菜单类型：N，一般菜单；S，系统菜单；D,数据监控菜单</p>
     */
    private String menuType;
    
    /**
     * <p>Field avaliable: Y 可用，N 不可用</p>
     */
    private String avaliable;
    
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getIconCls() {
        return iconCls;
    }
    
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    
    public String getPicUrl() {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
    public String getMenuPath() {
        return menuPath;
    }
    
    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }
    
    public Integer getMlevel() {
        return mlevel;
    }
    
    public void setMlevel(Integer mlevel) {
        this.mlevel = mlevel;
    }
    
    public String getMname() {
        return mname;
    }
    
    public void setMname(String mname) {
        this.mname = mname;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public Integer getMenuSort() {
        return menuSort;
    }
    
    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }
    
    public String getMenuType() {
        return menuType;
    }
    
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }
    
    public String getAvaliable() {
        return avaliable;
    }
    
    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
    
    
}
