package com.wade.framework.base.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.wade.framework.admin.service.syslog.ISyslogService;

/**
 *  系统日志工具<br> 
 * 〈功能详细描述〉
 *
 * @author allways
 */
public class SysLogger {

    
    /**
     * 系统日志service
     */
    @Autowired
    ISyslogService syslogService;
    
    /**
     * 日志级别
     */
    private static String logLevel;

    private static void info(){
        
    }
    public static String getLogLevel() {
        logLevel = "info";
        return logLevel;
    }

    public static void setLogLevel(String logLevel) {
        logLevel = logLevel;
    }
    
}
