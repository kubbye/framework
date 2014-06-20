package com.wade.framework.admin.controller.user;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.service.user.IUserService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: UserController</p>
 * <p>Description: 用户controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-6-16</p>
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {
    /**
     * <p>Field userService: 用户Service注入</p>
     */
    @Autowired
    IUserService userService;
    
    /**
     * <p>Description: 跳转用户新增页面</p>
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "admin/user/userAdd";
    }
    /**
     * <p>Description: 跳转用户列表页面</p>
     * @param user  用户对象
     * @return
     */
    @RequestMapping("/list")
    public String list(UserEntity user){
        return "admin/user/userList";
    }
    
    /**
     * <p>Description: 分页查询用户记录</p>
     * @param user 用户对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(UserEntity user,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<UserEntity> result=userService.queryListByPage(user, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存用户记录</p>
     * @param user 用户对象
     * @param response
     */
    @RequestMapping("/saveUser")
    public void saveUser(UserEntity user,HttpServletResponse response){
        userService.insert(user);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转用户编辑页面</p>
     * @param user 用户对象
     * @param model
     * @return
     */
    @RequestMapping("toEditUser")
    public String toEditUser(UserEntity user, Model model){
        model.addAttribute("userId",user.getUserId());
        return "admin/user/userEdit";
    }
    @RequestMapping("/editUser")
    public void editUser(UserEntity user, HttpServletResponse response){
        userService.update(user);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个用户记录</p>
     * @param user 用户对象
     * @param response
     */
    @RequestMapping("/getUserById")
    public void getUserById(UserEntity user, HttpServletResponse response){
        super.ajaxJson(response, userService.queryObjectById(user));
    }
    /**
     * <p>Description: 删除用户记录</p>
     * @param user 用户对象
     * @param response
     */
    @RequestMapping("deleteUser")
    public void deleteUser(UserEntity user, HttpServletResponse response){
        userService.delete(user);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看用户明细</p>
     * @param user 用户对象
     * @param model
     * @return
     */
    @RequestMapping("viewUserDetail")
    public String viewUserDetail(UserEntity user, Model model){
        model.addAttribute("userId",user.getUserId());
        return "admin/user/userDetail";
    }
}
