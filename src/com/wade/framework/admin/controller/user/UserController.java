package com.wade.framework.admin.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.service.user.IUserService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.controller.BaseController;

@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {
    @Autowired
    IUserService userService;
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "admin/user/userEdit";
    }
    @RequestMapping("/list")
    public String list(UserEntity user){
        return "admin/user/userList";
    }
    
    @RequestMapping("/getListData")
    public void getListData(UserEntity user,HttpServletResponse response){
        PageInfo pageinfo = new PageInfo();
        List<UserEntity> list=userService.queryListByPage(user, pageinfo);
        super.ajaxJson(response, list);
    }
    @RequestMapping("/saveUser")
    public void saveUser(UserEntity user,HttpServletResponse response){
        userService.insert(user);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    @RequestMapping("toEditUser")
    public String toEditUser(UserEntity user, Model model){
        model.addAttribute("user",userService.queryObjectById(user));
        return "admin/user/userEdit";
    }
    @RequestMapping("/editUser")
    public void editUser(UserEntity user, HttpServletResponse response){
        userService.update(user);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    @RequestMapping("deleteUser")
    public void deleteUser(UserEntity user, HttpServletResponse response){
        userService.delete(user);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    @RequestMapping("viewUserDetail")
    public void viewUserDetail(UserEntity user, HttpServletResponse response){
        UserEntity userEntity = userService.queryObjectById(user);
        super.ajaxJson(response, userEntity);
    }
}
