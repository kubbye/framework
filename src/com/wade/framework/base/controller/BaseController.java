package com.wade.framework.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.wade.framework.base.interceptor.PaginationInterceptor;

public class BaseController {
    private final static Log log = LogFactory.getLog(PaginationInterceptor.class);
    
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
    public void ajaxJson(HttpServletResponse response,Object obj){
        Gson gson = new Gson();
        String json=gson.toJson(obj);
        log.info("json:"+json);
        ajax(response, json, "text/html");
    }
}
