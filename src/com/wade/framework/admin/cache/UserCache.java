package com.wade.framework.admin.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;

import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.service.user.IUserService;
import com.wade.framework.base.cache.Cache;
import com.wade.framework.base.cache.ICache;

public class UserCache implements ICache {

    @Autowired
    private IUserService userService;
    
    net.sf.ehcache.Cache userCache;
    @Override
    public void initCache(){
        userCache.removeAll();
     
        List<UserEntity> userList=userService.queryAllUsers();
        for(UserEntity user: userList){
            userCache.put(new Element(user.getUserId(), new Cache(user.getUserId(),user)));
        }
    }
    @Override
    public Cache getCache(Object key){
        Element e= userCache.get(key);
        return null == e ? null : (Cache)e.getObjectValue();
    }
    
    
    @Override
    public void addCache(Cache cache) {
        userCache.put(new Element(cache.getKey(),cache));
    }
    @Override
    public void refreshCache(Cache cache){
        userCache.replace(new Element(cache.getKey(),cache));
    }
    
    
    @Override
    public void removeCache(Object key) {
        userCache.remove(key);
    }
    @Override
    public int size(){
        return userCache.getSize();
    }
    @Override
    public List<Cache> getAllCache(){
        List<Cache> list = new ArrayList<>();
        Map<Object, Element> map = userCache.getAll(userCache.getKeys());
        for(Element e : map.values()){
            list.add((Cache)e.getObjectValue());
        }
        return list;
    }

    public net.sf.ehcache.Cache getUserCache() {
        return userCache;
    }
    public void setUserCache(net.sf.ehcache.Cache userCache) {
        this.userCache = userCache;
    }
    
    
    
}
