package com.wade.framework.admin.service.post;

import java.util.List;

import com.wade.framework.admin.entity.PostEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.TreeEntity;

/**
 * <p>ClassName: IPostService</p>
 * <p>Description: 岗位Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
 */
public interface IPostService {
    /**
     * <p>Description: 插入岗位</p>
     * @param post 岗位对象
     * @return
     */
    int insert(PostEntity post);
    
    /**
     * <p>Description: 更新岗位</p>
     * @param post 岗位对象
     * @return
     */
    int update(PostEntity post);
    
    /**
     * <p>Description: 删除岗位</p>
     * @param post 岗位对象
     * @return
     */
    int delete(PostEntity post);
    
    /**
     * <p>Description: 根据岗位id查询岗位记录</p>
     * @param post 岗位对象
     * @return 岗位对象
     */
    PostEntity queryObjectById(Long postId);
    
    /**
     * <p>Description: 查询岗位记录列表</p>
     * @param param 岗位对象
     * @return 岗位记录列表
     */
    List<PostEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询岗位记录列表</p>
     * @param param 岗位对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<PostEntity> queryListByPage(PostEntity param, PageInfo pageinfo);
    
    /**
     * 功能描述: 初始化岗位树<br>
     * 〈功能详细描述〉
     *
     * @param orgId 机构id
     * @return  岗位树
     */
    List<TreeEntity> initPostTree(Long orgId);
    
    /**
     * 功能描述: 根据用户id查询用户的岗位<br>
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     */
    List<PostEntity> getPostsByUserId(Long userId);
}
