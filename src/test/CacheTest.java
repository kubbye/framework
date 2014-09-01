package test;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wade.framework.admin.cache.UserCache;
import com.wade.framework.base.cache.Cache;
import com.wade.framework.base.util.TestBase;

public class CacheTest extends TestBase {
    
    @Autowired
    UserCache userCache;
   
 
   
    public void testUserCache(){
        userCache.initCache();
        //Assert.assertEquals("i am a user", userCache.getCache("user1").getValue());
//        System.out.println(userCache.getCache("user1").getValue());
        //userCache.refreshKey(new Cache("user1","i am not a user"));
//        System.out.println(userCache.getCache("user1").getValue());
        //Assert.assertEquals("i am not a user", userCache.getCache("user1").getValue());
        
        Assert.assertEquals(userCache.size(),3);
        
        List<Cache> list=userCache.getAllCache();
        Assert.assertEquals(list.size(),3);
    }
    
    @Test
    public void testLog(){
        Log log = LogFactory.getLog(CacheTest.class);
        log.error("error");
        log.info("info");
    }
}
