package com.qf.controller;

import com.qf.domain.Cart;
import com.qf.response.AddCart;
import com.qf.service.CartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CartController {

    @Resource
    private CartService cartService;

    @RequestMapping("/findAllCart/{uid}")
    public List<Cart> findAll(@PathVariable int uid){
        System.out.println(uid);
        return cartService.findAll(uid);
    }

    /*从详情页加入购物车*/
    @RequestMapping("/addCart/{uid}")
    public Cart addCart(@RequestBody AddCart cart,@PathVariable int uid){

        return cartService.addCart(cart,uid);
    }

    /*修改购物车数量*/
    @RequestMapping("/updateCart")
    public Cart saveCart(@RequestBody Cart cart){

        return cartService.updateCart(cart);
    }

    @RequestMapping("/deleteCart/{cId}")
    public String deleteCart(@PathVariable int cId){
        System.out.println(cId);
        cartService.deleteById(cId);
        return "删除成功";
    }
}
