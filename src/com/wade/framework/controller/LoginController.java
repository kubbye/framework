/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LoginController.java
 * Author:   weih
 * Date:     2014年10月31日 下午3:53:20
 * Descript
 * ion: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wade.framework.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wade.framework.base.controller.BaseController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author weih
 */
@Controller
public class LoginController extends BaseController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/index")
    public String toIndex(String username, String pwd){
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
        SecurityUtils.getSubject().login(token);
        boolean isAdmin = true;
        String indexPage= "/index.htm";
        if(isAdmin){
            indexPage = "redirect:/admin/index.htm";
        }
        return indexPage;
    }
}
