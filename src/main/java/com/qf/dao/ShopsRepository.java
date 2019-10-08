package com.qf.dao;

import com.qf.domain.Shops;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopsRepository extends JpaRepository<Shops,Integer> {

    Shops findByShopId(int shopId);

    List<Shops> findBySkId(Integer skId);

    List<Shops> findByStatus(Integer status);

    Page<Shops> findAllByOrderByShopNumberDesc(Pageable pages);

}
