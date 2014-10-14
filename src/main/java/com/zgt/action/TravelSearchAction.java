package com.zgt.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class TravelSearchAction {
	
    @RequestMapping(method=RequestMethod.GET)  
    public ModelAndView index(HttpServletRequest request){
        String keyWord = (String) request.getParameter("keyWord");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
	
}
 