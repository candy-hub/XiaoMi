package com.qf.service.impl;

import com.qf.dao.OrdersRepository;
import com.qf.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersRepository ordersRepository;
}
