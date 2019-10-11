package com.qf.controller;


import com.qf.domain.Role;
import com.qf.service.RoleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {

    @Resource
    RoleService roleService;

    @RequestMapping("/findAllRoles")
    public List<Role> findAllRoles(){
        return roleService.findAllRoles();
    }

    @RequestMapping("/insertRole")
    public String insert(@RequestBody Role role){
     return roleService.insert(role);
    }

    @RequestMapping("/selectRoleById/{ids}")
    public Role selectById(@PathVariable("ids") Integer id){
        return roleService.selectById(id);
    }
    @RequestMapping("/updateRole")
    public String update(@RequestBody Role role){
        return roleService.update(role);
    }


    @RequestMapping("/deleteRole/{id}")
    public String delete(@PathVariable ("id") Integer id){
        return roleService.delete(id);
    }

}
