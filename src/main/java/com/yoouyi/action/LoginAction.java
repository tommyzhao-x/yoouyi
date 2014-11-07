package com.yoouyi.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginAction {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
	
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public ModelAndView signIn(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	

}
