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

import com.wade.framework.admin.service.org.IOrgService;
import com.wade.framework.admin.service.post.IPostService;
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
    @RequestMapping("/post")
    public void postTree(@RequestParam("orgId")Long orgId , HttpServletResponse response){
        List<TreeEntity> treeList = postService.initPostTree(orgId);
        super.ajaxJson(response, treeList);
    }
    @RequestMapping("/menu")
    public void menuTree(@RequestParam("parentId")Long parentId , HttpServletResponse response){
        List<TreeEntity> treeList = new ArrayList<TreeEntity>();
        super.ajaxJson(response, treeList);
    }
}
