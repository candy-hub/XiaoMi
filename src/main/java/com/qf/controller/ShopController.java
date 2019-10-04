package com.qf.controller;

import com.qf.domain.Shops;
import com.qf.service.ShopKindsService;
import com.qf.service.ShopsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShopController {

    @Resource
    private ShopKindsService shopKindsService;

    @Resource
    private ShopsService shopsService;


    @RequestMapping("findById/{shopId}")
    public Shops findById(@PathVariable int shopId){
        return shopsService.findByShopId(shopId);
    }
}
