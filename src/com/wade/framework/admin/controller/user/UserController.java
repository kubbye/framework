package com.wade.framework.admin.controller.user;

import java.util.Date;
import java.util.Random;

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
 * <p>Description: 用户Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
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
    public String list(UserEntity user,Model model){
        model.addAttribute("orgId", user.getOrgId());
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
    	user.setCreateUser(getSessionUser().getUserId());
    	Date date = new Date();
        user.setCreateTime(date);
        //设置默认的loginid
        String loginId=String.valueOf(date.getTime())+new Random().nextInt(9);
        user.setLoginId(loginId);
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
    /**
     * <p>Description: 保存用户修改记录</p>
     * @param user 用户对象
     * @param response
     */
    @RequestMapping("/editUser")
    public void editUser(UserEntity user, HttpServletResponse response){
    	user.setUpdateUser(getSessionUser().getUserId());
        user.setUpdateTime(new Date());
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
    	user.setUpdateUser(getSessionUser().getUserId());
        user.setUpdateTime(new Date());
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
    
    /**
     * <p>Description: 用户树</p>
     * @return
     */
    @RequestMapping("userTree")
    public String tree(){
        return "admin/user/userTree";
    }
}
