package com.wade.framework.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wade.framework.base.entity.SessionUserInfo;
import com.wade.framework.base.interceptor.PaginationInterceptor;

public class BaseController {
    private final static Log log = LogFactory.getLog(PaginationInterceptor.class);
    
    /**
     * <p>Description: ajax输出</p>
     * @param response
     * @param content
     * @param type
     */
    public void ajax(HttpServletResponse response,String content,String type){
        try {
            response.setContentType(type+";charset=utf-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            
        }
    }
    /**
     * <p>Description: ajax输出json</p>
     * @param response
     * @param obj
     */
    public void ajaxJson(HttpServletResponse response,Object obj){
        Gson gson = new Gson();
       // String json=gson.toJson(obj,);
        GsonBuilder gb=new GsonBuilder();
        gb.setDateFormat("yyyy-MM-dd");
        String json = gb.create().toJson(obj);
        log.info("json:"+json);
        ajax(response, json, "text/html");
    }
    
    /**
     * <p>Description: 得到当前的session用户对象</p>
     * @return
     */
    public SessionUserInfo getSessionUser(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();  
        SessionUserInfo user = new SessionUserInfo();//(SessionUserInfo)request.getSession().getAttribute("");
        user.setUserId(1L);
        return user;
    }
}
