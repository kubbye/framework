package com.wade.framework.admin.entity;

import java.util.Date;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: DictEntity</p>
 * <p>Description: 数据字典实体类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-09-04</p>
 */
public class DictEntity extends BaseEntity {
    
    /**
     * <p>Field id: 字典数据明细ID</p>
     */
    private Long id;
    
    /**
     * <p>Field typeCode: 字典明细编号</p>
     */
    private String typeCode;
    
    /**
     * <p>Field code: 代码</p>
     */
    private String code;
    
    /**
     * <p>Field displayname: 显示名称</p>
     */
    private String displayname;
    
    /**
     * <p>Field typeName: 字典类型名称</p>
     */
    private String typeName;
    
    /**
     * <p>Field sortId: 排序：数字越小排位越靠前</p>
     */
    private Integer sortId;
    
    /**
     * <p>Field editable: 是否可编辑：1，是；0，否</p>
     */
    private Integer editable;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTypeCode() {
        return typeCode;
    }
    
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDisplayname() {
        return displayname;
    }
    
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public Integer getSortId() {
        return sortId;
    }
    
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
    
    public Integer getEditable() {
        return editable;
    }
    
    public void setEditable(Integer editable) {
        this.editable = editable;
    }
    
    
}
