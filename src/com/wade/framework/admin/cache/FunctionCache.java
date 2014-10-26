/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: FunctionCache.java
 * Author:   allways
 * Date:     2014年10月19日 下午9:04:19
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wade.framework.admin.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.ehcache.Element;

import com.wade.framework.admin.entity.FuncEntity;
import com.wade.framework.admin.service.func.IFuncService;
import com.wade.framework.base.cache.Cache;
import com.wade.framework.base.cache.ICache;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author weih
 */
public class FunctionCache implements ICache {

    @Autowired
    IFuncService funcService;
    
    net.sf.ehcache.Cache funcCache;
    
    @Override
    public void initCache() {
        funcCache.removeAll();
        List<FuncEntity> list = funcService.queryList(null);
        for(FuncEntity func : list){
            setSubCache(func);
        }
    }
    /**
     * 功能描述: <br>
     *    组织菜单功能按钮缓存
     *
     * @param func
     */
    private void setSubCache(FuncEntity func){
        Cache subCache = getCache(func.getMenuCode());
        List<Cache> subList = null;
        if(null == subCache){
            subList = new ArrayList<Cache>();
            subList.add(new Cache(func.getId(), func));
            addCache(new Cache(func.getMenuCode(), subList));
        } else {
            subList = (List<Cache>)subCache.getValue();
            subList.add(new Cache(func.getId(), func));
            refreshCache(new Cache(func.getMenuCode(), subList));
        }
    }
    @Override
    public Cache getCache(Object key) {
        Element e= funcCache.get(key);
        return null == e ? null : (Cache)e.getObjectValue();
    }

    @Override
    public void addCache(Cache cache) {
        funcCache.put(new Element(cache.getKey(),cache));
    }

    @Override
    public void refreshCache(Cache cache) {
        funcCache.replace(new Element(cache.getKey(),cache));
    }

    @Override
    public void removeCache(Object key) {
        funcCache.remove(key);
    }

    @Override
    public int size() {
        return funcCache.getSize();
    }

    @Override
    public List<Cache> getAllCache() {
        List<Cache> list = new ArrayList<>();
        Map<Object, Element> map = funcCache.getAll(funcCache.getKeys());
        for (Element e : map.values()) {
            list.add((Cache) e.getObjectValue());
        }
        return list;
    }
    
    public net.sf.ehcache.Cache getFuncCache() {
        return funcCache;
    }
    public void setFuncCache(net.sf.ehcache.Cache funcCache) {
        this.funcCache = funcCache;
    }

}
