package com.qf.controller;


import com.qf.domain.Role;
import com.qf.service.RoleService;
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
}
