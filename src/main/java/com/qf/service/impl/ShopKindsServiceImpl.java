package com.qf.service.impl;

import com.qf.dao.ShopKindsRepository;
import com.qf.service.ShopKindsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopKindsServiceImpl implements ShopKindsService {

    @Resource
    private ShopKindsRepository shopKindsRepository;
}
