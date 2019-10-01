package com.qf.controller;

import com.qf.service.AdminService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
* 后台商品管理
*/
@RestController
public class AdminShopController {

    @Resource
    private AdminService adminService;



}
