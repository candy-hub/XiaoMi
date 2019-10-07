package com.qf.dao;

import com.qf.domain.ShopKinds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopKindsRepository extends JpaRepository<ShopKinds,Integer> {

    ShopKinds findBySkName(String skName);

    ShopKinds findBySkId(int skId);

}
