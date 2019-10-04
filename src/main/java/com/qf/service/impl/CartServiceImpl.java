package com.qf.service.impl;

import com.qf.dao.CartRepository;
import com.qf.domain.Cart;
import com.qf.domain.Shops;
import com.qf.response.AddCart;
import com.qf.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addCart(AddCart cart) {
        Shops shop=cart.getShop();
        Cart c=new Cart();
        Cart c2=cartRepository.findByShopName(shop.getShopName());
        if (c2!=null){
            c2.setShopCount(cart.getNum() + c2.getShopCount());
            c2.setShopTotal(cart.getTotal() + c2.getShopTotal());
            return cartRepository.save(c2);
        }else {
            c.setShopCount(cart.getNum());
            c.setShopName(shop.getShopName());
            c.setShopPic(shop.getShopPic());
            c.setShopPrice(shop.getShopPrice());
            c.setShopTotal(cart.getTotal());
            c.setUId(1); //待定
            return cartRepository.save(c);
        }
    }

    @Override
    public Cart updateCart(Cart cart) {

        return cartRepository.save(cart);

    }

    @Override
    public void deleteById(int cId) {
        cartRepository.deleteById(cId);
    }
}
