package com.wade.framework.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.user.IUserDao;
import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.service.user.IUserService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;
    
    @Override
    public int insert(UserEntity user) {
    	user.setDeleteMark("0");
        int id=userDao.insert("user.insertUser", user);
        return id;
    }

    @Override
    public int update(UserEntity user) {
        return userDao.update("user.updateUser", user);
    }

    @Override
    public int delete(UserEntity user) {
        return userDao.delete("user.deleteUser", user);
    }

    @Override
    public UserEntity queryObjectById(UserEntity user) {
        return userDao.queryObjectById("user.queryUserById", user);
    }

    @Override
    public List<UserEntity> queryList(Object param) {
        return userDao.queryList("user.queryUser", param);
    }

    @Override
    public PaginationResult<UserEntity> queryListByPage(UserEntity param, PageInfo pageinfo) {
       return userDao.queryListByPage("user.queryUsersByPage", param, pageinfo);
    }
    
}
