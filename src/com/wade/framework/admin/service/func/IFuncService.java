package com.wade.framework.admin.service.func;

import java.util.List;

import com.wade.framework.admin.entity.FuncEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

/**
 * <p>ClassName: IFuncService</p>
 * <p>Description: 菜单功能Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-10-19</p>
 */
public interface IFuncService {
    /**
     * <p>Description: 插入菜单功能</p>
     * @param func 菜单功能对象
     * @return
     */
    int insert(FuncEntity func);
    
    /**
     * <p>Description: 更新菜单功能</p>
     * @param func 菜单功能对象
     * @return
     */
    int update(FuncEntity func);
    
    /**
     * <p>Description: 删除菜单功能</p>
     * @param func 菜单功能对象
     * @return
     */
    int delete(FuncEntity func);
    
    /**
     * <p>Description: 根据菜单功能id查询菜单功能记录</p>
     * @param func 菜单功能对象
     * @return 菜单功能对象
     */
    FuncEntity queryObjectById(Long id);
    
    /**
     * <p>Description: 查询菜单功能记录列表</p>
     * @param param 菜单功能对象
     * @return 菜单功能记录列表
     */
    List<FuncEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询菜单功能记录列表</p>
     * @param param 菜单功能对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<FuncEntity> queryListByPage(FuncEntity param, PageInfo pageinfo);
}
