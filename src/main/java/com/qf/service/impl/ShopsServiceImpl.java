package com.qf.service.impl;

import com.qf.dao.ShopKindsRepository;
import com.qf.dao.ShopsRepository;
import com.qf.domain.ResponseShops;
import com.qf.domain.Shops;
import com.qf.response.Response;
import com.qf.response.ShopFuzzyQuery;
import com.qf.service.ShopsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseShops showRM(Integer page, Integer size) {
        Pageable pages= PageRequest.of(page-1,size);
        Page<Shops> all = shopsRepository.findAllByOrderByShopNumberDesc(pages);
        ResponseShops res=new ResponseShops();
        res.setList(all.getContent());
        res.setTotal(all.getTotalElements());
        return res;
    }

    @Override
    public List<Shops> vague(String name) {
        return shopsRepository.findByShopNameLike("%"+name+"%");
    }

    @Override
    public Response findAllShops(int page, int size) {
        Pageable pages=PageRequest.of(page-1,size);
        Page<Shops> all=shopsRepository.findAll(pages);
        Response<Shops> r=new Response<>();

        r.setList(all.getContent());
        r.setTotal(all.getTotalElements());

        /*r.setShopKindsList(shopKindsRepository.findAll());*/

        return r;
    }

    @Override
    public String  deleteShops(int shopId) {

        shopsRepository.deleteById(shopId);
        return "1";
    }

    @Override
    public String addShops(Shops shops) {

        shopsRepository.save(shops);
        return "1";
    }

    @Override
    public Shops findShopsById(int shopId) {

       return shopsRepository.findByShopId(shopId);
    }

    @Override
    public String updateShops(Shops shops) {

        shopsRepository.save(shops);
        return "1";
    }

    @Override
    public Response ShopFuzzyQuery(int page, int size,ShopFuzzyQuery shopFuzzyQuery) {
        String name=shopFuzzyQuery.getName();
        String value=shopFuzzyQuery.getValue();
        Pageable pages=PageRequest.of(page-1,size);
        Page<Shops> all=null;
        if (value.equals("shopName")){
            all=shopsRepository.findByShopNameLike("%"+name+"%",pages);
        }
        if (value.equals("shopInfo")){
            all=shopsRepository.findByShopInfoLike("%"+name+"%",pages);
        }
//        if (value=="skNmae"){
//            all=shopsRepository.findBySkNmaeLike("%"+name+"%",pages);
//        }
        Response<Shops> r=new Response<>();

        r.setList(all.getContent());
        r.setTotal(all.getTotalElements());
        return r;
    }

    @Override
    public Response orderShops(int page, int size, String name) {

        Pageable pages = PageRequest.of(page-1,size);
        Page<Shops> all=null;
        if (name.equals("shopPrice")){
            all = shopsRepository.findAllByOrderByShopPrice(pages);
        }
        if (name.equals("shopNumber")){
            all=shopsRepository.findAllByOrderByShopNumber(pages);
        }if (name.equals("skName")){
            all=shopsRepository.findAllByOrderBySkId(pages);
        }
        Response<Shops> r=new Response<>();
        r.setList(all.getContent());
        r.setTotal(all.getTotalElements());
        return r;
    }
}
