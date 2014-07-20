package com.wade.framework.admin.service.menu;

import java.util.List;

import com.wade.framework.admin.entity.MenuEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

/**
 * <p>ClassName: IMenuService</p>
 * <p>Description: 菜单Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-20</p>
 */
public interface IMenuService {
    /**
     * <p>Description: 插入菜单</p>
     * @param menu 菜单对象
     * @return
     */
    int insert(MenuEntity menu);
    
    /**
     * <p>Description: 更新菜单</p>
     * @param menu 菜单对象
     * @return
     */
    int update(MenuEntity menu);
    
    /**
     * <p>Description: 删除菜单</p>
     * @param menu 菜单对象
     * @return
     */
    int delete(MenuEntity menu);
    
    /**
     * <p>Description: 根据菜单id查询菜单记录</p>
     * @param menu 菜单对象
     * @return 菜单对象
     */
    MenuEntity queryObjectById(Long id);
    
    /**
     * <p>Description: 查询菜单记录列表</p>
     * @param param 菜单对象
     * @return 菜单记录列表
     */
    List<MenuEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询菜单记录列表</p>
     * @param param 菜单对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<MenuEntity> queryListByPage(MenuEntity param, PageInfo pageinfo);
}
