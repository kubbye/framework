package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: MenuEntity</p>
 * <p>Description: 菜单实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-20</p>
 */
public class MenuEntity extends BaseEntity {
    
    /**
     * <p>Field menuId: </p>
     */
    private Long menuId;
    
    /**
     * <p>Field upMenuId: </p>
     */
    private Long upMenuId;
    
    /**
     * <p>Field iconCls: 图标样式</p>
     */
    private String iconCls;
    
    /**
     * <p>Field picUrl: 桌面图标</p>
     */
    private String picUrl;
    
    /**
     * <p>Field menuPath: </p>
     */
    private String menuPath;
    
    /**
     * <p>Field level: 菜单层级</p>
     */
    private Integer level;
    
    /**
     * <p>Field name: </p>
     */
    private String name;
    
    /**
     * <p>Field url: </p>
     */
    private String url;
    
    /**
     * <p>Field deCode: </p>
     */
    private String deCode;
    
    /**
     * <p>Field menuSort: </p>
     */
    private Long menuSort;
    
    /**
     * <p>Field sysMenu: </p>
     */
    private String sysMenu;
    
    /**
     * <p>Field openType: IFRAME,PANEL</p>
     */
    private String openType;
    
    /**
     * <p>Field available: Y 可用，N 不可用</p>
     */
    private String available;
    
    /**
     * <p>Field delFlag: Y 已删除，N 未删除</p>
     */
    private String delFlag;
    
    /**
     * <p>Field createUser: </p>
     */
    private String createUser;
    
    /**
     * <p>Field updateUser: </p>
     */
    private String updateUser;
    
    /**
     * <p>Field createTime: </p>
     */
    private Date createTime;
    
    /**
     * <p>Field updateTime: </p>
     */
    private Date updateTime;
    
    
    public Long getMenuId() {
        return menuId;
    }
    
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    
    public Long getUpMenuId() {
        return upMenuId;
    }
    
    public void setUpMenuId(Long upMenuId) {
        this.upMenuId = upMenuId;
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
    
    public Integer getLevel() {
        return level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDeCode() {
        return deCode;
    }
    
    public void setDeCode(String deCode) {
        this.deCode = deCode;
    }
    
    public Long getMenuSort() {
        return menuSort;
    }
    
    public void setMenuSort(Long menuSort) {
        this.menuSort = menuSort;
    }
    
    public String getSysMenu() {
        return sysMenu;
    }
    
    public void setSysMenu(String sysMenu) {
        this.sysMenu = sysMenu;
    }
    
    public String getOpenType() {
        return openType;
    }
    
    public void setOpenType(String openType) {
        this.openType = openType;
    }
    
    public String getAvailable() {
        return available;
    }
    
    public void setAvailable(String available) {
        this.available = available;
    }
    
    public String getDelFlag() {
        return delFlag;
    }
    
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    
    public String getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getUpdateUser() {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
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
    
    
}
