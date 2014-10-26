package com.wade.framework.admin.controller.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.AuthEntity;
import com.wade.framework.admin.service.auth.IAuthService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.Constants;
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
    @RequestMapping("/toPostAuth")
    public String toPostAuth(String postId, Model model){
        model.addAttribute("postId",postId);
        return "admin/post/menuAssign";
    }
 
    /**
     * <p>Description: 保存授权记录</p>
     * @param auth 授权对象
     * @param response
     */
    @RequestMapping("/savePostAuth")
    public void savePostAuth(String postId, String menuIds, String funcIds, HttpServletResponse response) {
        // log.info("用户"+getSessionUser().getUserName()+"修改了授权:"+(new Gson()).toJson(auth));
        List<AuthEntity> authList = generateAuthList(Constants.AUTHORITY_POST, menuIds, funcIds);

        authService.insertPostAuth(authList, Long.valueOf(postId), getSessionUser().getUserId());
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * 功能描述: <br>
     *    生成资源授权列表
     *
     * @param type  授权类型
     * @param menuIds  菜单列表
     * @param funcIds  按钮功能列表
     * @return
     */
    private List<AuthEntity> generateAuthList(Integer type, String menuIds, String funcIds) {
        List<AuthEntity> authList = new ArrayList<AuthEntity>();
        AuthEntity auth = null;
        for (String mid : menuIds.split(",")) {
            if (StringUtils.isEmpty(mid)) {
                continue;
            }
            auth = new AuthEntity();
            auth.setAuthType(type);
            auth.setRestype(Constants.RESOURCE_TYPE_MENU);
            auth.setResourceId(Long.valueOf(mid));
            authList.add(auth);
        }
        for (String fid : funcIds.split(",")) {
            if (StringUtils.isEmpty(fid)) {
                continue;
            }
            auth = new AuthEntity();
            auth.setAuthType(type);
            auth.setRestype(Constants.RESOURCE_TYPE_FUNCTION);
            auth.setResourceId(Long.valueOf(fid));
            authList.add(auth);
        }
        return authList;
    }
  
    /**
     * <p>Description: 得到单个授权记录</p>
     * @param auth 授权对象
     * @param response
     */
    @RequestMapping("/getAuthById")
    public void getAuthById(AuthEntity auth, HttpServletResponse response){
        super.ajaxJson(response, authService.queryObjectById(auth.getId()));
    }
    
    /**
     * 功能描述: <br>
     *    查询岗位的授权列表
     *
     * @param postId
     * @param response
     */
    @RequestMapping("/getPostAuthList")
    public void queryPostAuthList(Long postId, HttpServletResponse response){
        AuthEntity param = new AuthEntity();
        param.setAuthId(postId);
        param.setAuthType(Constants.AUTHORITY_POST);
        super.ajaxJsonTree(response, authService.queryList(param));
    }
    
    /**
     * 功能描述: <br>
     *     查询资源的授权列表
     *
     * @param roleId
     * @param response
     */
    @RequestMapping("/queryRoleAuthList")
    public void queryRoleAuthList(Long roleId, HttpServletResponse response){
        AuthEntity param = new AuthEntity();
        param.setAuthId(roleId);
        param.setAuthType(Constants.AUTHORITY_ROLE);
        super.ajaxJsonTree(response, authService.queryList(param));
    }
    
}
