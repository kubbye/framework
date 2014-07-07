package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: OrgEntity</p>
 * <p>Description: 机构实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-03</p>
 */
public class OrgEntity extends BaseEntity {
    
    /**
     * <p>Field orgId: 机构ID</p>
     */
    private Long orgId;
    
    /**
     * <p>Field parentId: 上级机构ID</p>
     */
    private Long parentId;
    
    /**
     * <p>Field orgCode: 机构代码</p>
     */
    private String orgCode;
    
    /**
     * <p>Field orgPath: 机构路径</p>
     */
    private String orgPath;
    
    /**
     * <p>Field orgSimpleName: 简称</p>
     */
    private String orgSimpleName;
    
    /**
     * <p>Field orgFullName: 机构全称</p>
     */
    private String orgFullName;
    
    /**
     * <p>Field orgAddress1: 机构地址1</p>
     */
    private String orgAddress1;
    
    /**
     * <p>Field orgAddress2: 机构地址2</p>
     */
    private String orgAddress2;
    
    /**
     * <p>Field orgTel1: 机构电话1</p>
     */
    private String orgTel1;
    
    /**
     * <p>Field orgTel2: 机构电话2</p>
     */
    private String orgTel2;
    
    /**
     * <p>Field orgRegDate: 机构注册日期</p>
     */
    private Date orgRegDate;
    
    /**
     * <p>Field orgType: 类型:</p>
     */
    private String orgType;
    
    /**
     * <p>Field orgFax: 机构传真</p>
     */
    private String orgFax;
    
    /**
     * <p>Field orgPostal: 机构邮编</p>
     */
    private String orgPostal;
    
    /**
     * <p>Field orgLegal: 法人</p>
     */
    private String orgLegal;
    
    /**
     * <p>Field orgTaxNo: 税号</p>
     */
    private String orgTaxNo;
    
    /**
     * <p>Field orgRegNo: 注册登记号</p>
     */
    private String orgRegNo;
    
    /**
     * <p>Field orgBelongDist: 所在地区</p>
     */
    private String orgBelongDist;
    
    /**
     * <p>Field webUrl: 主页</p>
     */
    private String webUrl;
    
    /**
     * <p>Field weichat: 微信号</p>
     */
    private String weichat;
    
    /**
     * <p>Field weiblog: 微博</p>
     */
    private String weiblog;
    
    /**
     * <p>Field memo: 备注</p>
     */
    private String memo;
    
    /**
     * <p>Field orgState: 机构状态：Y 营业中,N 停业</p>
     */
    private String orgState;
    
    /**
     * <p>Field avaliable: Y 可用，N 不可用</p>
     */
    private String avaliable;
    
    
    public Long getOrgId() {
        return orgId;
    }
    
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public String getOrgCode() {
        return orgCode;
    }
    
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    
    public String getOrgPath() {
        return orgPath;
    }
    
    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }
    
    public String getOrgSimpleName() {
        return orgSimpleName;
    }
    
    public void setOrgSimpleName(String orgSimpleName) {
        this.orgSimpleName = orgSimpleName;
    }
    
    public String getOrgFullName() {
        return orgFullName;
    }
    
    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName;
    }
    
    public String getOrgAddress1() {
        return orgAddress1;
    }
    
    public void setOrgAddress1(String orgAddress1) {
        this.orgAddress1 = orgAddress1;
    }
    
    public String getOrgAddress2() {
        return orgAddress2;
    }
    
    public void setOrgAddress2(String orgAddress2) {
        this.orgAddress2 = orgAddress2;
    }
    
    public String getOrgTel1() {
        return orgTel1;
    }
    
    public void setOrgTel1(String orgTel1) {
        this.orgTel1 = orgTel1;
    }
    
    public String getOrgTel2() {
        return orgTel2;
    }
    
    public void setOrgTel2(String orgTel2) {
        this.orgTel2 = orgTel2;
    }
    
    public Date getOrgRegDate() {
        return orgRegDate;
    }
    
    public void setOrgRegDate(Date orgRegDate) {
        this.orgRegDate = orgRegDate;
    }
    
    public String getOrgType() {
        return orgType;
    }
    
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
    
    public String getOrgFax() {
        return orgFax;
    }
    
    public void setOrgFax(String orgFax) {
        this.orgFax = orgFax;
    }
    
    public String getOrgPostal() {
        return orgPostal;
    }
    
    public void setOrgPostal(String orgPostal) {
        this.orgPostal = orgPostal;
    }
    
    public String getOrgLegal() {
        return orgLegal;
    }
    
    public void setOrgLegal(String orgLegal) {
        this.orgLegal = orgLegal;
    }
    
    public String getOrgTaxNo() {
        return orgTaxNo;
    }
    
    public void setOrgTaxNo(String orgTaxNo) {
        this.orgTaxNo = orgTaxNo;
    }
    
    public String getOrgRegNo() {
        return orgRegNo;
    }
    
    public void setOrgRegNo(String orgRegNo) {
        this.orgRegNo = orgRegNo;
    }
    
    public String getOrgBelongDist() {
        return orgBelongDist;
    }
    
    public void setOrgBelongDist(String orgBelongDist) {
        this.orgBelongDist = orgBelongDist;
    }
    
    public String getWebUrl() {
        return webUrl;
    }
    
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
    
    public String getWeichat() {
        return weichat;
    }
    
    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }
    
    public String getWeiblog() {
        return weiblog;
    }
    
    public void setWeiblog(String weiblog) {
        this.weiblog = weiblog;
    }
    
    public String getMemo() {
        return memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    public String getOrgState() {
        return orgState;
    }
    
    public void setOrgState(String orgState) {
        this.orgState = orgState;
    }
    
    public String getAvaliable() {
        return avaliable;
    }
    
    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
    
    
}
