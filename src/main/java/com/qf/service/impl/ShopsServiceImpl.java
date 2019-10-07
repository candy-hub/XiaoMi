package com.qf.service.impl;

import com.qf.dao.ShopKindsRepository;
import com.qf.dao.ShopsRepository;
import com.qf.domain.Shops;
import com.qf.response.Response;
import com.qf.service.ShopsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopsServiceImpl implements ShopsService {

    @Resource
    private ShopsRepository shopsRepository;

    @Resource
    private ShopKindsRepository shopKindsRepository;


    @Override
    public Shops findByShopId(int shopId) {
        return shopsRepository.findByShopId(shopId);
    }

    @Override
    public List<Shops> show2(Integer skId) {
        return shopsRepository.findBySkId(skId);
    }

    @Override
    public List<Shops> showlbt(Integer status) {
       return shopsRepository.findByStatus(status);
    }

    @Override
    public Response findAllShops(int page, int size) {
        Pageable pages=PageRequest.of(page-1,size);
        Page<Shops> all=shopsRepository.findAll(pages);
        Response<Shops> r=new Response<>();

        r.setList(all.getContent());
        r.setTotal(all.getTotalElements());

        r.setShopKindsList(shopKindsRepository.findAll());

        return r;
    }

    @Override
    public void deleteShops(int shopId) {
        shopsRepository.deleteById(shopId);
    }

    @Override
    public Shops addShops(Shops shops) {
        return shopsRepository.save(shops);
    }

    @Override
    public Shops findShopsById(int shopId) {
        return shopsRepository.findByShopId(shopId);
    }

    @Override
    public Shops updateShops(Shops shops) {
        return shopsRepository.save(shops);
    }
}
