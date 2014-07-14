package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: SyslogEntity</p>
 * <p>Description: 系统日志实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-07</p>
 */
public class SyslogEntity extends BaseEntity {
    
    /**
     * <p>Field id: 日志id</p>
     */
    private Long id;
    
    /**
     * <p>Field moduleCode: 模块代码</p>
     */
    private String moduleCode;
    
    /**
     * <p>Field moduleName: 模块名称</p>
     */
    private String moduleName;
    
    /**
     * <p>Field actType: 操作类型：增删改查</p>
     */
    private Integer actType;
    
    /**
     * <p>Field detailId: 数据id</p>
     */
    private String detailId;
    
    /**
     * <p>Field memo: 备注</p>
     */
    private String memo;
    
    /**
     * <p>Field operatorId: 操作人ID</p>
     */
    private Long operatorId;
    
    /**
     * <p>Field operatorName: 操作人姓名</p>
     */
    private String operatorName;
    
    /**
     * <p>Field operateDate: 操作日期</p>
     */
    private Date operateDate;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getModuleCode() {
        return moduleCode;
    }
    
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public Integer getActType() {
        return actType;
    }
    
    public void setActType(Integer actType) {
        this.actType = actType;
    }
    
    public String getDetailId() {
        return detailId;
    }
    
    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }
    
    public String getMemo() {
        return memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    public Long getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
    
    public String getOperatorName() {
        return operatorName;
    }
    
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
    
    public Date getOperateDate() {
        return operateDate;
    }
    
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }
    
    
}
