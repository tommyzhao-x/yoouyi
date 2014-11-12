package com.yoouyi.action.api;

import com.yoouyi.common.Constants;
import com.yoouyi.common.MessageDTO;
import com.yoouyi.model.RolePO;
import com.yoouyi.model.UserPO;
import com.yoouyi.model.vo.TravelLineSearchVO;
import com.yoouyi.service.admin.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class RegisterAction {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MessageDTO signUp(@RequestBody UserPO user) {

        RolePO role = new RolePO();
        role.setName(Constants.ROLE_SYSTEM_USER);

        user.setRole(role);
        boolean success = userService.addUser(user);

        return new MessageDTO(success, null);
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> signIn(@RequestBody UserPO user) {

        return null;
    }

}
