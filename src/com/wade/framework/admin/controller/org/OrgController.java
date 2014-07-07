package com.wade.framework.admin.controller.org;

import java.util.Date;
import java.util.WeakHashMap;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.OrgEntity;
import com.wade.framework.admin.service.org.IOrgService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: OrgController</p>
 * <p>Description: 机构Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-03</p>
 */
@Controller
@RequestMapping("/admin/org")
public class OrgController extends BaseController {
    /**
     * <p>Field orgService: 机构Service注入</p>
     */
    @Autowired
    IOrgService orgService;
    
    /**
     * <p>Description: 跳转机构新增页面</p>
     * @return
     */
    @RequestMapping("/toAddOrg")
    public String toAddOrg(){
        return "admin/org/orgAdd";
    }
    /**
     * <p>Description: 跳转机构列表页面</p>
     * @param org  机构对象
     * @return
     */
    @RequestMapping("/list")
    public String list(OrgEntity org, Model model){
        model.addAttribute("parentId", org.getParentId());
        return "admin/org/orgList";
    }
    
    /**
     * <p>Description: 分页查询机构记录</p>
     * @param org 机构对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(OrgEntity org,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<OrgEntity> result=orgService.queryListByPage(org, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存机构记录</p>
     * @param org 机构对象
     * @param response
     */
    @RequestMapping("/saveOrg")
    public void saveOrg(OrgEntity org,HttpServletResponse response){
    	org.setCreateUser(getSessionUser().getUserId());
        org.setCreateTime(new Date());
        orgService.insert(org);
        WeakHashMap<String, Object> map = new WeakHashMap<String, Object>();
        map.put(AjaxSuccessInfo.MESSAGE_KEY, AjaxSuccessInfo.success().getMessage());
        map.put("org", org);
        super.ajaxJson(response, map);
    }
    /**
     * <p>Description: 跳转机构编辑页面</p>
     * @param org 机构对象
     * @param model
     * @return
     */
    @RequestMapping("toEditOrg")
    public String toEditOrg(OrgEntity org, Model model){
        model.addAttribute("orgId",org.getOrgId());
        return "admin/org/orgEdit";
    }
    
   /**
     * <p>Description: 保存机构修改记录</p>
     * @param org 机构对象
     * @param response
     */
    @RequestMapping("/editOrg")
    public void editOrg(OrgEntity org, HttpServletResponse response){
    	org.setUpdateUser(getSessionUser().getUserId());
        org.setUpdateTime(new Date());
        orgService.update(org);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个机构记录</p>
     * @param org 机构对象
     * @param response
     */
    @RequestMapping("/getOrgById")
    public void getOrgById(OrgEntity org, HttpServletResponse response){
        super.ajaxJson(response, orgService.queryObjectById(org));
    }
    /**
     * <p>Description: 删除机构记录</p>
     * @param org 机构对象
     * @param response
     */
    @RequestMapping("deleteOrg")
    public void deleteOrg(OrgEntity org, HttpServletResponse response){
    	org.setUpdateUser(getSessionUser().getUserId());
        org.setUpdateTime(new Date());
        orgService.delete(org);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看机构明细</p>
     * @param org 机构对象
     * @param model
     * @return
     */
    @RequestMapping("viewOrgDetail")
    public String viewOrgDetail(OrgEntity org, Model model){
        model.addAttribute("orgId",org.getOrgId());
        return "admin/org/orgDetail";
    }
    
    /**
     * 功能描述: 机构树<br>
     * 〈功能详细描述〉
     *
     * @return
     */
    @RequestMapping("/orgTree")
    public String orgTree(){
        return "admin/org/orgTree";
    }
    
    /**
     * 功能描述: 判断机构代码是否已存在<br>
     * 〈功能详细描述〉
     *
     * @param code
     * @param response
     */
    @RequestMapping("/isCodeExists")
    public void isCodeExists(String orgCode,Long orgId, HttpServletResponse response){
        super.ajaxMessage(response, String.valueOf(!orgService.isCodeExists(orgCode,orgId)));
    }
}
