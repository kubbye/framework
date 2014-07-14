package com.wade.framework.admin.dao.auth.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.auth.IAuthDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: AuthDaoImpl</p>
 * <p>Description: 授权dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-11</p>
 */
@Repository("authDao")
public class AuthDaoImpl extends BaseDaoImpl implements IAuthDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
