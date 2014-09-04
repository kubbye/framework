package com.wade.framework.admin.dao.dict.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.dict.IDictDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: DictDaoImpl</p>
 * <p>Description: 数据字典dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-09-04</p>
 */
@Repository("dictDao")
public class DictDaoImpl extends BaseDaoImpl implements IDictDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
