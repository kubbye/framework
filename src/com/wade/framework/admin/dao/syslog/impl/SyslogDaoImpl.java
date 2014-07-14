package com.wade.framework.admin.dao.syslog.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.syslog.ISyslogDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: SyslogDaoImpl</p>
 * <p>Description: 系统日志dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-07</p>
 */
@Repository("syslogDao")
public class SyslogDaoImpl extends BaseDaoImpl implements ISyslogDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
