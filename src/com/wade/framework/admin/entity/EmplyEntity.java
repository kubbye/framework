package com.wade.framework.admin.entity;

import java.util.Date;

import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: EmptyEntity</p>
 * <p>Description: 员工实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-06</p>
 */
public class EmplyEntity extends BaseEntity {
    
    /**
     * <p>Field empId: 员工ID</p>
     */
    private Long empId;
    
    /**
     * <p>Field userId: 可登录系统用户</p>
     */
    private Long userId;
    
    /**
     * <p>Field empName: 雇员姓名</p>
     */
    private String empName;
    
    /**
     * <p>Field certType: 证件类型:数据字典</p>
     */
    private String certType;
    
    /**
     * <p>Field certNo: 证件号码</p>
     */
    private String certNo;
    
    /**
     * <p>Field nativePlace: 籍贯</p>
     */
    private String nativePlace;
    
    /**
     * <p>Field nativeLocation: 户籍地址</p>
     */
    private String nativeLocation;
    
    /**
     * <p>Field address: 联系地址</p>
     */
    private String address;
    
    /**
     * <p>Field sex: 性别</p>
     */
    private String sex;
    
    /**
     * <p>Field zipCode: 联系地址邮政编码</p>
     */
    private String zipCode;
    
    /**
     * <p>Field position: 职位</p>
     */
    private String position;
    
    /**
     * <p>Field department: 部门</p>
     */
    private String department;
    
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
     * <p>Field compTel: 公司电话</p>
     */
    private String compTel;
    
    /**
     * <p>Field linkTel: 联系电话</p>
     */
    private String linkTel;
    
    /**
     * <p>Field homeAddress: 家庭住址</p>
     */
    private String homeAddress;
    
    /**
     * <p>Field email: 邮件</p>
     */
    private String email;
    
    /**
     * <p>Field weichat: 微信号</p>
     */
    private String weichat;
    
    /**
     * <p>Field msn: MSN号码</p>
     */
    private String msn;
    
    /**
     * <p>Field qq: QQ号码</p>
     */
    private String qq;
    
    /**
     * <p>Field weiblog: 微博</p>
     */
    private String weiblog;
    
    /**
     * <p>Field birthday: 生日</p>
     */
    private Date birthday;
    
    /**
     * <p>Field bloodType: 血型:数据字典</p>
     */
    private String bloodType;
    
    /**
     * <p>Field eduLevel: 学历:数据字典</p>
     */
    private String eduLevel;
    
    /**
     * <p>Field assumeDate: 上岗日期</p>
     */
    private Date assumeDate;
    
    /**
     * <p>Field leaveDate: 离职日期</p>
     */
    private Date leaveDate;
    
    /**
     * <p>Field political: 政治面貌:数据字典</p>
     */
    private String political;
    
    /**
     * <p>Field nation: 民族:数据字典</p>
     */
    private String nation;
    
    /**
     * <p>Field techLevel: 技术职称:数据字典</p>
     */
    private String techLevel;
    
    /**
     * <p>Field computer: 计算机能力:数据字典</p>
     */
    private String computer;
    
    /**
     * <p>Field fullJob: 专职OR 兼职:数据字典</p>
     */
    private String fullJob;
    
    /**
     * <p>Field driverLic: 是否有驾照:数据字典</p>
     */
    private String driverLic;
    
    /**
     * <p>Field other: 其他</p>
     */
    private String other;
    
    
    public Long getEmpId() {
        return empId;
    }
    
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getEmpName() {
        return empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public String getCertType() {
        return certType;
    }
    
    public void setCertType(String certType) {
        this.certType = certType;
    }
    
    public String getCertNo() {
        return certNo;
    }
    
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
    
    public String getNativePlace() {
        return nativePlace;
    }
    
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    
    public String getNativeLocation() {
        return nativeLocation;
    }
    
    public void setNativeLocation(String nativeLocation) {
        this.nativeLocation = nativeLocation;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
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
    
    public String getCompTel() {
        return compTel;
    }
    
    public void setCompTel(String compTel) {
        this.compTel = compTel;
    }
    
    public String getLinkTel() {
        return linkTel;
    }
    
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }
    
    public String getHomeAddress() {
        return homeAddress;
    }
    
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getWeichat() {
        return weichat;
    }
    
    public void setWeichat(String weichat) {
        this.weichat = weichat;
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
    
    public String getWeiblog() {
        return weiblog;
    }
    
    public void setWeiblog(String weiblog) {
        this.weiblog = weiblog;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String getBloodType() {
        return bloodType;
    }
    
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    
    public String getEduLevel() {
        return eduLevel;
    }
    
    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }
    
    public Date getAssumeDate() {
        return assumeDate;
    }
    
    public void setAssumeDate(Date assumeDate) {
        this.assumeDate = assumeDate;
    }
    
    public Date getLeaveDate() {
        return leaveDate;
    }
    
    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }
    
    public String getPolitical() {
        return political;
    }
    
    public void setPolitical(String political) {
        this.political = political;
    }
    
    public String getNation() {
        return nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    public String getTechLevel() {
        return techLevel;
    }
    
    public void setTechLevel(String techLevel) {
        this.techLevel = techLevel;
    }
    
    public String getComputer() {
        return computer;
    }
    
    public void setComputer(String computer) {
        this.computer = computer;
    }
    
    public String getFullJob() {
        return fullJob;
    }
    
    public void setFullJob(String fullJob) {
        this.fullJob = fullJob;
    }
    
    public String getDriverLic() {
        return driverLic;
    }
    
    public void setDriverLic(String driverLic) {
        this.driverLic = driverLic;
    }
    
    public String getOther() {
        return other;
    }
    
    public void setOther(String other) {
        this.other = other;
    }
    
    
}
