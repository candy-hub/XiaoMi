package com.qf.controller;

import com.qf.domain.Permission;
import com.qf.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    @RequiresPermissions(value = {"addPermission"})
    @RequestMapping("/addPermission")
    public String addPermission(@RequestBody Permission permission){
        return permissionService.addPermission(permission);
    }

    @RequestMapping("/findPermissionById/{pid}")
    public Permission findShopsById(@PathVariable("pid") Integer pid){
         return permissionService.findPermissionById(pid);
    }
    @RequiresPermissions(value = {"updatePermission"})
    @RequestMapping("/updatePermission")
    public String updateShops(@RequestBody Permission permission){
        return permissionService.updatePermission(permission);
    }

    @RequiresPermissions(value = {"deletePermission"})
    @RequestMapping("/deletePermission/{pid}")
    public String delete(@PathVariable("pid") Integer id){
       return permissionService.delete(id);
    }
}
