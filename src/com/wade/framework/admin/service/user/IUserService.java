package com.wade.framework.admin.service.user;

import java.util.List;

import com.wade.framework.admin.entity.RoleEntity;
import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.entity.UserPostEntity;
import com.wade.framework.admin.entity.UserRoleEntity;
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
    UserEntity queryObjectById(Long userId);
    
    /**
     * <p>Description: 查询用户记录列表</p>
     * @param param 用户对象
     * @return 用户记录列表
     */
    List<UserEntity> queryList(Object param);
    
    /**
     * 功能描述: <br>
     *     查询所有的用户
     *
     * @return
     */
    List<UserEntity> queryAllUsers();
    /**
     * <p>Description: 分页查询用户记录列表</p>
     * @param param 用户对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<UserEntity> queryListByPage(UserEntity param, PageInfo pageinfo);
    
    /**
     * 功能描述: 保存用户岗位信息<br>
     * 〈功能详细描述〉
     *
     * @param userPost
     * @return
     */
    int saveUserPost(UserPostEntity userPost);
    
    /**
     * 功能描述: 保存用户角色<br>
     * 〈功能详细描述〉
     *
     * @param list 用户角色列表
     * @param userId 用户id
     */
    void saveUserRole(List<UserRoleEntity> list,Long userId);
    
    /**
     * 功能描述: 得到用户的角色信息<br>
     * 〈功能详细描述〉
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<RoleEntity> getRoleListByUserId(Long userId);
    
    /**
     * 功能描述: 更改用户的机构<br>
     *    1.删除用户的角色
     *    2.删除用户的岗位
     *    3.更新机构
     *
     * @param user 用户对象
     * @return 
     */
    int updateOrg(UserEntity user);
}
