package com.qf.service.impl;

import com.qf.dao.ShopsRepository;
import com.qf.domain.Shops;
import com.qf.service.ShopsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopsServiceImpl implements ShopsService {

    @Resource
    private ShopsRepository shopsRepository;


    @Override
    public Shops findByShopId(int shopId) {
        return shopsRepository.findByShopId(shopId);
    }

    @Override
    public List<Shops> show2(Integer skId) {
        return shopsRepository.findBySkId(skId);
    }
}
