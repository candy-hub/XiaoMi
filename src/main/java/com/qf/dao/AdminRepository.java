package com.qf.dao;

import com.qf.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByANameOrAEmailOrATell(String aName,String aEmail,String aTell);
}
