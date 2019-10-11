package com.qf.controller;


import com.qf.domain.Role;
import com.qf.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {

    @Resource
    RoleService roleService;

    @RequestMapping(value = "/findAllRoles",method = RequestMethod.GET)
    public List<Role> findAllRoles(){
        return roleService.findAllRoles();
    }

    @RequiresPermissions(value = {"addRole"})
    @RequestMapping(value = "/insertRole",method = RequestMethod.POST)
    public String insert(@RequestBody Role role){
     return roleService.insert(role);
    }

    @RequestMapping(value = "/selectRoleById/{ids}",method = RequestMethod.GET)
    public Role selectById(@PathVariable("ids") Integer id){
        return roleService.selectById(id);
    }

    @RequiresPermissions(value = {"updateRole"})
    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    public String update(@RequestBody Role role){
        return roleService.update(role);
    }

    @RequiresPermissions(value = {"delRole"})
    @RequestMapping(value = "/deleteRole/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable ("id") Integer id){
        return roleService.delete(id);
    }

}
