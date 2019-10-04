package com.qf.service.impl;

import com.qf.dao.ShopKindsRepository;
import com.qf.domain.ShopKinds;
import com.qf.service.ShopKindsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopKindsServiceImpl implements ShopKindsService {

    @Resource
    private ShopKindsRepository shopKindsRepository;

    @Override
    public List<ShopKinds> show1() {
        return shopKindsRepository.findAll();
    }
}
