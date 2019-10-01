package com.qf.service.impl;

import com.qf.dao.ShopsRepository;
import com.qf.service.ShopsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopsServiceImpl implements ShopsService {

    @Resource
    private ShopsRepository shopsRepository;


}
