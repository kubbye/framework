package com.wade.framework.base.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import com.wade.framework.base.PageInfo;
import com.wade.framework.base.entity.BaseEntity;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PaginationInterceptor implements Interceptor {

    private final static Log log = LogFactory.getLog(PaginationInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,new DefaultObjectFactory(), new DefaultObjectWrapperFactory());
        RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
      /*  if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
            return invocation.proceed();
        }*/

        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
        String databaseType = null;
        try {
            databaseType = configuration.getVariables().getProperty("dialect").toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (databaseType == null) {
            throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : "
                    + configuration.getVariables().getProperty("dialect"));
        }

        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");  
        String originalSql = boundSql.getSql();
        MappedStatement mappedStatement = (MappedStatement)   
                metaStatementHandler.getValue("delegate.mappedStatement"); 
        //只有以”ByPage“结尾的sqlId才进行分页
        if (mappedStatement.getId().endsWith("ByPage")) {  
            Object parameterObject = boundSql.getParameterObject();  
            if(parameterObject instanceof BaseEntity){
                PageInfo pageinfo=((BaseEntity)parameterObject).getPageInfo();
                metaStatementHandler.setValue("delegate.boundSql.sql",
                        getLimitString(originalSql, (pageinfo.getPage()-1)*pageinfo.getRows(), pageinfo.getRows()));
            }else{
                throw new RuntimeException("parameter is not instance of BaseEntity");
            }
           
        }
        metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
        metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

        if (log.isDebugEnabled()) {
            log.debug("生成分页SQL : " + boundSql.getSql());
        }
        return invocation.proceed();
    }
    private String getLimitString(String originalSql, int offset, int limit){
        return originalSql + " limit "+offset+", "+limit;
    }
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
