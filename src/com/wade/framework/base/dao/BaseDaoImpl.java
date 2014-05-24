package com.wade.framework.base.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.wade.framework.base.PageInfo;

public class BaseDaoImpl implements IBaseDao {

    @Autowired
    SqlSessionTemplate sqlSession;
    
    @Override
    public int insert(String sqlId, Object param) {
        return sqlSession.insert(sqlId, param);
    }

    @Override
    public int update(String sqlId, Object param) {
        return sqlSession.update(sqlId, param);
    }

    @Override
    public int delete(String sqlId, Object param) {
        return sqlSession.delete(sqlId, param);
    }

    @Override
    public <T> List<T> queryList(String sqlId, Object param) {
        return sqlSession.selectList(sqlId, param);
    }

    @Override
    public <T> List<T> queryListByPage(String sqlId, Object param, PageInfo pageinfo) {
        return sqlSession.selectList(sqlId, param);
    }

    @Override
    public <T> T queryObjectById(String sqlId, Object param) {
        return sqlSession.selectOne(sqlId, param);
    }

    
    
    
}
