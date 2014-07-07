package com.wade.framework.base.dao;

import java.util.List;

import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.BaseEntity;

/**
 * <p>ClassName: IBaseDao</p>
 * <p>Description: dao基类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-6-16</p>
 */
public interface IBaseDao {
    
    /**
     * <p>Description: 插入记录</p>
     * @param sqlId
     * @param param
     * @return
     */
    int insert(String sqlId, Object param);
    
    /**
     * <p>Description: 更新记录</p>
     * @param sqlId
     * @param param
     * @return
     */
    int update(String sqlId, Object param);
    
    /**
     * <p>Description: 删除记录</p>
     * @param sqlId 
     * @param param
     * @return
     */
    int delete(String sqlId, Object param);
    
    /**
     * <p>Description: 根据主键查询记录</p>
     * @param sqlId
     * @param param
     * @return
     */
    <T> T queryObjectById(String sqlId, Object param);
    
    /**
     * <p>Description: 查询记录列表</p>
     * @param sqlId
     * @param param
     * @return
     */
    <T> List<T> queryList(String sqlId, Object param);
    
    /**
     * <p>Description: 分页查询记录列表：默认查询总记录数</p>
     * @param sqlId
     * @param param
     * @param pageinfo
     * @return
     */
    <T> PaginationResult<T> queryListByPage(String sqlId, BaseEntity param, PageInfo pageinfo);
    
    /**
     * <p>Description: 分页查询记录列表：自定义sql查询总记录数</p>
     * @param sqlId
     * @param countId
     * @param param
     * @param pageinfo
     * @return
     */
    <T> PaginationResult<T> queryListByPage(String sqlId, String countId, BaseEntity param, PageInfo pageinfo); 
    
    /**
     * 功能描述: 得到记录数量<br>
     * 〈功能详细描述〉
     *
     * @param sqlId
     * @param param
     * @return
     */
    Long getCount(String sqlId, BaseEntity param);
}
