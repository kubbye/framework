package com.wade.framework.base.log;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.wade.framework.base.util.Container;

public class JDBCPoolAppender extends JDBCAppender {
    /**
     * 数据库连接池名称
     */
    private String dataSource;
    

    protected String getLogStatement(LoggingEvent event) {
        return getLayout().format(event);
    }


    protected void execute(String sql)
      throws SQLException {
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConnection();

            stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection(con);
        }
    }

    protected void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            this.errorHandler.error("Error closing connection", e, 0);
        }
    }

    protected Connection getConnection() throws SQLException {
        try{
            DataSource ds = (DataSource)Container.getBean(dataSource);
            return ds.getConnection();
        }catch(Exception e){
            e.printStackTrace();
            throw new SQLException(e);
        }
    }

    public void close() {
        flushBuffer();
        this.closed = true;
    }


    public String getDataSource() {
        return dataSource;
    }


    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }



}
