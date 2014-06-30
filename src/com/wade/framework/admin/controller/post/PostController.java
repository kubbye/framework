package com.wade.framework.admin.controller.post;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.admin.entity.PostEntity;
import com.wade.framework.admin.service.post.IPostService;
import com.wade.framework.base.AjaxSuccessInfo;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.controller.BaseController;

/**
 * <p>ClassName: PostController</p>
 * <p>Description: 岗位Controller</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-06-26</p>
 */
@Controller
@RequestMapping("/admin/post")
public class PostController extends BaseController {
    /**
     * <p>Field postService: 岗位Service注入</p>
     */
    @Autowired
    IPostService postService;
    
    /**
     * <p>Description: 跳转岗位新增页面</p>
     * @return
     */
    @RequestMapping("/toAddPost")
    public String toAddPost(){
        return "admin/post/postAdd";
    }
    /**
     * <p>Description: 跳转岗位列表页面</p>
     * @param post  岗位对象
     * @return
     */
    @RequestMapping("/list")
    public String list(PostEntity post){
        return "admin/post/postList";
    }
    
    /**
     * <p>Description: 分页查询岗位记录</p>
     * @param post 岗位对象
     * @param response response
     * @param pageInfo 分页对象
     */
    @RequestMapping("/getListData")
    public void getListData(PostEntity post,HttpServletResponse response,PageInfo pageInfo){
        PaginationResult<PostEntity> result=postService.queryListByPage(post, pageInfo);
        super.ajaxJson(response, result);
    }
    /**
     * <p>Description: 保存岗位记录</p>
     * @param post 岗位对象
     * @param response
     */
    @RequestMapping("/savePost")
    public void savePost(PostEntity post,HttpServletResponse response){
    	post.setCreateUser(getSessionUser().getUserId());
        post.setCreateTime(new Date());
        postService.insert(post);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 跳转岗位编辑页面</p>
     * @param post 岗位对象
     * @param model
     * @return
     */
    @RequestMapping("toEditPost")
    public String toEditPost(PostEntity post, Model model){
        model.addAttribute("id",post.getId());
        return "admin/post/postEdit";
    }
    @RequestMapping("/editPost")
    public void editPost(PostEntity post, HttpServletResponse response){
    	post.setUpdateUser(getSessionUser().getUserId());
        post.setUpdateTime(new Date());
        postService.update(post);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    /**
     * <p>Description: 得到单个岗位记录</p>
     * @param post 岗位对象
     * @param response
     */
    @RequestMapping("/getPostById")
    public void getPostById(PostEntity post, HttpServletResponse response){
        super.ajaxJson(response, postService.queryObjectById(post));
    }
    /**
     * <p>Description: 删除岗位记录</p>
     * @param post 岗位对象
     * @param response
     */
    @RequestMapping("deletePost")
    public void deletePost(PostEntity post, HttpServletResponse response){
    	post.setUpdateUser(getSessionUser().getUserId());
        post.setUpdateTime(new Date());
        postService.delete(post);
        super.ajaxJson(response, AjaxSuccessInfo.success());
    }
    
    /**
     * <p>Description: 查看岗位明细</p>
     * @param post 岗位对象
     * @param model
     * @return
     */
    @RequestMapping("viewPostDetail")
    public String viewPostDetail(PostEntity post, Model model){
        model.addAttribute("id",post.getId());
        return "admin/post/postDetail";
    }
    /**
     * 功能描述: 岗位管理树<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/postTree")
    public String postTree(){
        return "admin/post/postTree";
    }
}
