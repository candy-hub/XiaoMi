package com.qf.controller;

import com.qf.service.CartService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CartController {

    @Resource
    private CartService cartService;
}
