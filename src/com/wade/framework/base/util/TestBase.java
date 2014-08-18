package com.wade.framework.base.util;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 *  testng测试基类<br> 
 * 〈功能详细描述〉
 *
 * @author weih
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:conf/spring/applicationContext.xml"
})
public class TestBase extends AbstractTestNGSpringContextTests {

}
