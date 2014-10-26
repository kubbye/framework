package com.wade.framework.admin.service.auth.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.auth.IAuthDao;
import com.wade.framework.admin.entity.AuthEntity;
import com.wade.framework.admin.service.auth.IAuthService;
import com.wade.framework.base.Constants;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

    @Autowired
    IAuthDao authDao;
    
    @Override
    public int insertPostAuth(List<AuthEntity> authList, Long postId, Long userId) {
        deleteAuth(Constants.AUTHORITY_POST, postId);
        
        //插入新的授权
        for(AuthEntity auth : authList){
            auth.setDeleteMark("0");
            auth.setAuthType(Constants.AUTHORITY_POST);
            auth.setAuthId(postId);
            auth.setCreateTime(new Date());
            auth.setCreateUser(userId);
            authDao.insert("auth.insertAuth", auth);
        }
        return 1;
    }

    @Override
    public int insertRoleAuth(List<AuthEntity> authList, Long roleId, Long userId) {
        AuthEntity param = new AuthEntity();
        param.setAuthType(Constants.AUTHORITY_ROLE);
        param.setAuthId(roleId);
        //删除已有的授权
        authDao.delete("auth.deleteAuths", param);
        
        //插入新的授权
        for(AuthEntity auth : authList){
            auth.setDeleteMark("0");
            auth.setAuthType(Constants.AUTHORITY_ROLE);
            auth.setAuthId(roleId);
            auth.setCreateTime(new Date());
            auth.setCreateUser(userId);
            authDao.insert("auth.insertAuth", auth);
        }
        return 1;
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
    public void deleteAuth(Integer type, Long authId) {
        AuthEntity param = new AuthEntity();
        param.setAuthType(type);
        param.setAuthId(authId);
        //删除已有的授权
        authDao.delete("auth.deleteAuths", param);
        
    }
    
    
}
