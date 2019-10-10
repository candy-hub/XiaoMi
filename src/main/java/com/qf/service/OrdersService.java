package com.qf.service;

import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;

import java.util.List;

public interface OrdersService {

    Orders submitForm1(Shops shops);

    List<Orders> findAllOrders();

    List<Orders> submitForm2(List<Cart> listCart);

    List<Orders> findPayOrders(Integer  Statue);

}
