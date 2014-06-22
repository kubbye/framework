package com.wade.framework.service.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.dao.role.IRoleDao;
import com.wade.framework.entity.RoleEntity;
import com.wade.framework.service.role.IRoleService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao roleDao;
    
    @Override
    public int insert(RoleEntity role) {
        int id=roleDao.insert("role.insertRole", role);
        return id;
    }

    @Override
    public int update(RoleEntity role) {
        return roleDao.update("role.updateRole", role);
    }

    @Override
    public int delete(RoleEntity role) {
        return roleDao.delete("role.deleteRole", role);
    }

    @Override
    public RoleEntity queryObjectById(RoleEntity role) {
        return roleDao.queryObjectById("role.queryRoleById", role);
    }

    @Override
    public List<RoleEntity> queryList(Object param) {
        return roleDao.queryList("role.queryRole", param);
    }

    @Override
    public PaginationResult<RoleEntity> queryListByPage(RoleEntity param, PageInfo pageinfo) {
       return roleDao.queryListByPage("role.queryRolesByPage", param, pageinfo);
    }
    
}
