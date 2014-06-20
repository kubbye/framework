package com.wade.framework.base.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.BaseEntity;

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
    public <T> PaginationResult<T> queryListByPage(String sqlId, BaseEntity param, PageInfo pageinfo) {
        param.setPageInfo(pageinfo);
        List<T> list = sqlSession.selectList(sqlId, param);
        
        Long cnt = Long.valueOf(getSqlCount(sqlId,param));
        PageInfo pi = new PageInfo();
       
        pi.setTotal(cnt);
        pi.setRows(pageinfo.getRows());
        pi.setPage(pageinfo.getPage());
        PaginationResult<T> result = new PaginationResult<T>(list,pi);
        return result;
    }

    /**
     * <p>Description: 查询记录总数</p>
     * @param sqlId  mybatis的sqlId
     * @param param 参数
     * @return 记录总数
     */
    private int getSqlCount(String sqlId, BaseEntity param) {
        int totalCount = 0;  
        Connection connection = null;
        PreparedStatement countStmt = null;  
        ResultSet rs = null;  
        try {
            MappedStatement mappedStatement = sqlSession.getConfiguration().getMappedStatement(sqlId);
            BoundSql boundSql=mappedStatement.getBoundSql(param);
            connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
            String countSql = "select count(0) from (" + boundSql.getSql() + ") tmp";  

            countStmt = connection.prepareStatement(countSql);  
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,  
                    boundSql.getParameterMappings(), boundSql.getParameterObject());  
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());  
            rs = countStmt.executeQuery();  
            
            if (rs.next()) {  
                totalCount = rs.getInt(1);  
            }  

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                countStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalCount;
    }
    /**
     * <p>Description: 对PreparedStatement设置参数</p>
     * @param ps PreparedStatement
     * @param mappedStatement mappedStatement
     * @param boundSql boundSql
     * @param parameterObject parameterObject
     * @throws SQLException 异常
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,  
            Object parameterObject) throws SQLException {  
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
        parameterHandler.setParameters(ps);  
    }  
    @Override
    public <T> PaginationResult<T> queryListByPage(String sqlId, String countId, BaseEntity param, PageInfo pageinfo) {
        param.setPageInfo(pageinfo);
        List<T> list = sqlSession.selectList(sqlId, param);
        Long cnt = sqlSession.selectOne(countId, param);
        PageInfo pi = new PageInfo();
        pi.setTotal(cnt);
        pi.setRows(pageinfo.getRows());
        pi.setPage(pageinfo.getPage());
        PaginationResult<T> result = new PaginationResult<T>(list,pi);
        return result;
    }
    
    @Override
    public <T> T queryObjectById(String sqlId, Object param) {
        return sqlSession.selectOne(sqlId, param);
    }

    
    
    
}
