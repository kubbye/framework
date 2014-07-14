package com.wade.framework.admin.service.auth.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.auth.IAuthDao;
import com.wade.framework.admin.entity.AuthEntity;
import com.wade.framework.admin.service.auth.IAuthService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

    @Autowired
    IAuthDao authDao;
    
    @Override
    public int insert(AuthEntity auth) {
    	auth.setDeleteMark("0");
        int id=authDao.insert("auth.insertAuth", auth);
        return id;
    }

    @Override
    public int update(AuthEntity auth) {
        return authDao.update("auth.updateAuth", auth);
    }

    @Override
    public int delete(AuthEntity auth) {
        return authDao.delete("auth.deleteAuth", auth);
    }

    @Override
    public AuthEntity queryObjectById(Long id) {
        return authDao.queryObjectById("auth.queryAuthById", id);
    }

    @Override
    public List<AuthEntity> queryList(Object param) {
        return authDao.queryList("auth.queryAuth", param);
    }

    @Override
    public PaginationResult<AuthEntity> queryListByPage(AuthEntity param, PageInfo pageinfo) {
       return authDao.queryListByPage("auth.queryAuthsByPage", param, pageinfo);
    }
    
}
