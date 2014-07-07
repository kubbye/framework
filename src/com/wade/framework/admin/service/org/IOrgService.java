package com.wade.framework.admin.service.org;

import java.util.List;

import com.wade.framework.admin.entity.OrgEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.TreeEntity;

/**
 * <p>ClassName: IOrgService</p>
 * <p>Description: 机构Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-03</p>
 */
public interface IOrgService {
    /**
     * <p>Description: 插入机构</p>
     * @param org 机构对象
     * @return
     */
    int insert(OrgEntity org);
    
    /**
     * <p>Description: 更新机构</p>
     * @param org 机构对象
     * @return
     */
    int update(OrgEntity org);
    
    /**
     * <p>Description: 删除机构</p>
     * @param org 机构对象
     * @return
     */
    int delete(OrgEntity org);
    
    /**
     * <p>Description: 根据机构id查询机构记录</p>
     * @param org 机构对象
     * @return 机构对象
     */
    OrgEntity queryObjectById(OrgEntity org);
    
    /**
     * <p>Description: 查询机构记录列表</p>
     * @param param 机构对象
     * @return 机构记录列表
     */
    List<OrgEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询机构记录列表</p>
     * @param param 机构对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<OrgEntity> queryListByPage(OrgEntity param, PageInfo pageinfo);
    
    /**
     * 功能描述: <br>
     *    初始化机构树
     *
     * @param parentId
     * @return
     */
    List<TreeEntity> initOrgTree(Long parentId);
    
    /**
     * 功能描述: 机构代码是否存在<br>
     * 〈功能详细描述〉
     *
     * @param code
     * @return true:存在;false:不存在
     */
    Boolean isCodeExists(String code, Long orgId);
}
