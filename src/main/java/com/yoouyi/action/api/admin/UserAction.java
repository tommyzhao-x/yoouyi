package com.yoouyi.action.api.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoouyi.common.MessageDTO;
import com.yoouyi.model.UserPO;
import com.yoouyi.service.admin.UserService;

@Controller
@RequestMapping("/admin/api/user")
public class UserAction {
    
    private UserService userService;
    
    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * create a new user
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MessageDTO create(@RequestBody UserPO user) {

        boolean success = userService.addUser(user);

        return new MessageDTO(success, null);
    }
    

    /**
     * get user pagination info
     * 
     * @param pageNum
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> index(@RequestParam("page") Integer pageNum) {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("totalNum", userService.countRolesTotalNum());
        result.put("users", userService.getUsers(pageNum));

        return result;
    }


}
