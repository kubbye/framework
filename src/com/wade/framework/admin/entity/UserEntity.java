package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: UserEntity</p>
 * <p>Description: 用户实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-20</p>
 */
public class UserEntity extends BaseEntity {
    
    /**
     * <p>Field userId: </p>
     */
    private Long userId;
    
    /**
     * <p>Field orgId: 所在机构</p>
     */
    private Long orgId;
    
    /**
     * <p>Field lgName: </p>
     */
    private String lgName;
    
    /**
     * <p>Field userName: 用户名</p>
     */
    private String userName;
    
    /**
     * <p>Field passWord: </p>
     */
    private String passWord;
    
    /**
     * <p>Field sex: </p>
     */
    private String sex;
    
    /**
     * <p>Field position: 职位</p>
     */
    private String position;
    
    /**
     * <p>Field msn: </p>
     */
    private String msn;
    
    /**
     * <p>Field qq: </p>
     */
    private String qq;
    
    /**
     * <p>Field photo: 照片</p>
     */
    private String photo;
    
    /**
     * <p>Field mobile: 手机</p>
     */
    private String mobile;
    
    /**
     * <p>Field mobile2: 手机2</p>
     */
    private String mobile2;
    
    /**
     * <p>Field homeTel: 家庭电话</p>
     */
    private String homeTel;
    
    /**
     * <p>Field officeTel: 办公电话</p>
     */
    private String officeTel;
    
    /**
     * <p>Field homeAddress: 家庭住址</p>
     */
    private String homeAddress;
    
    /**
     * <p>Field valid: 有效期</p>
     */
    private String valid;
    
    /**
     * <p>Field email: 邮件</p>
     */
    private String email;
    
    /**
     * <p>Field memo: 备注</p>
     */
    private String memo;
    
    /**
     * <p>Field defaultRole: 默认角色</p>
     */
    private Long defaultRole;
    
    /**
     * <p>Field defaultRoleName: </p>
     */
    private String defaultRoleName;
    
    /**
     * <p>Field available: Y 可用，N 不可用</p>
     */
    private String available;
    
    /**
     * <p>Field userType: 客户类型</p>
     */
    private String userType;
    
    /**
     * <p>Field mark: </p>
     */
    private String mark;
    
    /**
     * <p>Field createUser: </p>
     */
    private Long createUser;
    
    /**
     * <p>Field updateUser: </p>
     */
    private Long updateUser;
    
    /**
     * <p>Field createTime: </p>
     */
    private Date createTime;
    
    /**
     * <p>Field updateTime: </p>
     */
    private Date updateTime;
    
    
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
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getMsn() {
        return msn;
    }
    
    public void setMsn(String msn) {
        this.msn = msn;
    }
    
    public String getQq() {
        return qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }
    
    public String getPhoto() {
        return photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getMobile2() {
        return mobile2;
    }
    
    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }
    
    public String getHomeTel() {
        return homeTel;
    }
    
    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }
    
    public String getOfficeTel() {
        return officeTel;
    }
    
    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }
    
    public String getHomeAddress() {
        return homeAddress;
    }
    
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    public String getValid() {
        return valid;
    }
    
    public void setValid(String valid) {
        this.valid = valid;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
    
    public String getAvailable() {
        return available;
    }
    
    public void setAvailable(String available) {
        this.available = available;
    }
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getMark() {
        return mark;
    }
    
    public void setMark(String mark) {
        this.mark = mark;
    }
    
    public Long getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
    
    public Long getUpdateUser() {
        return updateUser;
    }
    
    public void setUpdateUser(Long updateUser) {
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
