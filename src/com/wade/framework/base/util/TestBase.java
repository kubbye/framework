package com.wade.framework.base.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

/**
 *  testng测试基类<br> 
 * 〈功能详细描述〉
 *
 * @author weih
 */
@ContextConfiguration(locations={
        "classpath:conf/spring/applicationContext.xml",
        "classpath:conf/spring/applicationContext-cache.xml"
})
public class TestBase extends AbstractTestNGSpringContextTests {
    
    @BeforeSuite
    public void beforeTest(){
        Container c = new Container();
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring/applicationContext.xml");
        c.setApplicationContext(context);
    }
}
