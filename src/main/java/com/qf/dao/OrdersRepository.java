package com.qf.dao;

import com.qf.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findByOStatue(Integer  Statue);

    List<Orders> findAllByUId(int uid);
}
