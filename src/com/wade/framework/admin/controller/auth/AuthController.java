package com.wade.framework.admin.controller.auth;

import java.util.Date;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.AuthEntity;
import com.wade.framework.admin.service.auth.IAuthService;
import com.google.gson.Gson;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: AuthController</p>
 * <p>Description: 授权Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-11</p>
 */
@Controller
@RequestMapping("/admin/auth")
public class AuthController extends BaseController {
    /**
     * <p>Field authService: 授权Service注入</p>
     */
    @Autowired
    IAuthService authService;
    
    
    /**
     * <p>Description: 跳转授权新增页面</p>
     * @return
     */
    @RequestMapping("/toAddAuth")
    public String toAddAuth(){
        return "admin/auth/authAdd";
    }
    /**
     * <p>Description: 跳转授权列表页面</p>
     * @param auth  授权对象
     * @return
     */
    @RequestMapping("/list")
    public String list(AuthEntity auth){
        return "admin/auth/authList";
    }
    
    /**
     * <p>Description: 分页查询授权记录</p>
     * @param auth 授权对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(AuthEntity auth,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<AuthEntity> result=authService.queryListByPage(auth, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存授权记录</p>
     * @param auth 授权对象
     * @param response
     */
    @RequestMapping("/saveAuth")
    public void saveAuth(AuthEntity auth,HttpServletResponse response){
        log.info("用户"+getSessionUser().getUserName()+"新增了授权:"+(new Gson()).toJson(auth));
    	auth.setCreateUser(getSessionUser().getUserId());
        auth.setCreateTime(new Date());
        authService.insert(auth);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转授权编辑页面</p>
     * @param auth 授权对象
     * @param model
     * @return
     */
    @RequestMapping("toEditAuth")
    public String toEditAuth(AuthEntity auth, Model model){
        model.addAttribute("id",auth.getId());
        return "admin/auth/authEdit";
    }
    
   /**
     * <p>Description: 保存授权修改记录</p>
     * @param auth 授权对象
     * @param response
     */
    @RequestMapping("/editAuth")
    public void editAuth(AuthEntity auth, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"修改了授权:"+(new Gson()).toJson(auth));
    	auth.setUpdateUser(getSessionUser().getUserId());
        auth.setUpdateTime(new Date());
        authService.update(auth);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个授权记录</p>
     * @param auth 授权对象
     * @param response
     */
    @RequestMapping("/getAuthById")
    public void getAuthById(AuthEntity auth, HttpServletResponse response){
        super.ajaxJson(response, authService.queryObjectById(auth));
    }
    /**
     * <p>Description: 删除授权记录</p>
     * @param auth 授权对象
     * @param response
     */
    @RequestMapping("deleteAuth")
    public void deleteAuth(AuthEntity auth, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"删除了授权:"+(new Gson()).toJson(auth));
    	auth.setUpdateUser(getSessionUser().getUserId());
        auth.setUpdateTime(new Date());
        authService.delete(auth);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看授权明细</p>
     * @param auth 授权对象
     * @param model
     * @return
     */
    @RequestMapping("viewAuthDetail")
    public String viewAuthDetail(AuthEntity auth, Model model){
        model.addAttribute("id",auth.getId());
        return "admin/auth/authDetail";
    }
}
