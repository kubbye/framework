package com.wade.framework.admin.entity;

import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: UserEntity</p>
 * <p>Description: 用户实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
 */
public class UserEntity extends BaseEntity {
    
    /**
     * <p>Field userId: 用户ID</p>
     */
    private Long userId;
    
    /**
     * <p>Field orgId: 所在机构</p>
     */
    private Long orgId;
    
    /**
     * 机构
     */
    private OrgEntity org=new OrgEntity();
    
    /**
     * <p>Field loginId: 用户登录号</p>
     */
    private String loginId;
    
    /**
     * <p>Field lgName: 登录名称</p>
     */
    private String lgName;
    
    /**
     * <p>Field userName: 用户昵称</p>
     */
    private String userName;
    
    /**
     * <p>Field passWord: 密码</p>
     */
    private String passWord;
    
    /**
     * <p>Field sex: 性别</p>
     */
    private String sex;
    
    /**
     * <p>Field photo: 照片</p>
     */
    private String photo;
    
    /**
     * <p>Field memo: 备注</p>
     */
    private String memo;
    
    /**
     * <p>Field defaultRole: 默认角色</p>
     */
    private Long defaultRole;
    
    /**
     * <p>Field defaultRoleName: 默认角色名称</p>
     */
    private String defaultRoleName;
    
    /**
     * <p>Field userType: 用户类型：A,管理员;P,应用</p>
     */
    private String userType;
    
    /**
     * <p>Field avaliable: 状态：Y 可用，N 不可用</p>
     */
    private String avaliable;
    
    /**
     * 员工
     */
    private EmplyEntity emply = new EmplyEntity();
    
    /**
     * 岗位id
     */
    private Long postId;
    /**
     * 岗位
     */
    private PostEntity position=new PostEntity();
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getOrgId() {
        return orgId;
    }
    
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    
    public String getLoginId() {
        return loginId;
    }
    
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    
    public String getLgName() {
        return lgName;
    }
    
    public void setLgName(String lgName) {
        this.lgName = lgName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getPhoto() {
        return photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public String getMemo() {
        return memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    public Long getDefaultRole() {
        return defaultRole;
    }
    
    public void setDefaultRole(Long defaultRole) {
        this.defaultRole = defaultRole;
    }
    
    public String getDefaultRoleName() {
        return defaultRoleName;
    }
    
    public void setDefaultRoleName(String defaultRoleName) {
        this.defaultRoleName = defaultRoleName;
    }
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getAvaliable() {
        return avaliable;
    }
    
    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }

    public EmplyEntity getEmply() {
        return emply;
    }

    public void setEmply(EmplyEntity emply) {
        this.emply = emply;
    }

    public OrgEntity getOrg() {
        return org;
    }

    public void setOrg(OrgEntity org) {
        this.org = org;
    }

    public PostEntity getPosition() {
        return position;
    }

    public void setPosition(PostEntity position) {
        this.position = position;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
    
}
