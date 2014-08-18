package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.service.user.IUserService;
import com.wade.framework.base.util.TestBase;


public class UserTest extends TestBase {
    
    @Autowired
    IUserService userService;
    
    @AfterTest
    public void befortest(){
    }
    @Test
    public void testQueryUsers(){
        Gson gson=new Gson();
        UserEntity entity=new UserEntity();
        entity.setOrgId(3L);
        List<UserEntity> list=userService.queryList(entity);
        String json =gson.toJson(list);
        System.out.println("list===="+json);
    }
}
