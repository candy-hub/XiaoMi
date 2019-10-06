package com.qf.service.impl;

import com.qf.dao.ShopKindsRepository;
import com.qf.domain.ShopKinds;
import com.qf.response.Response;
import com.qf.service.ShopKindsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Response findAllShopKinds(int page, int size) {
        Pageable pages=PageRequest.of(page-1,size);
        Page<ShopKinds> all=shopKindsRepository.findAll(pages);
        Response<ShopKinds> r=new Response<>();
        r.setList(all.getContent());
        r.setTotal(all.getTotalElements());
        return r;
    }

    @Override
    public String addShopKinds(ShopKinds shopKinds) {
        String skName=shopKinds.getSkName();
        if (shopKindsRepository.findBySkName(skName)!=null){
            return "类别名已存在";
        }else {
            shopKindsRepository.save(shopKinds);
            return "success";
        }

    }

    @Override
    public ShopKinds findShopKindsById(int skId) {
        return shopKindsRepository.findBySkId(skId);
    }

    @Override
    public ShopKinds updateShopKinds(ShopKinds shopKinds) {
        return shopKindsRepository.save(shopKinds);
    }

    @Override
    public void deleteShopKinds(int skId) {
        shopKindsRepository.deleteById(skId);
    }
}
