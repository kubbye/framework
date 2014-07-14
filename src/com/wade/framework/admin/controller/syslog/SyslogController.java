package com.wade.framework.admin.controller.syslog;

import java.util.Date;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.controller.user.UserController;
import com.wade.framework.admin.entity.SyslogEntity;
import com.wade.framework.admin.service.syslog.ISyslogService;
import com.google.gson.Gson;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: SyslogController</p>
 * <p>Description: 系统日志Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-07</p>
 */
@Controller
@RequestMapping("/admin/syslog")
public class SyslogController extends BaseController {
    /**
     * <p>Field syslogService: 系统日志Service注入</p>
     */
    @Autowired
    ISyslogService syslogService;
    
    /**
     * 日志对象
     */
    private Logger log=Logger.getLogger(SyslogController.class);
    
    /**
     * <p>Description: 跳转系统日志新增页面</p>
     * @return
     */
    @RequestMapping("/toAddSyslog")
    public String toAddSyslog(){
        return "admin/syslog/syslogAdd";
    }
    /**
     * <p>Description: 跳转系统日志列表页面</p>
     * @param syslog  系统日志对象
     * @return
     */
    @RequestMapping("/list")
    public String list(SyslogEntity syslog){
        return "admin/syslog/syslogList";
    }
    
    /**
     * <p>Description: 分页查询系统日志记录</p>
     * @param syslog 系统日志对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(SyslogEntity syslog,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<SyslogEntity> result=syslogService.queryListByPage(syslog, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存系统日志记录</p>
     * @param syslog 系统日志对象
     * @param response
     */
    @RequestMapping("/saveSyslog")
    public void saveSyslog(SyslogEntity syslog,HttpServletResponse response){
        log.info("用户"+getSessionUser().getUserName()+"新增了系统日志:"+(new Gson()).toJson(syslog));
    	syslog.setCreateUser(getSessionUser().getUserId());
        syslog.setCreateTime(new Date());
        syslogService.insert(syslog);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转系统日志编辑页面</p>
     * @param syslog 系统日志对象
     * @param model
     * @return
     */
    @RequestMapping("toEditSyslog")
    public String toEditSyslog(SyslogEntity syslog, Model model){
        model.addAttribute("id",syslog.getId());
        return "admin/syslog/syslogEdit";
    }
    
   /**
     * <p>Description: 保存系统日志修改记录</p>
     * @param syslog 系统日志对象
     * @param response
     */
    @RequestMapping("/editSyslog")
    public void editSyslog(SyslogEntity syslog, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"修改了系统日志:"+(new Gson()).toJson(syslog));
    	syslog.setUpdateUser(getSessionUser().getUserId());
        syslog.setUpdateTime(new Date());
        syslogService.update(syslog);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个系统日志记录</p>
     * @param syslog 系统日志对象
     * @param response
     */
    @RequestMapping("/getSyslogById")
    public void getSyslogById(SyslogEntity syslog, HttpServletResponse response){
        super.ajaxJson(response, syslogService.queryObjectById(syslog));
    }
    /**
     * <p>Description: 删除系统日志记录</p>
     * @param syslog 系统日志对象
     * @param response
     */
    @RequestMapping("deleteSyslog")
    public void deleteSyslog(SyslogEntity syslog, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"删除了系统日志:"+(new Gson()).toJson(syslog));
    	syslog.setUpdateUser(getSessionUser().getUserId());
        syslog.setUpdateTime(new Date());
        syslogService.delete(syslog);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看系统日志明细</p>
     * @param syslog 系统日志对象
     * @param model
     * @return
     */
    @RequestMapping("viewSyslogDetail")
    public String viewSyslogDetail(SyslogEntity syslog, Model model){
        model.addAttribute("id",syslog.getId());
        return "admin/syslog/syslogDetail";
    }
}
