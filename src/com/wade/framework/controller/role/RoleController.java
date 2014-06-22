package com.wade.framework.controller.role;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.entity.RoleEntity;
import com.wade.framework.service.role.IRoleService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: RoleController</p>
 * <p>Description: 角色Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-22</p>
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
    /**
     * <p>Field roleService: 角色Service注入</p>
     */
    @Autowired
    IRoleService roleService;
    
    /**
     * <p>Description: 跳转角色新增页面</p>
     * @return
     */
    @RequestMapping("/toAddRole")
    public String toAddRole(){
        return "role/roleAdd";
    }
    /**
     * <p>Description: 跳转角色列表页面</p>
     * @param role  角色对象
     * @return
     */
    @RequestMapping("/list")
    public String list(RoleEntity role){
        return "role/roleList";
    }
    
    /**
     * <p>Description: 分页查询角色记录</p>
     * @param role 角色对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(RoleEntity role,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<RoleEntity> result=roleService.queryListByPage(role, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存角色记录</p>
     * @param role 角色对象
     * @param response
     */
    @RequestMapping("/saveRole")
    public void saveRole(RoleEntity role,HttpServletResponse response){
        roleService.insert(role);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转角色编辑页面</p>
     * @param role 角色对象
     * @param model
     * @return
     */
    @RequestMapping("toEditRole")
    public String toEditRole(RoleEntity role, Model model){
        model.addAttribute("roleId",role.getRoleId());
        return "role/roleEdit";
    }
    @RequestMapping("/editRole")
    public void editRole(RoleEntity role, HttpServletResponse response){
        roleService.update(role);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个角色记录</p>
     * @param role 角色对象
     * @param response
     */
    @RequestMapping("/getRoleById")
    public void getRoleById(RoleEntity role, HttpServletResponse response){
        super.ajaxJson(response, roleService.queryObjectById(role));
    }
    /**
     * <p>Description: 删除角色记录</p>
     * @param role 角色对象
     * @param response
     */
    @RequestMapping("deleteRole")
    public void deleteRole(RoleEntity role, HttpServletResponse response){
        roleService.delete(role);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看角色明细</p>
     * @param role 角色对象
     * @param model
     * @return
     */
    @RequestMapping("viewRoleDetail")
    public String viewRoleDetail(RoleEntity role, Model model){
        model.addAttribute("roleId",role.getRoleId());
        return "role/roleDetail";
    }
}
