package com.qf.service;

import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;

import java.util.List;

public interface OrdersService {

    Orders submitForm1(Shops shops,int uid);

    List<Orders> findAllOrders(int uid);

    List<Orders> submitForm2(List<Cart> listCart,int uid);

    List<Orders> findPayOrders(Integer  Statue);

    void deleteById(int oId);

}
