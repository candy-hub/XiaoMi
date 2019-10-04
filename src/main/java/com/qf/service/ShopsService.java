package com.qf.service;

import com.qf.domain.Shops;

import java.util.List;

public interface ShopsService {
    Shops findByShopId(int shopId);

    List<Shops> show2(Integer skId);

}
