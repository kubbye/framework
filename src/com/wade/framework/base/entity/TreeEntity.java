package com.wade.framework.base.entity;

/**
 * 〈一句话功能简述〉树形控件基类<br> 
 * 〈功能详细描述〉
 *
 * @author allways
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TreeEntity{
    /**
     * id
     */
    private Long id;
    
    /**
     * 父节点id
     */
    private Long parentId;
    
    /**
     * 代码
     */
    private String code;
    
    /**
     * 节点名称
     */
    private String name;
    
    /**
     * 图标
     */
    private String icon;
    
    /**
     * 节点路径
     */
    private String path;
    
    /**
     * 是否可以触发click事件
     */
    private String click;
    
    /**
     * 是否默认展开节点
     */
    private String open;
    
    /**
     * url
     */
    private String url;
    
    /**
     * 目标
     */
    private String target;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
