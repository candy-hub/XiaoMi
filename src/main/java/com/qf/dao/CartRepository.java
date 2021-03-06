package com.qf.dao;

import com.qf.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    Cart findByShopNameAndUId(String shopName,int uid);

    List<Cart> findAllByUId(int uId);

}
