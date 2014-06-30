package com.wade.framework.admin.dao.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.user.IUserDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: UserDaoImpl</p>
 * <p>Description: 用户dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
