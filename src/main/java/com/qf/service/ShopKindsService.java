package com.qf.service;

import com.qf.domain.ShopKinds;
import com.qf.response.Response;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ShopKindsService {
    List<ShopKinds> show1();

    Response findAllShopKinds(int page, int size);

    String addShopKinds(ShopKinds shopKinds);

    ShopKinds findShopKindsById(int skId);

    ShopKinds updateShopKinds(ShopKinds shopKinds);

    void deleteShopKinds(int skId);
}
