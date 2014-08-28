package com.wade.framework.base.cache;

import java.io.Serializable;

public class Cache implements Serializable {
    private Object key;
    private Object value;
    
    public Cache(Object key, Object value){
        this.key = key;
        this.value = value;
    }
    
    public Object getKey() {
        return key;
    }
    public void setKey(Object key) {
        this.key = key;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    
}
