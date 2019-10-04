package com.qf.service;

import com.qf.domain.Cart;
import com.qf.response.AddCart;

import java.util.List;

public interface CartService {

    List<Cart> findAll();

    Cart addCart(AddCart cart);

    Cart updateCart(AddCart cart);
}
