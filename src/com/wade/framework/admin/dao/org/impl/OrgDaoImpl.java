package com.wade.framework.admin.dao.org.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.org.IOrgDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: OrgDaoImpl</p>
 * <p>Description: 组织dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-03</p>
 */
@Repository("orgDao")
public class OrgDaoImpl extends BaseDaoImpl implements IOrgDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
