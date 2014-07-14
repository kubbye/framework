package com.wade.framework.admin.service.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.role.IRoleDao;
import com.wade.framework.admin.entity.AuthEntity;
import com.wade.framework.admin.entity.RoleEntity;
import com.wade.framework.admin.service.auth.IAuthService;
import com.wade.framework.admin.service.role.IRoleService;
import com.wade.framework.base.Constants;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.TreeEntity;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    /**
     * 注入dao
     */
    @Autowired
    IRoleDao roleDao;
    
    /**
     * 注入授权service
     */
    @Autowired
    IAuthService authService;
    
    @Override
    public int insert(RoleEntity role) {
    	role.setDeleteMark("0");
        int id=roleDao.insert("role.insertRole", role);
        return id;
    }

    @Override
    public int update(RoleEntity role) {
        return roleDao.update("role.updateRole", role);
    }

    @Override
    public int delete(RoleEntity role) {
        //删除角色绑定的用户
        roleDao.delete("role.deleteUserRoleByRole", role.getRoleId());
        //删除角色绑定的权限
        AuthEntity auth = new AuthEntity();
        auth.setAuthType(Constants.AUTHORITY_ROLE);
        auth.setAuthId(role.getRoleId());
        authService.delete(auth);
        //删除角色
        return roleDao.delete("role.deleteRole", role);
    }

    @Override
    public RoleEntity queryObjectById(RoleEntity role) {
        return roleDao.queryObjectById("role.queryRoleById", role.getRoleId());
    }

    @Override
    public List<RoleEntity> queryList(Object param) {
        return roleDao.queryList("role.queryRole", param);
    }

    @Override
    public PaginationResult<RoleEntity> queryListByPage(RoleEntity param, PageInfo pageinfo) {
       return roleDao.queryListByPage("role.queryRolesByPage", param, pageinfo);
    }

    @Override
    public List<TreeEntity> initRoleTree(Long orgId) {
        return roleDao.queryList("role.queryPostTree", orgId);
    }
    
}
