package com.wade.framework.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class BaseController {
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
        ajax(response, gson.toJson(obj), "text/html");
    }
}
