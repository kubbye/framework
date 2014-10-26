package com.wade.framework.admin.service.post.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.post.IPostDao;
import com.wade.framework.admin.entity.PostEntity;
import com.wade.framework.admin.service.auth.IAuthService;
import com.wade.framework.admin.service.post.IPostService;
import com.wade.framework.base.Constants;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.TreeEntity;

@Service("postService")
public class PostServiceImpl implements IPostService {

    @Autowired
    IPostDao postDao;
    
    @Autowired
    IAuthService authService;
    
    @Override
    public int insert(PostEntity post) {
    	post.setDeleteMark("0");
        int id=postDao.insert("post.insertPost", post);
        // 计算机构路径并插入数据库
        String path = calcPath(post);
        post.setPostPath(path);
        postDao.update("post.updatePostPath", post);
        
        return id;
    }

    @Override
    public int update(PostEntity post) {
        return postDao.update("post.updatePost", post);
    }

    @Override
    public int delete(PostEntity post) {
        //删除岗位下绑定的用户
        postDao.delete("post.deleteUserPostByPost", post.getId());
        //删除岗位绑定的权限
        //authService.deleteAuth(Constants.AUTHORITY_POST, post.getId());
        return postDao.delete("post.deletePost", post);
    }

    @Override
    public PostEntity queryObjectById(Long postId) {
        return postDao.queryObjectById("post.queryPostById", postId);
    }

    @Override
    public List<PostEntity> queryList(Object param) {
        return postDao.queryList("post.queryPost", param);
    }

    @Override
    public PaginationResult<PostEntity> queryListByPage(PostEntity param, PageInfo pageinfo) {
       return postDao.queryListByPage("post.queryPostsByPage", param, pageinfo);
    }

    @Override
    public List<TreeEntity> initPostTree(Long orgId) {
        PostEntity entity = new PostEntity();
        if(null != orgId){
            entity.setOrgId(orgId);
        }
        return postDao.queryList("post.queryPostTree", entity);
    }

    @Override
    public List<PostEntity> getPostsByUserId(Long userId) {
        return postDao.queryList("post.queryPostsByUserId", userId);
    }
    
    /**
     * 功能描述: 计算岗位路径<br>
     *  
     *
     * @param org
     * @return
     */
    private String calcPath(PostEntity post) {
        String path = "";
        if (Constants.POST_ROOT.equals(post.getParentId())) {
            path = post.getId() + Constants.PATH_SEPRATOR;
        } else {
            PostEntity parent = queryObjectById(post.getParentId());
            if (parent.getPostPath().endsWith(Constants.PATH_SEPRATOR)) {
                path = parent.getPostPath() + post.getId();
            } else {
                path = parent.getPostPath() + Constants.PATH_SEPRATOR + post.getId();
            }
        }
        return path;
    }
    
}
