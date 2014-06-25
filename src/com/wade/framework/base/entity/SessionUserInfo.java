package com.wade.framework.base.entity;

public class SessionUserInfo {
    /**
     * <p>Field userId: 用户id</p>
     */
    private Long userId;
    
    /**
     * <p>Field userName: 用户名称</p>
     */
    private String userName;
    
    /**
     * <p>Field loginId: 用户登录号</p>
     */
    private String loginId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
