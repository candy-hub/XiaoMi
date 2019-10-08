package com.qf.service;

import com.qf.domain.ResponseShops;
import com.qf.domain.Shops;
import com.qf.response.Response;

import java.util.List;

public interface ShopsService {
    Shops findByShopId(int shopId);

    List<Shops> show2(Integer skId);

    List<Shops> showlbt(Integer status);

    ResponseShops showRM(Integer page, Integer size);

    /*
    * 后台商品管理
    */
    Response findAllShops(int page, int size);

    void deleteShops(int shopId);

    Shops addShops(Shops shops);

    Shops findShopsById(int shopId);

    Shops updateShops(Shops Shops);

}
