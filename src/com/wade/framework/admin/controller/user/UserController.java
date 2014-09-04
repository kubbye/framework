package com.wade.framework.admin.controller.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.wade.framework.admin.entity.OrgEntity;
import com.wade.framework.admin.entity.PostEntity;
import com.wade.framework.admin.entity.UserEntity;
import com.wade.framework.admin.entity.UserPostEntity;
import com.wade.framework.admin.entity.UserRoleEntity;
import com.wade.framework.admin.service.org.IOrgService;
import com.wade.framework.admin.service.post.IPostService;
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
     * 注入岗位service
     */
    @Autowired 
    IPostService postService;
    
    /**
     * 逐入机构service
     */
    @Autowired
    IOrgService orgService;
    /**
     * 日志对象
     */
    private Logger log=Logger.getLogger(UserController.class);
    
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
        log.info("用户"+getSessionUser().getUserName()+"新增了用户:"+(new Gson()).toJson(user));
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
        log.info("用户"+getSessionUser().getUserName()+"修改了用户:"+(new Gson()).toJson(user));
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
        UserEntity userEntity = userService.queryObjectById(user.getUserId());
        if(null != userEntity && null != userEntity.getOrgId()){
            OrgEntity org= orgService.queryObjectById(userEntity.getOrgId());
            userEntity.setOrg(org);
        }
        super.ajaxJson(response, userEntity);
    }
    /**
     * <p>Description: 删除用户记录</p>
     * @param user 用户对象
     * @param response
     */
    @RequestMapping("deleteUser")
    public void deleteUser(UserEntity user, HttpServletResponse response){
        log.info("用户"+getSessionUser().getUserName()+"删除了用户:"+(new Gson()).toJson(user));
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
    
    /**
     * 功能描述: 岗位选择<br>
     * 〈功能详细描述〉
     *
     * @return
     */
    @RequestMapping("/postSelect")
    public String postSelect(UserEntity user, Model model) {
        model.addAttribute("userId", user.getUserId());
        List<PostEntity> list = postService.getPostsByUserId(user.getUserId());
        if (null != list && !list.isEmpty()) {
            model.addAttribute("post", list.get(0));
        } else {
            model.addAttribute("post", null);
        }
        return "admin/user/postSelect";
    }
    
    /**
     * 功能描述: 查询用户的岗位<br>
     * 〈功能详细描述〉
     *
     * @param user
     * @param response
     */
    @RequestMapping("/getUserPost")
    public void getUserPost(UserEntity user, HttpServletResponse response){
        List<PostEntity> list = postService.getPostsByUserId(user.getUserId());
        PostEntity post = null;
        if (null != list && !list.isEmpty()) {
            post = list.get(0);
        } 
        super.ajaxJson(response, post);
    }
    /**
     * 功能描述: 保存用户岗位关系信息<br>
     * 〈功能详细描述〉
     *
     * @param userPost
     * @param response
     */
    @RequestMapping("/saveUserPostRel")
    public void saveUserPost(UserPostEntity userPost, HttpServletResponse response) {
        log.info("用户" + getSessionUser().getUserName() + "修改了用户岗位:" + (new Gson()).toJson(userPost));
        userService.saveUserPost(userPost);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * 功能描述: 角色选择<br>
     * 〈功能详细描述〉
     *
     * @param user 用户对象
     * @param model model
     * @return 
     */
    @RequestMapping("/roleSelect")
    public String roleSelect(UserEntity user, Model model) {
        model.addAttribute("userId", user.getUserId());
        model.addAttribute("orgId", user.getOrgId());
        model.addAttribute("hasSelectList", userService.getRoleListByUserId(user.getUserId()));
        return "admin/user/roleSelect";
    }
    
    /**
     * 功能描述: 保存用户角色关系<br>
     * 〈功能详细描述〉
     *
     * @param roleids 角色列表
     * @param response
     */
    @RequestMapping("/saveUserRole")
    public void saveUserRole(String roleids, Long userId, HttpServletResponse response) {
        log.info("用户" + getSessionUser().getUserName() + "修改了用户:id=" + userId + "的角色为:"
                + Arrays.asList(roleids).toString());
        String[] roleidArr = roleids.split(",");
        List<UserRoleEntity> list = new ArrayList<UserRoleEntity>();
        for (String roleid : roleidArr) {
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRoleId(Long.valueOf(roleid));
            userRole.setUserId(userId);
            list.add(userRole);
        }
        userService.saveUserRole(list, userId);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * 功能描述: 调整机构<br>
     * 〈功能详细描述〉
     *
     * @return
     */
    @RequestMapping("/orgExchange")
    public String orgExchange(UserEntity user,Model model){
        model.addAttribute("userId", user.getUserId());
        model.addAttribute("orgId", user.getOrgId());
        return "admin/user/orgSelect";
    }
    
    /**
     * 功能描述: 保存新的机构<br>
     * 〈功能详细描述〉
     *
     * @param user
     * @param response
     */
    @RequestMapping("/saveNewOrg")
    public void saveNewOrg(UserEntity user, HttpServletResponse response){
        user.setUpdateUser(getSessionUser().getUserId());
        user.setUpdateTime(new Date());
        userService.updateOrg(user);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
}
