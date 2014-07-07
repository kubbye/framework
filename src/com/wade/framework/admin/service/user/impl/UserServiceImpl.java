package com.wade.framework.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.user.IUserDao;
import com.wade.framework.admin.entity.EmplyEntity;
import com.wade.framework.admin.entity.PostEntity;
import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.entity.UserPostEntity;
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
       
        //插入员工
        user.getEmply().setUserId(user.getUserId());
        user.getEmply().setCreateTime(user.getCreateTime());
        user.getEmply().setCreateUser(user.getCreateUser());
        user.getEmply().setSex(user.getSex());
        insertEmply(user.getEmply());
        
        return id;
    }

    private int insertEmply(EmplyEntity emply) {
        emply.setDeleteMark("0");
        int id=userDao.insert("emply.insertEmply", emply);
        return id;
    }
    @Override
    public int update(UserEntity user) {
        user.getEmply().setUpdateTime(user.getUpdateTime());
        user.getEmply().setUpdateUser(user.getUpdateUser());
        user.getEmply().setSex(user.getSex());
        userDao.update("emply.updateEmply", user.getEmply());
        return userDao.update("user.updateUser", user);
    }

    @Override
    public int delete(UserEntity user) {
        return userDao.delete("user.deleteUser", user);
    }

    @Override
    public UserEntity queryObjectById(UserEntity user) {
        UserEntity userEntity = userDao.queryObjectById("user.queryUserById", user.getUserId());
        EmplyEntity emply = userDao.queryObjectById("emply.queryEmplyByUserId", user.getUserId());
        userEntity.setEmply(emply);
        return userEntity;
    }

    @Override
    public List<UserEntity> queryList(Object param) {
        return userDao.queryList("user.queryUser", param);
    }

    @Override
    public PaginationResult<UserEntity> queryListByPage(UserEntity param, PageInfo pageinfo) {
       return userDao.queryListByPage("user.queryUsersByPage", param, pageinfo);
    }

    @Override
    public int saveUserPost(UserPostEntity userPost) {
        userDao.delete("user.deleteUserPost", userPost);
        return userDao.insert("user.saveUserPost", userPost);
    }
    
}
