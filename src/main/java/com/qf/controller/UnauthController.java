package com.qf.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnauthController {



    @RequiresPermissions(value = {"updatePermission","addPermission",
            "addRole","updateRole","addAdmin","updateAdmin","addShops","updateShops"})
    @RequestMapping(value = "/unauth",method = RequestMethod.GET)
    public String unauth(){
        return "1";
    }
}
