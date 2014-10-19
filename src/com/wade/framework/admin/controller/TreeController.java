/*
 * Copyright (C), 2013-${year}, 上海汽车集团股份有限公司
 * FileName: ${file_name}
 * Author:   ${user}
 * Date:     ${date} ${time}
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wade.framework.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wade.framework.admin.cache.MenuCache;
import com.wade.framework.admin.service.org.IOrgService;
import com.wade.framework.admin.service.post.IPostService;
import com.wade.framework.admin.service.role.IRoleService;
import com.wade.framework.base.cache.Cache;
import com.wade.framework.base.cache.ICache;
import com.wade.framework.base.controller.BaseController;
import com.wade.framework.base.entity.TreeEntity;

@Controller
@RequestMapping("/common/tree")
public class TreeController extends BaseController {
    
    /**
     * 注入机构service
     */
    @Autowired
    IOrgService orgService;
    
    /**
     * 注入岗位service
     */
    @Autowired
    IPostService postService;
    
    /**
     * 逐入角色service
     */
    @Autowired
    IRoleService roleService;
    
    /**
     * 注入菜单cache
     */
    @Autowired
    ICache menuCache;
    
    /**
     * 功能描述: 机构树<br>
     * 〈功能详细描述〉
     *
     * @param parentId
     * @param response
     */
    @RequestMapping("/org")
    public void orgTree(Long parentId , HttpServletResponse response){
        List<TreeEntity> treeList = orgService.initOrgTree(parentId);
        super.ajaxJsonTree(response, treeList);
    }
    /**
     * 功能描述: 岗位树<br>
     * 〈功能详细描述〉
     *
     * @param orgId
     * @param response
     */
    @RequestMapping("/post")
    public void postTree(@RequestParam("orgId")Long orgId , HttpServletResponse response){
        List<TreeEntity> treeList = postService.initPostTree(orgId);
        super.ajaxJsonTree(response, treeList);
    }
    
    /**
     * 功能描述: 菜单树<br>
     * 〈功能详细描述〉
     *
     * @param parentId
     * @param response
     */
    @RequestMapping("/menu")
    public void menuTree(Long parentId , HttpServletResponse response){
        List<Cache> cacheList = new ArrayList<Cache>();
       
        if(null == parentId){
            cacheList = menuCache.getAllCache();
        } else {
            cacheList = (List<Cache>)menuCache.getCache(MenuCache.SUB_MENU_KEY + parentId);
        }
       
        super.ajaxJsonTree(response, cacheList);
    }
   
    /**
     * 功能描述: 角色树<br>
     * 〈功能详细描述〉
     *
     * @param orgId
     * @param response
     */
    @RequestMapping("/role")
    public void roleTree(@RequestParam("orgId")Long orgId , HttpServletResponse response){
        List<TreeEntity> treeList = roleService.initRoleTree(orgId);
        super.ajaxJsonTree(response, treeList);
    }
}
