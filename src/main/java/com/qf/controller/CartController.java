package com.qf.controller;

import com.qf.domain.Cart;
import com.qf.response.AddCart;
import com.qf.service.CartService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CartController {

    @Resource
    private CartService cartService;


    @RequestMapping("/findAllCart")
    public List<Cart> findAll(){

        return cartService.findAll();
    }

    /*从详情页加入购物车*/
    @RequestMapping("/addCart")
    public Cart addCart(@RequestBody AddCart cart){

        return cartService.addCart(cart);
    }

    /*修改购物车数量*/
    @RequestMapping("/updateCart")
    public Cart saveCart(@RequestBody Cart cart){

        return cartService.updateCart(cart);
    }

    @RequestMapping("/deleteCart")
    public String deleteCart(int cId){
        cartService.deleteById(cId);
        return "删除成功";
    }
}
