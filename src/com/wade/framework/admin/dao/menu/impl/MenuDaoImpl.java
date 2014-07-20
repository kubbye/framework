package com.wade.framework.admin.dao.menu.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wade.framework.admin.dao.menu.IMenuDao;
import com.wade.framework.base.dao.BaseDaoImpl;

/**
 * <p>ClassName: MenuDaoImpl</p>
 * <p>Description: 菜单dao实现类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-20</p>
 */
@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl implements IMenuDao {

    /**
     * <p>Field sqlSession: 注入sqlSession</p>
     */
    @Autowired
    private SqlSessionTemplate sqlSession;

}
