package com.zgt.action.api.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zgt.common.MessageDTO;
import com.zgt.model.RolePO;
import com.zgt.service.RoleService;

@Controller
@RequestMapping("/api/role")
public class RoleAction {

    private RoleService roleService;

    public RoleService getRoleService() {
        return roleService;
    }

    @Resource
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * get pagination info
     * 
     * @param pageNum
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> index(@RequestParam("page") Integer pageNum) {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("totalNum", roleService.countRolesTotalNum());
        result.put("roles", roleService.getRoles(pageNum));

        return result;
    }
    

    /**
     * get pagination info
     * 
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> all() {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("totalNum", roleService.countRolesTotalNum());
        result.put("roles", roleService.getRoles(null));

        return result;
    }

    /**
     * create a new role
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public MessageDTO create(RolePO role) {
        
        boolean success = roleService.addRole(role);

        return new MessageDTO(success, null);
    }

    /** delete */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MessageDTO delete(@PathVariable int id) {

        boolean success = roleService.deleteRole(id);

        return new MessageDTO(success, null);
    }

}
