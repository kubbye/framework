package com.wade.framework.base.util;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wade.framework.admin.service.syslog.ISyslogService;

/**
 *  系统日志工具<br> 
 * 〈功能详细描述〉
 *
 * @author allways
 */
public class SysLogger {

    private static String[] level = { "TRACE", "DEBUG","WARNING", "INFO", "ERROR", "FATAL" };
    /**
     * 系统日志service
     */
    /*@Autowired
    private ISyslogService syslogService;*/

    /**
     * 写入数据库的日志级别
     */
    private static String logLevel;

    private static Boolean isLogDB;
    
    
    
    Logger logger ;
    
    public SysLogger(Class clazz){
        logger = Logger.getLogger(clazz);
    }

    public void info(String msg) {
        logger.info(msg);
        if (isLogDB) {
            saveLog2DB(msg, null);
        }
    }

    public void info(String msg, Throwable e) {
        logger.info(msg, e);
        if (isLogDB) {
            saveLog2DB(msg, e);
        }
    }

    public void saveLog2DB(String msg, Throwable e) {

    }

    public static String getLogLevel() {
        logLevel = "info";
        return logLevel;
    }

    public static void setLogLevel(String logLevel) {
        SysLogger.logLevel = logLevel;
    }

    public static Boolean getIsLogDB(String msg, Throwable e) {
        return isLogDB;
    }

    public static void setIsLogDB(Boolean isLogDB) {
        SysLogger.isLogDB = isLogDB;
    }

}
