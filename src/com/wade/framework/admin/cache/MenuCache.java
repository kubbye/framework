package com.wade.framework.admin.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;

import com.wade.framework.admin.entity.MenuEntity;
import com.wade.framework.admin.service.menu.IMenuService;
import com.wade.framework.base.cache.Cache;
import com.wade.framework.base.cache.ICache;

/**
 *  菜单缓存<br> 
 * 〈功能详细描述〉
 *
 * @author weih
 */
public class MenuCache implements ICache {
    public static final String MENU_KEY = "menu";
    public static final String SUB_MENU_KEY = "submenu";

    /**
     * 菜单service
     */
    @Autowired
    IMenuService menuService;
    
    net.sf.ehcache.Cache menuCache;
    
    
    @Override
    public void initCache() {
        menuCache.removeAll();
        
        List<MenuEntity> list = menuService.queryList(null);
        for(MenuEntity menu : list){
            //缓存当前菜单
            menuCache.put(new Element(MENU_KEY + menu.getId(), menu));
            //缓存子菜单
            setSubCache(menu);
        }
    }
    
    /**
     * 功能描述: <br>
     *    缓存子菜单，如果已存在，增加子项；如果不存在，增加缓存项。
     *
     * @param menu
     */
    private void setSubCache(MenuEntity menu){
        String key = SUB_MENU_KEY + menu.getParentId();
        Cache subCache = getCache(key);
        List<Cache> subList = null;
        if(null == subCache){
            subList = new ArrayList<Cache>();
            subList.add(new Cache(menu.getId(), menu));
            addCache(new Cache(key, subList));
        } else {
            subList = (List<Cache>)subCache.getValue();
            subList.add(new Cache(menu.getId(), menu));
            refreshCache(new Cache(key, subList));
        }
    }
    
    @Override
    public Cache getCache(Object key) {
        Element e= menuCache.get(key);
        return null == e ? null : (Cache)e.getObjectValue();
    }

    @Override
    public void addCache(Cache cache) {
        menuCache.put(new Element(cache.getKey(),cache));
    }

    @Override
    public void refreshCache(Cache cache) {
        menuCache.replace(new Element(cache.getKey(),cache));
    }

    @Override
    public void removeCache(Object key) {
        menuCache.remove(key);
    }

    @Override
    public int size() {
        return menuCache.getSize();
    }

    @Override
    public List<Cache> getAllCache() {
        List<Cache> list = new ArrayList<>();
        Map<Object, Element> map = menuCache.getAll(menuCache.getKeys());
        for(Element e : map.values()){
            if(e.getObjectKey().toString().startsWith(MENU_KEY)){
                list.add((Cache)e.getObjectValue());
            }
        }
        return list;
    }

    public net.sf.ehcache.Cache getMenuCache() {
        return menuCache;
    }

    public void setMenuCache(net.sf.ehcache.Cache menuCache) {
        this.menuCache = menuCache;
    }
    
}
