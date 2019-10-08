package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.ShopKinds;
import com.qf.domain.Shops;
import com.qf.response.AddShops;
import com.qf.response.Response;
import com.qf.service.OrdersService;
import com.qf.service.ShopKindsService;
import com.qf.service.ShopsService;
import com.qf.utils.OrderUtils;
import com.qf.utils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
public class OrderController {

    @Resource
    public OrdersService ordersService;

    @RequestMapping("/userOrder1")
    public Orders submitForm1(@RequestBody Shops shops){
        Orders orders=ordersService.submitForm1(shops);
        return orders;
    }

    @RequestMapping("/findAllOrder")
    public List<Orders> findAllOrder(){
        return ordersService.findAllOrders();
    }

    @RequestMapping("/userOrder2")
    public List<Orders> submitForm2(@RequestBody List<Cart> listCart){
        System.out.println(listCart);
        return ordersService.submitForm2(listCart);
    }
}
