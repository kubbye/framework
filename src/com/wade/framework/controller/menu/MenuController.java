package com.wade.framework.controller.menu;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.entity.MenuEntity;
import com.wade.framework.service.menu.IMenuService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: MenuController</p>
 * <p>Description: 菜单Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-22</p>
 */
@Controller
@RequestMapping("/menu")
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
        return "menu/menuAdd";
    }
    /**
     * <p>Description: 跳转菜单列表页面</p>
     * @param menu  菜单对象
     * @return
     */
    @RequestMapping("/list")
    public String list(MenuEntity menu){
        return "menu/menuList";
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
        model.addAttribute("menuId",menu.getMenuId());
        return "menu/menuEdit";
    }
    @RequestMapping("/editMenu")
    public void editMenu(MenuEntity menu, HttpServletResponse response){
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
        model.addAttribute("menuId",menu.getMenuId());
        return "menu/menuDetail";
    }
}
