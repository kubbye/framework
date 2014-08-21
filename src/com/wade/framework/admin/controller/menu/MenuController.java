package com.wade.framework.admin.controller.menu;

import java.util.Date;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.MenuEntity;
import com.wade.framework.admin.service.menu.IMenuService;
import com.google.gson.Gson;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: MenuController</p>
 * <p>Description: 菜单Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-08-21</p>
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController extends BaseController {
    /**
     * <p>Field menuService: 菜单Service注入</p>
     */
    @Autowired
    IMenuService menuService;
    
    /**
     * <p>Description: 跳转菜单新增页面</p>
     * @return
     */
    @RequestMapping("/toAddMenu")
    public String toAddMenu(){
        return "admin/menu/menuAdd";
    }
    /**
     * <p>Description: 跳转菜单列表页面</p>
     * @param menu  菜单对象
     * @return
     */
    @RequestMapping("/list")
    public String list(MenuEntity menu){
        return "admin/menu/menuList";
    }
    
    /**
     * <p>Description: 分页查询菜单记录</p>
     * @param menu 菜单对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(MenuEntity menu,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<MenuEntity> result=menuService.queryListByPage(menu, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存菜单记录</p>
     * @param menu 菜单对象
     * @param response
     */
    @RequestMapping("/saveMenu")
    public void saveMenu(MenuEntity menu,HttpServletResponse response){
        log.info("用户"+getSessionUser().getUserName()+"新增了菜单:"+(new Gson()).toJson(menu));
    	menu.setCreateUser(getSessionUser().getUserId());
        menu.setCreateTime(new Date());
        menuService.insert(menu);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转菜单编辑页面</p>
     * @param menu 菜单对象
     * @param model
     * @return
     */
    @RequestMapping("toEditMenu")
    public String toEditMenu(MenuEntity menu, Model model){
        model.addAttribute("id",menu.getId());
        return "admin/menu/menuEdit";
    }
    
   /**
     * <p>Description: 保存菜单修改记录</p>
     * @param menu 菜单对象
     * @param response
     */
    @RequestMapping("/editMenu")
    public void editMenu(MenuEntity menu, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"修改了菜单:"+(new Gson()).toJson(menu));
    	menu.setUpdateUser(getSessionUser().getUserId());
        menu.setUpdateTime(new Date());
        menuService.update(menu);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个菜单记录</p>
     * @param menu 菜单对象
     * @param response
     */
    @RequestMapping("/getMenuById")
    public void getMenuById(MenuEntity menu, HttpServletResponse response){
        super.ajaxJson(response, menuService.queryObjectById(menu));
    }
    /**
     * <p>Description: 删除菜单记录</p>
     * @param menu 菜单对象
     * @param response
     */
    @RequestMapping("deleteMenu")
    public void deleteMenu(MenuEntity menu, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"删除了菜单:"+(new Gson()).toJson(menu));
    	menu.setUpdateUser(getSessionUser().getUserId());
        menu.setUpdateTime(new Date());
        menuService.delete(menu);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看菜单明细</p>
     * @param menu 菜单对象
     * @param model
     * @return
     */
    @RequestMapping("viewMenuDetail")
    public String viewMenuDetail(MenuEntity menu, Model model){
        model.addAttribute("id",menu.getId());
        return "admin/menu/menuDetail";
    }
}
