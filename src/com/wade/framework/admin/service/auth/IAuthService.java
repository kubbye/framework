package com.wade.framework.admin.service.auth;

import java.util.List;

import com.wade.framework.admin.entity.AuthEntity;

/**
 * <p>ClassName: IAuthService</p>
 * <p>Description: 授权Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-11</p>
 */
public interface IAuthService {
    /**
     * <p>Description: 插入岗位授权</p>
     * @param auth 授权对象
     * @return
     */
    int insertPostAuth(List<AuthEntity> auth, Long postId, Long userId);
    
    /**
     * <p>Description: 插入角色授权</p>
     * @param auth 授权对象
     * @return
     */
    int insertRoleAuth(List<AuthEntity> auth, Long roleId, Long userId);
    
    /**
     * <p>Description: 根据授权id查询授权记录</p>
     * @param auth 授权对象
     * @return 授权对象
     */
    AuthEntity queryObjectById(Long id);
    
    /**
     * <p>Description: 查询授权记录列表</p>
     * @param param 授权对象
     * @return 授权记录列表
     */
    List<AuthEntity> queryList(Object param);
    
    /**
     * 功能描述: <br>
     *    删除授权
     *
     * @param type
     * @param authId
     */
    void deleteAuth(Integer type, Long authId);
}
