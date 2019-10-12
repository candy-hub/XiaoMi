package com.qf.controller;


import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;
import com.qf.response.AddCart;
import com.qf.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    public OrdersService ordersService;

    @RequestMapping(value = "/userOrder1/{uid}",method = RequestMethod.POST)
    public Orders submitForm1(@RequestBody AddCart addCart, @PathVariable int uid){
        Orders orders=ordersService.submitForm1(addCart,uid);
        return orders;
    }

    @RequestMapping(value = "/findAllOrder/{uid}",method = RequestMethod.GET)
    public List<Orders> findAllOrder(@PathVariable int uid){
        return ordersService.findAllOrders(uid);
    }

    @RequestMapping(value = "/userOrder2/{uid}",method = RequestMethod.POST)
    public List<Orders> submitForm2(@RequestBody List<Cart> listCart, @PathVariable int uid){
        return ordersService.submitForm2(listCart,uid);
    }

    @RequestMapping(value = "/findNotPayOrders/{uid}",method = RequestMethod.GET)
    public List<Orders> findNotPayOrders(@PathVariable int uid){
        return ordersService.findPayOrders(0,uid);
    }

    @RequestMapping(value = "/findAlreadyPayOrders/{uid}",method = RequestMethod.GET)
    public List<Orders>findAlreadyPayOrders(@PathVariable int uid){
        return ordersService.findPayOrders(1,uid);
    }

    @RequestMapping("/deleteOrders/{oId}")
    public String deleteOrders(@PathVariable int oId){
        ordersService.deleteById(oId);
        return "1";
    }
}
