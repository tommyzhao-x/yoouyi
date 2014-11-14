package com.yoouyi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yoouyi.common.ExceptionMessage;
import com.yoouyi.common.MessageDTO;
import com.yoouyi.service.admin.UserService;

@Controller
@RequestMapping("/login")
public class LoginAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    @ResponseBody
    public MessageDTO success(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object userDetail = authentication.getPrincipal();
        User user = null;
        
        if (userDetail instanceof UserDetails) {
            user = (User) userDetail;
        }

        MessageDTO message = new MessageDTO();

        if (user != null) {
            userService.updateUserLoginIp(user.getUsername(), request.getRemoteAddr());
            message.setSuccess(true);
            message.setData(user);
        }

        return message;
    }
    
    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    @ResponseBody
    public MessageDTO failed(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        Object error = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        MessageDTO message = new MessageDTO();
        message.setSuccess(false);
        
        if (error instanceof UsernameNotFoundException) {
            message.setData(ExceptionMessage.USER_NAME_NOT_FOUND);
        } else if (error instanceof BadCredentialsException) {
            message.setData(ExceptionMessage.PASSWORD_INVALID);
        } else if (error instanceof DisabledException) {
            message.setData(ExceptionMessage.ACCOUND_DISABLED);
        }
         

        return message;
    }
    
    @RequestMapping(value = "/checkSession", method = RequestMethod.GET)
    @ResponseBody
    public MessageDTO checkSession(HttpServletRequest request) {
        
        return success(request);
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public MessageDTO signOut(HttpServletRequest request) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object userDetail = authentication.getPrincipal();
        MessageDTO message = new MessageDTO();
        
        // if user logout successful the userDetail is 'anonymousUser'
        if (userDetail instanceof String) {
            message.setSuccess(true);
            message.setData(userDetail);
        }

        return message;
    }

}
