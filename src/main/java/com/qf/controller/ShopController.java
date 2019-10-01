package com.qf.controller;

import com.qf.service.ShopKindsService;
import com.qf.service.ShopsService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShopController {

    @Resource
    private ShopKindsService shopKindsService;

    @Resource
    private ShopsService shopsService;
}
