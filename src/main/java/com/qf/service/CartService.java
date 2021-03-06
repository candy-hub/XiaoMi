package com.qf.service;

import com.qf.domain.Cart;
import com.qf.response.AddCart;

import java.util.List;

public interface CartService {

    List<Cart> findAll(int uId);

    Cart addCart(AddCart cart,int uid);

    Cart updateCart(Cart cart);

    void deleteById(int cId);

    int findCartCount(int uid);
}
