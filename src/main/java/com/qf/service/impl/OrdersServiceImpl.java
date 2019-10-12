package com.qf.service.impl;

import com.qf.dao.CartRepository;
import com.qf.dao.OrdersRepository;
import com.qf.dao.ShopsRepository;
import com.qf.dao.UsersRepository;
import com.qf.domain.Cart;
import com.qf.domain.Orders;
import com.qf.domain.Shops;
import com.qf.domain.Users;
import com.qf.response.AddCart;
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
    private ShopsRepository shopsRepository;

    @Resource
    private OrdersRepository ordersRepository;

    @Resource
    CartRepository cartRepository;

    @Resource
    private OrderUtils orderUtils;

    @Resource
    private UsersRepository usersRepository;

    @Override
    public Orders submitForm1(AddCart addCart, int uid) {
        Optional<Users> byId = usersRepository.findById(uid);
        Users users=byId.get();
        Shops shops=addCart.getShop();
        String orderNumber=orderUtils.getOrder();
        Orders orders=new Orders();
        orders.setOStatue(0);
        orders.setONumber(orderNumber);
        orders.setShopName(shops.getShopName());
        orders.setShopPic(shops.getShopPic());
        orders.setShopNumber(addCart.getNum());  //购买商品数量
        orders.setShopPrice(shops.getShopPrice());
        orders.setShopFactory(shops.getFactory());
        orders.setShopCount(addCart.getTotal());
        orders.setUId(users.getUId());
        orders.setUserName(users.getUName());
        orders.setUserTell(users.getUTell());
        orders.setUserAddress(users.getUAddress());
        //System.out.println(orders);
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

        for(Cart cart:listCart){
            Orders orders=new Orders();
            String orderNumber=orderUtils.getOrder();
            orders.setOStatue(0);
            orders.setONumber(orderNumber);
            orders.setShopName(cart.getShopName());
            orders.setShopPic(cart.getShopPic());
            orders.setShopNumber(cart.getShopCount());
            orders.setShopPrice(cart.getShopPrice());
            orders.setShopFactory(cart.getShopFactory());
            orders.setShopCount(cart.getShopTotal());
            orders.setUId(users.getUId());
            orders.setUserName(users.getUName());
            orders.setUserTell(users.getUTell());
            orders.setUserAddress(users.getUAddress());
            //System.out.println(orders);
            listOrders.add(orders);
            cartRepository.delete(cart);
        }
//        System.out.println(listOrders);
        ordersRepository.saveAll(listOrders);
        return listOrders;
    }

    @Override
    public List<Orders> findPayOrders(Integer  Statue,int uid) {
        return ordersRepository.findAllByUIdAndOStatue(uid,Statue);
    }

    @Override
    public void deleteById(int oId) {
        ordersRepository.deleteById(oId);
    }

    @Override
    public Orders findByONumber(String ONumber) {
        return ordersRepository.findByONumber(ONumber);
    }

    @Override
    public Orders updateStatue(Orders orders) {
        Shops shops=shopsRepository.findByShopName(orders.getShopName());
        Integer num=orders.getShopNumber();
        Integer ShopNumber=shops.getShopNumber();
        Integer ShopRepertory=shops.getShopRepertory();
        shops.setShopNumber(num+ShopNumber);
        shops.setShopRepertory(ShopRepertory-num);
        shopsRepository.save(shops);
        orders.setOStatue(1);
        return ordersRepository.saveAndFlush(orders);
    }
}
