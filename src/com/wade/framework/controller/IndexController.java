package com.wade.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wade.framework.admin.dao.user.IUserDao;
import com.wade.framework.base.controller.BaseController;

@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {
    
	@RequestMapping("/index")
	public String index(Model model){
		return "main";
	}
	
	@RequestMapping("/go")
	public ModelAndView go(){
		return new ModelAndView("index");
	}

}
