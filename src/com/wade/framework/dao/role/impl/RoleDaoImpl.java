package com.wade.framework.dao.role.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.dao.role.IRoleDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: RoleDaoImpl</p>
 * <p>Description: 角色dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-22</p>
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl implements IRoleDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
