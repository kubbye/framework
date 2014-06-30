package com.wade.framework.admin.service.user;

import java.util.List;

import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

/**
 * <p>ClassName: IUserService</p>
 * <p>Description: 用户Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
 */
public interface IUserService {
    /**
     * <p>Description: 插入用户</p>
     * @param user 用户对象
     * @return
     */
    int insert(UserEntity user);
    
    /**
     * <p>Description: 更新用户</p>
     * @param user 用户对象
     * @return
     */
    int update(UserEntity user);
    
    /**
     * <p>Description: 删除用户</p>
     * @param user 用户对象
     * @return
     */
    int delete(UserEntity user);
    
    /**
     * <p>Description: 根据用户id查询用户记录</p>
     * @param user 用户对象
     * @return 用户对象
     */
    UserEntity queryObjectById(UserEntity user);
    
    /**
     * <p>Description: 查询用户记录列表</p>
     * @param param 用户对象
     * @return 用户记录列表
     */
    List<UserEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询用户记录列表</p>
     * @param param 用户对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<UserEntity> queryListByPage(UserEntity param, PageInfo pageinfo);
}
