package com.qf.controller;

import com.qf.domain.Permission;
import com.qf.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PermissionController {

    @Resource
    PermissionService permissionService;

    @RequestMapping("/findAllPermissions")
    public List<Permission> findAllRoles(){
        return permissionService.findAllPermissions();
    }


    @RequestMapping("/addPermission")
    public Permission addPermission(@RequestBody Permission permission){
        return permissionService.addPermission(permission);
    }

    @RequestMapping("/findPermissionById/{pId}")
    public Permission findShopsById(@PathVariable int pId){
        return permissionService.findPermissionById(pId);
    }

    @RequestMapping("/updatePermission")
    public Permission updateShops(@RequestBody Permission permission){
        return permissionService.updatePermission(permission);
    }
}
