package com.wade.framework.base.excption;

/**
 * <p>ClassName: BaseException</p>
 * <p>Description: 异常基类</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-5-20</p>
 */
public class BaseException extends RuntimeException {
    /**
     * <p>Field code: 异常代码</p>
     */
    private String code;
    
    /**
     * <p>Field message: 异常信息</p>
     */
    private String message;
    
    
    /**
     * 默认构造函数
     * @param code 异常代码
     * @param message 异常信息
     */
    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
}
