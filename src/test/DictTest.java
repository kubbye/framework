package test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.wade.framework.admin.entity.DictEntity;
import com.wade.framework.admin.service.dict.IDictService;
import com.wade.framework.base.util.TestBase;

public class DictTest extends TestBase {
    @Autowired
    IDictService dictService;
    
    @Test
    public void testInsert(){
        DictEntity entity = new DictEntity();
        entity.setTypeCode("0001");
        entity.setTypeName("测试类");
        entity.setCode("0002");
        entity.setDisplayname("测试子类2");
        entity.setSortId(1);
        entity.setCreateTime(new Date());
        entity.setCreateUser(1L);
        entity.setDeleteMark("0");
        entity.setEditable(1);
        dictService.insert(entity);
    }
    
    @Test
    public void testUpdate(){
        DictEntity entity = dictService.queryObjectById(2L);
        entity.setUpdateTime(new Date());
        entity.setUpdateUser(1L);
        entity.setSortId(2);
        dictService.update(entity);
    }
}
