package com.qf.service;

import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;
import com.qf.response.AddCart;

import java.util.List;

public interface OrdersService {

    Orders submitForm1(AddCart addCart, int uid);

    List<Orders> findAllOrders(int uid);

    List<Orders> submitForm2(List<Cart> listCart,int uid);

    List<Orders> findPayOrders(Integer  Statue,int uid);

    void deleteById(int oId);

    Orders findByONumber(String ONumber);

    Orders updateStatue(Orders orders);

}
