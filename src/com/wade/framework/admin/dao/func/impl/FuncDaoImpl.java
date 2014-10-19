package com.wade.framework.admin.dao.func.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.func.IFuncDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: FuncDaoImpl</p>
 * <p>Description: 菜单功能dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-10-19</p>
 */
@Repository("funcDao")
public class FuncDaoImpl extends BaseDaoImpl implements IFuncDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
