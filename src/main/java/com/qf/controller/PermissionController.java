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

    @RequestMapping(value = "/findAllPermissions",method = RequestMethod.GET)
    public List<Permission> findAllRoles(){
        return permissionService.findAllPermissions();
    }

    @RequiresPermissions(value = {"addPermission"})
    @RequestMapping(value = "/addPermission",method = RequestMethod.POST)
    public String addPermission(@RequestBody Permission permission){
        return permissionService.addPermission(permission);
    }

    @RequestMapping(value ="/findPermissionById/{pid}",method = RequestMethod.POST)
    public Permission findShopsById(@PathVariable("pid") Integer pid){
         return permissionService.findPermissionById(pid);
    }
    @RequiresPermissions(value = {"updatePermission"})
    @RequestMapping(value ="/updatePermission",method = RequestMethod.POST)
    public String updateShops(@RequestBody Permission permission){
        return permissionService.updatePermission(permission);
    }

    @RequiresPermissions(value = {"deletePermission"})
    @RequestMapping(value = "/deletePermission/{pid}",method = RequestMethod.POST)
    public String delete(@PathVariable("pid") Integer id){
       return permissionService.delete(id);
    }
}
