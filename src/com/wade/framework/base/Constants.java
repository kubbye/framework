package com.wade.framework.base;

public class Constants {
    /**
     * 机构的根路径
     */
    public static final Long ORG_ROOT= 0L;
    
    /**
     * 岗位根路径
     */
    public static final Long POST_ROOT= 0L;
    
    /**
     * 路径分隔符
     */
    public static final String PATH_SEPRATOR=">>";
    
    
    /**
     * 授权类型：岗位
     */
    public static final Integer AUTHORITY_POST = Integer.valueOf("0000000001",2);
    /**
     * 授权类型：角色
     */
    public static final Integer AUTHORITY_ROLE = Integer.valueOf("0000000010",2);
    
    /**
     * 授权类型：资源类型，菜单
     */
    public static final String RESOURCE_TYPE_MENU = "M";
    
    /**
     * 授权类型：资源类型，功能按钮
     */
    public static final String RESOURCE_TYPE_FUNCTION = "F";
    
}
