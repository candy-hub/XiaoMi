package com.qf.service.impl;

import com.qf.dao.CartRepository;
import com.qf.dao.OrdersRepository;
import com.qf.dao.UsersRepository;
import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;
import com.qf.domain.Users;
import com.qf.service.OrdersService;
import com.qf.utils.OrderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrdersRepository ordersRepository;

    @Resource
    CartRepository cartRepository;

    @Resource
    private OrderUtils orderUtils;

    @Resource
    private UsersRepository usersRepository;

    @Override
    public Orders submitForm1(Shops shops,int uid) {
        Optional<Users> byId = usersRepository.findById(uid);
        Users users=byId.get();
        String orderNumber=orderUtils.getOrder();
        Orders orders=new Orders();
        orders.setOStatue(0);
        orders.setONumber(orderNumber);
        orders.setShopName(shops.getShopName());
        orders.setShopPic(shops.getShopPic());
        orders.setShopNumber(shops.getShopNumber());
        orders.setShopPrice(shops.getShopPrice());
        orders.setShopFactory(shops.getFactory());
        BigDecimal bigDecimal=new BigDecimal(12343.34);
        orders.setShopCount(bigDecimal);
        orders.setUId(users.getUId());
        orders.setUserName(users.getUName());
        orders.setUserTell(users.getUTell());
        orders.setUserAddress(users.getUAddress());
        ordersRepository.save(orders);
        return orders;
    }

    @Override
    public List<Orders> findAllOrders(int uid) {
        return ordersRepository.findAllByUId(uid);
    }

    @Override
    public List<Orders> submitForm2(List<Cart> listCart,int uid) {
        Optional<Users> byId = usersRepository.findById(uid);
        Users users=byId.get();
        List<Orders> listOrders=new ArrayList<>();
        Orders orders=new Orders();
        for(Cart cart:listCart){
            String orderNumber=orderUtils.getOrder();
            orders.setOStatue(0);
            orders.setONumber(orderNumber);
            orders.setShopName(cart.getShopName());
            orders.setShopPic(cart.getShopPic());
            orders.setShopNumber(cart.getShopCount());
            orders.setShopPrice(cart.getShopPrice());
            orders.setShopFactory(cart.getShopFactory());

            BigDecimal bigDecimal=new BigDecimal(12343.34);
            orders.setShopCount(bigDecimal);
            orders.setUId(users.getUId());
            orders.setUserName(users.getUName());
            orders.setUserTell(users.getUTell());
            orders.setUserAddress(users.getUAddress());
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
