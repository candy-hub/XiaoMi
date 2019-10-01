package com.qf.service.impl;

import com.qf.dao.CartRepository;
import com.qf.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartRepository cartRepository;
}
