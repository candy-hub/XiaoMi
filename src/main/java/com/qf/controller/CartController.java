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

    @RequestMapping(value = "/findAllCart/{uid}",method = RequestMethod.GET)
    public List<Cart> findAll(@PathVariable int uid){
        return cartService.findAll(uid);
    }

    @RequestMapping(value = "/count/{uid}",method = RequestMethod.POST)
    public Integer findCartCount(@PathVariable int uid){
        return cartService.findCartCount(uid);
    }

    /*从详情页加入购物车*/
    @RequestMapping(value = "/addCart/{uid}",method = RequestMethod.POST)
    public Cart addCart(@RequestBody AddCart cart,@PathVariable int uid){

        return cartService.addCart(cart,uid);
    }

    /*修改购物车数量*/
    @RequestMapping(value = "/updateCart",method = RequestMethod.POST)
    public Cart saveCart(@RequestBody Cart cart){

        return cartService.updateCart(cart);
    }

    @RequestMapping(value = "/deleteCart/{cId}",method = RequestMethod.GET)
    public String deleteCart(@PathVariable int cId){
        cartService.deleteById(cId);
        return "删除成功";
    }
}
