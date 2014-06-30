package com.wade.framework.admin.dao.post.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.post.IPostDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: PostDaoImpl</p>
 * <p>Description: 岗位dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
 */
@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl implements IPostDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
