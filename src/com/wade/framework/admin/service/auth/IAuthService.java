package com.wade.framework.admin.service.auth;

import java.util.List;

import com.wade.framework.admin.entity.AuthEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

/**
 * <p>ClassName: IAuthService</p>
 * <p>Description: 授权Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-11</p>
 */
public interface IAuthService {
    /**
     * <p>Description: 插入授权</p>
     * @param auth 授权对象
     * @return
     */
    int insert(AuthEntity auth);
    
    /**
     * <p>Description: 更新授权</p>
     * @param auth 授权对象
     * @return
     */
    int update(AuthEntity auth);
    
    /**
     * <p>Description: 删除授权</p>
     * @param auth 授权对象
     * @return
     */
    int delete(AuthEntity auth);
    
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
     * <p>Description: 分页查询授权记录列表</p>
     * @param param 授权对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<AuthEntity> queryListByPage(AuthEntity param, PageInfo pageinfo);
}
