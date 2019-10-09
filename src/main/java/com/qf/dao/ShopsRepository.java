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

    List<Shops> findByShopNameLike(String name);

    Page<Shops> findByShopNameLike(String name,Pageable pageable);

    Page<Shops> findByShopInfoLike(String shopInfo,Pageable pageable);

//    Page<Shops> findBySkNmaeLike(String skNmae,Pageable pageable);  //类别也可以用来排序

    /*价格、销量可以用包含查询，或者between查询*/

//    List<Shops> findByShopPriceLike(Float shopPrice);

}
