package com.qf.controller;

import com.qf.domain.ShopKinds;
import com.qf.domain.Shops;
import com.qf.service.ShopKindsService;
import com.qf.service.ShopsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    //一级菜单
    @RequestMapping("/show1")
    public List<ShopKinds> show1(){
        //System.out.println(shopKindsService.show1());
        return shopKindsService.show1();
    }

    //二级菜单
    @RequestMapping("/show2/{ids}")
    public List<Shops> show2(@PathVariable("ids") Integer skId){
          return shopsService.show2(skId);
    }
}
