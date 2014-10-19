package com.wade.framework.admin.controller.func;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.FuncEntity;
import com.wade.framework.admin.service.func.IFuncService;
import com.google.gson.Gson;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: FuncController</p>
 * <p>Description: 菜单功能Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-10-19</p>
 */
@Controller
@RequestMapping("/admin/func")
public class FuncController extends BaseController {

	/**
     * log
     */
    private final Log log = LogFactory.getLog(FuncController.class);
    
    /**
     * <p>Field funcService: 菜单功能Service注入</p>
     */
    @Autowired
    IFuncService funcService;
    
    /**
     * <p>Description: 跳转菜单功能新增页面</p>
     * @return
     */
    @RequestMapping("/toAddFunc")
    public String toAddFunc(){
        return "admin/func/funcAdd";
    }
    /**
     * <p>Description: 跳转菜单功能列表页面</p>
     * @param func  菜单功能对象
     * @return
     */
    @RequestMapping("/list")
    public String list(FuncEntity func){
        return "admin/func/funcList";
    }
    
    /**
     * <p>Description: 分页查询菜单功能记录</p>
     * @param func 菜单功能对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(FuncEntity func,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<FuncEntity> result=funcService.queryListByPage(func, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存菜单功能记录</p>
     * @param func 菜单功能对象
     * @param response
     */
    @RequestMapping("/saveFunc")
    public void saveFunc(FuncEntity func,HttpServletResponse response){
        log.info("用户"+getSessionUser().getUserName()+"新增了菜单功能:"+(new Gson()).toJson(func));
    	func.setCreateUser(getSessionUser().getUserId());
        func.setCreateTime(new Date());
        funcService.insert(func);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转菜单功能编辑页面</p>
     * @param func 菜单功能对象
     * @param model
     * @return
     */
    @RequestMapping("toEditFunc")
    public String toEditFunc(FuncEntity func, Model model){
        model.addAttribute("id",func.getId());
        return "admin/func/funcEdit";
    }
    
   /**
     * <p>Description: 保存菜单功能修改记录</p>
     * @param func 菜单功能对象
     * @param response
     */
    @RequestMapping("/editFunc")
    public void editFunc(FuncEntity func, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"修改了菜单功能:"+(new Gson()).toJson(func));
    	func.setUpdateUser(getSessionUser().getUserId());
        func.setUpdateTime(new Date());
        funcService.update(func);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个菜单功能记录</p>
     * @param func 菜单功能对象
     * @param response
     */
    @RequestMapping("/getFuncById")
    public void getFuncById(FuncEntity func, HttpServletResponse response){
        super.ajaxJson(response, funcService.queryObjectById(func.getId()));
    }
    /**
     * <p>Description: 删除菜单功能记录</p>
     * @param func 菜单功能对象
     * @param response
     */
    @RequestMapping("deleteFunc")
    public void deleteFunc(FuncEntity func, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"删除了菜单功能:"+(new Gson()).toJson(func));
    	func.setUpdateUser(getSessionUser().getUserId());
        func.setUpdateTime(new Date());
        funcService.delete(func);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看菜单功能明细</p>
     * @param func 菜单功能对象
     * @param model
     * @return
     */
    @RequestMapping("viewFuncDetail")
    public String viewFuncDetail(FuncEntity func, Model model){
        model.addAttribute("id",func.getId());
        return "admin/func/funcDetail";
    }
}
