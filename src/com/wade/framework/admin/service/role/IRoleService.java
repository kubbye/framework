package com.wade.framework.admin.service.role;

import java.util.List;

import com.wade.framework.admin.entity.RoleEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.TreeEntity;

/**
 * <p>ClassName: IRoleService</p>
 * <p>Description: 角色Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-28</p>
 */
public interface IRoleService {
    /**
     * <p>Description: 插入角色</p>
     * @param role 角色对象
     * @return
     */
    int insert(RoleEntity role);
    
    /**
     * <p>Description: 更新角色</p>
     * @param role 角色对象
     * @return
     */
    int update(RoleEntity role);
    
    /**
     * <p>Description: 删除角色</p>
     * @param role 角色对象
     * @return
     */
    int delete(RoleEntity role);
    
    /**
     * <p>Description: 根据角色id查询角色记录</p>
     * @param role 角色对象
     * @return 角色对象
     */
    RoleEntity queryObjectById(RoleEntity role);
    
    /**
     * <p>Description: 查询角色记录列表</p>
     * @param param 角色对象
     * @return 角色记录列表
     */
    List<RoleEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询角色记录列表</p>
     * @param param 角色对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<RoleEntity> queryListByPage(RoleEntity param, PageInfo pageinfo);
    
    
    /**
     * 功能描述: 初始化角色树<br>
     * 〈功能详细描述〉
     *
     * @param orgId 机构id
     * @return  角色树
     */ 
    List<TreeEntity> initRoleTree(Long orgId);
}
