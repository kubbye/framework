package com.wade.framework.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.user.IUserDao;
import com.wade.framework.admin.entity.EmplyEntity;
import com.wade.framework.admin.entity.RoleEntity;
import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.entity.UserPostEntity;
import com.wade.framework.admin.entity.UserRoleEntity;
import com.wade.framework.admin.service.user.IUserService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.cache.Cache;
import com.wade.framework.base.cache.ICache;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;
    
    @Autowired
    ICache userCache;
    
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
        
        userCache.addCache(new Cache(user.getUserId(), user));
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
        
        userCache.refreshCache(new Cache(user.getUserId(), user));
        return userDao.update("user.updateUser", user);
    }

    @Override
    public int delete(UserEntity user) {
        int res = userDao.delete("user.deleteUser", user);
        userCache.removeCache(user.getUserId());
        return res;
    }

    @Override
    public UserEntity queryObjectById(Long userId) {
        UserEntity userEntity = (UserEntity)userCache.getCache(userId).getValue();
        if(null == userEntity){
            userEntity = userDao.queryObjectById("user.queryUserById", userId);
        }
        EmplyEntity emply = userDao.queryObjectById("emply.queryEmplyByUserId", userId);
        userEntity.setEmply(emply);
        return userEntity;
    }

    @Override
    public List<UserEntity> queryList(Object param) {
        return userDao.queryList("user.queryUsers", param);
    }
    
    
    @Override
    public List<UserEntity> queryAllUsers() {
        return userDao.queryList("user.queryAllUsers", null);
    }

    @Override
    public PaginationResult<UserEntity> queryListByPage(UserEntity param, PageInfo pageinfo) {
       return userDao.queryListByPage("user.queryUsersByPage", param, pageinfo);
    }

    @Override
    public int saveUserPost(UserPostEntity userPost) {
        userDao.delete("user.deleteUserPost", userPost.getUserId());
        return userDao.insert("user.saveUserPost", userPost);
    }

    @Override
    public void saveUserRole(List<UserRoleEntity> list, Long userId) {
        userDao.delete("user.deleteUserRole", userId);
        for(UserRoleEntity userRole : list){
            userDao.insert("user.saveUserRole", userRole);
        }
    }

    @Override
    public List<RoleEntity> getRoleListByUserId(Long userId) {
        return userDao.queryList("role.queryRoleByUserId", userId);
    }

    @Override
    public int updateOrg(UserEntity user) {
        userDao.delete("user.deleteUserRole", user.getUserId());
        userDao.delete("user.deleteUserPost", user.getUserId());
        return userDao.update("user.updateOrg", user);
    }
}
