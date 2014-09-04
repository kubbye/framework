package com.wade.framework.admin.controller.dict;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.DictEntity;
import com.wade.framework.admin.service.dict.IDictService;
import com.google.gson.Gson;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: DictController</p>
 * <p>Description: 数据字典Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-09-04</p>
 */
@Controller
@RequestMapping("/admin/dict")
public class DictController extends BaseController {

	/**
     * log
     */
    private final Log log = LogFactory.getLog(DictController.class);
    
    /**
     * <p>Field dictService: 数据字典Service注入</p>
     */
    @Autowired
    IDictService dictService;
    
    /**
     * <p>Description: 跳转数据字典新增页面</p>
     * @return
     */
    @RequestMapping("/toAddDict")
    public String toAddDict(){
        return "admin/dict/dictAdd";
    }
    /**
     * <p>Description: 跳转数据字典列表页面</p>
     * @param dict  数据字典对象
     * @return
     */
    @RequestMapping("/list")
    public String list(DictEntity dict){
        return "admin/dict/dictList";
    }
    
    /**
     * <p>Description: 分页查询数据字典记录</p>
     * @param dict 数据字典对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(DictEntity dict,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<DictEntity> result=dictService.queryListByPage(dict, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存数据字典记录</p>
     * @param dict 数据字典对象
     * @param response
     */
    @RequestMapping("/saveDict")
    public void saveDict(DictEntity dict,HttpServletResponse response){
        log.info("用户"+getSessionUser().getUserName()+"新增了数据字典:"+(new Gson()).toJson(dict));
    	dict.setCreateUser(getSessionUser().getUserId());
        dict.setCreateTime(new Date());
        dictService.insert(dict);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转数据字典编辑页面</p>
     * @param dict 数据字典对象
     * @param model
     * @return
     */
    @RequestMapping("toEditDict")
    public String toEditDict(DictEntity dict, Model model){
        model.addAttribute("id",dict.getId());
        return "admin/dict/dictEdit";
    }
    
   /**
     * <p>Description: 保存数据字典修改记录</p>
     * @param dict 数据字典对象
     * @param response
     */
    @RequestMapping("/editDict")
    public void editDict(DictEntity dict, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"修改了数据字典:"+(new Gson()).toJson(dict));
    	dict.setUpdateUser(getSessionUser().getUserId());
        dict.setUpdateTime(new Date());
        dictService.update(dict);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个数据字典记录</p>
     * @param dict 数据字典对象
     * @param response
     */
    @RequestMapping("/getDictById")
    public void getDictById(DictEntity dict, HttpServletResponse response){
        super.ajaxJson(response, dictService.queryObjectById(dict.getId()));
    }
    /**
     * <p>Description: 删除数据字典记录</p>
     * @param dict 数据字典对象
     * @param response
     */
    @RequestMapping("deleteDict")
    public void deleteDict(DictEntity dict, HttpServletResponse response){
    	log.info("用户"+getSessionUser().getUserName()+"删除了数据字典:"+(new Gson()).toJson(dict));
    	dict.setUpdateUser(getSessionUser().getUserId());
        dict.setUpdateTime(new Date());
        dictService.delete(dict);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看数据字典明细</p>
     * @param dict 数据字典对象
     * @param model
     * @return
     */
    @RequestMapping("viewDictDetail")
    public String viewDictDetail(DictEntity dict, Model model){
        model.addAttribute("id",dict.getId());
        return "admin/dict/dictDetail";
    }
}
