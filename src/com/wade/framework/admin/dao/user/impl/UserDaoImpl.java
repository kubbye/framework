package com.wade.framework.admin.dao.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.user.IUserDao;
import com.wade.framework.base.dao.BaseDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

    @Autowired
    private SqlSessionTemplate sqlSession;
    
    @Override
    public int queryCount() {
        Integer cnt = sqlSession.selectOne("user.countAll");
        return cnt;
    }

}
