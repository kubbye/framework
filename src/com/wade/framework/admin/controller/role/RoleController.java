package com.wade.framework.admin.controller.role;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.RoleEntity;
import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.service.role.IRoleService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: RoleController</p>
 * <p>Description: 角色Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-28</p>
 */
@Controller
@RequestMapping("/admin/role")
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
        return "admin/role/roleAdd";
    }
    /**
     * <p>Description: 跳转角色列表页面</p>
     * @param role  角色对象
     * @return
     */
    @RequestMapping("/list")
    public String list(RoleEntity role , Model model){
        model.addAttribute("orgId", role.getOrgId());
        return "admin/role/roleList";
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
    	role.setCreateUser(getSessionUser().getUserId());
        role.setCreateTime(new Date());
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
        return "admin/role/roleEdit";
    }
    
   /**
     * <p>Description: 保存角色修改记录</p>
     * @param role 角色对象
     * @param response
     */
    @RequestMapping("/editRole")
    public void editRole(RoleEntity role, HttpServletResponse response){
    	role.setUpdateUser(getSessionUser().getUserId());
        role.setUpdateTime(new Date());
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
    	role.setUpdateUser(getSessionUser().getUserId());
        role.setUpdateTime(new Date());
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
        return "admin/role/roleDetail";
    }
    
    /**
     * 功能描述: 角色管理树<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/roleTree")
    public String roleTree(){
        return "admin/role/roleTree";
    }
    
    /**
     * 功能描述: <br>
     *    查看角色下的用户
     *
     * @param role
     * @param model
     * @return
     */
    @RequestMapping("/viewAssignUsers")
    public String viewAssignUsers(RoleEntity role, Model model) {
        model.addAttribute("roleId", role.getRoleId());
        model.addAttribute("orgId", role.getOrgId());
        return "admin/role/assignedUsers";
    }
    
    /**
     * 功能描述: <br>
     *     查询用户
     *
     * @param orgId 机构id
     * @param roleId 角色id
     * @param response
     */
    @RequestMapping("/getAssignUsersByRole")
    public void getAssignUsersByRole(Long orgId, Long roleId, HttpServletResponse response){
        List<UserEntity> list = roleService.getAssignUsersByRole(orgId, roleId);
        int size = null == list ? 0 : list.size();
        PageInfo page = new PageInfo();
        page.setPage(1);
        page.setTotal(size);
        page.setRows(size);
        PaginationResult<UserEntity> result = new PaginationResult<UserEntity>(list, page);
        super.ajaxJson(response, result);
    }
    
}
