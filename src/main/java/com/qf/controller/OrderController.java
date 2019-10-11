package com.qf.controller;


import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;
import com.qf.response.AddCart;
import com.qf.service.OrdersService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    public OrdersService ordersService;

    @RequestMapping("/userOrder1/{uid}")
    public Orders submitForm1(@RequestBody AddCart addCart, @PathVariable int uid){
        Orders orders=ordersService.submitForm1(addCart,uid);
        return orders;
    }

    @RequestMapping("/findAllOrder/{uid}")
    public List<Orders> findAllOrder(@PathVariable int uid){
        return ordersService.findAllOrders(uid);
    }

    @RequestMapping("/userOrder2/{uid}")
    public List<Orders> submitForm2(@RequestBody List<Cart> listCart, @PathVariable int uid){
        return ordersService.submitForm2(listCart,uid);
    }

    @RequestMapping("/findNotPayOrders/{uid}")
    public List<Orders> findNotPayOrders(@PathVariable int uid){
        return ordersService.findPayOrders(0,uid);
    }

    @RequestMapping("/findAlreadyPayOrders/{uid}")
    public List<Orders>findAlreadyPayOrders(@PathVariable int uid){
        return ordersService.findPayOrders(1,uid);
    }

    @RequestMapping("/deleteOrders/{oId}")
    public String deleteOrders(@PathVariable int oId){
        ordersService.deleteById(oId);
        return "删除成功";
    }
}
