package com.qf.controller;


import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;
import com.qf.service.OrdersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("/findNotPayOrders")
    public List<Orders> findNotPayOrders(){
        return ordersService.findPayOrders(0);
    }

    @RequestMapping("/findAlreadyPayOrders")
    public List<Orders>findAlreadyPayOrders(){
        return ordersService.findPayOrders(1);
    }

}
