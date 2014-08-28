package com.wade.framework.base.cache;

import java.util.List;

/**
 *  缓存类接口<br> 
 *     
 *
 * @author weih
 */
public interface ICache {
    /**
     * 功能描述: <br>
     *    初始化所有的缓存
     *
     */
    void initCache();
    
    /**
     * 功能描述: <br>
     *    得到缓存项
     *
     * @param key
     * @return
     */
    Cache getCache(Object key);
    
    /**
     * 功能描述: <br>
     *    增加cache
     *
     * @param cache
     */
    void addCache(Cache cache); 
    /**
     * 功能描述: <br>
     *    刷新缓存项
     *
     * @param cache
     */
    void refreshCache(Cache cache);
    
    /**
     * 功能描述: <br>
     *    删除cache
     *
     * @param key
     */
    void removeCache(Object key); 
    
    /**
     * 功能描述: <br>
     *    缓存数量
     *
     * @return
     */
    int size();
    
    /**
     * 功能描述: <br>
     *    得到所有的缓存项
     *
     * @return
     */
    List<Cache> getAllCache();
}
