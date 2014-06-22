package org.code.util;

public class Field {
    /**
     * <p>Field name: 字段名称</p>
     */
    private String name;
    
    /**
     * <p>Field columnName: 数据库列名称</p>
     */
    private String columnName;
    /**
     * <p>Field type: 字段类型</p>
     */
    private String type;
    /**
     * <p>Field upperName: 字段首字母大写名称</p>
     */
    private String upperName;
    
    /**
     * <p>Field isNullable: 是否可以为空，默认是</p>
     */
    private boolean nullable=Boolean.TRUE;
    
    /**
     * <p>Field isPriKey: 是否主键，默认否</p>
     */
    private boolean priKey = Boolean.FALSE;
    
    /**
     * <p>Field comment: 字段备注</p>
     */
    private String comment;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUpperName() {
        return upperName;
    }
    public void setUpperName(String upperName) {
        this.upperName = upperName;
    }
   
    public boolean getNullable() {
        return nullable;
    }
    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }
    public boolean getPriKey() {
        return priKey;
    }
    public void setPriKey(boolean priKey) {
        this.priKey = priKey;
    }
    public String getComment() {
        if(null == comment || "".equals(comment)){
            return name;
        }
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
