/**
 * Container.java
 * Created at 2013-08-14
 * Created by hanwei
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package com.wade.framework.base.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>ClassName: Container</p>
 * <p>Description: spring容器</p>
 * <p>Author: hanwei</p>
 * <p>Date: 2013-7-15</p>
 */
public class Container implements ApplicationContextAware {
   
    static ApplicationContext context;
    /**
     * 功能描述: <br>
     *    得到bean对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }

    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        context = arg0;
    }
    
    
}
