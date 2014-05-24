package com.wade.framework.admin.service.user;

import java.util.List;

import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.base.PageInfo;

public interface IUserService {
    int insert(UserEntity user);
    int update(UserEntity user);
    int delete(UserEntity user);
    UserEntity queryObjectById(UserEntity user);
    List<UserEntity> queryList(Object param);
    List<UserEntity> queryListByPage(Object param, PageInfo pageinfo);
}
