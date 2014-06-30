package com.wade.framework.admin.service.post.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.post.IPostDao;
import com.wade.framework.admin.entity.PostEntity;
import com.wade.framework.admin.service.post.IPostService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("postService")
public class PostServiceImpl implements IPostService {

    @Autowired
    IPostDao postDao;
    
    @Override
    public int insert(PostEntity post) {
    	post.setDeleteMark("0");
        int id=postDao.insert("post.insertPost", post);
        return id;
    }

    @Override
    public int update(PostEntity post) {
        return postDao.update("post.updatePost", post);
    }

    @Override
    public int delete(PostEntity post) {
        return postDao.delete("post.deletePost", post);
    }

    @Override
    public PostEntity queryObjectById(PostEntity post) {
        return postDao.queryObjectById("post.queryPostById", post);
    }

    @Override
    public List<PostEntity> queryList(Object param) {
        return postDao.queryList("post.queryPost", param);
    }

    @Override
    public PaginationResult<PostEntity> queryListByPage(PostEntity param, PageInfo pageinfo) {
       return postDao.queryListByPage("post.queryPostsByPage", param, pageinfo);
    }
    
}
