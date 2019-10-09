package com.qf.service.impl;

import com.qf.dao.CartRepository;
import com.qf.dao.OrdersRepository;
import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;
import com.qf.service.OrdersService;
import com.qf.utils.OrderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersRepository ordersRepository;

    @Resource
    CartRepository cartRepository;

    @Resource
    private OrderUtils orderUtils;

    @Override
    public Orders submitForm1(Shops shops) {
        String orderNumber=orderUtils.getOrder();
        Orders orders=new Orders();
        orders.setONumber(orderNumber);
        orders.setShopName(shops.getShopName());
        orders.setShopPic(shops.getShopPic());
        orders.setShopNumber(shops.getShopNumber());
        orders.setShopPrice(shops.getShopPrice());
        orders.setShopFactory(shops.getFactory());
        orders.setShopCount(12343.34f);
        orders.setUserName("景娴");
        orders.setUserTell("13198468324");
        orders.setUserAddress("陕西省西安市小米市场部");
        ordersRepository.save(orders);
        return orders;
    }

    @Override
    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Orders> submitForm2(List<Cart> listCart) {
        List<Orders> listOrders=new ArrayList<>();
        Orders orders=new Orders();
        for(Cart cart:listCart){
            String orderNumber=orderUtils.getOrder();
            orders.setONumber(orderNumber);
            orders.setShopName(cart.getShopName());
            orders.setShopPic(cart.getShopPic());
            orders.setShopNumber(cart.getShopCount());
            orders.setShopPrice(cart.getShopPrice());
            orders.setShopFactory(cart.getShopFactory());
            orders.setShopCount(12343.34f);
            orders.setUserName("景娴");
            orders.setUserTell("13198468324");
            orders.setUserAddress("陕西省西安市小米市场部");
            listOrders.add(orders);
            cartRepository.delete(cart);
        }
        System.out.println(listOrders);
        ordersRepository.saveAll(listOrders);
        return listOrders;
    }

    @Override
    public List<Orders> findPayOrders(Integer  Statue) {
        return ordersRepository.findByOStatue(Statue);
    }
}
