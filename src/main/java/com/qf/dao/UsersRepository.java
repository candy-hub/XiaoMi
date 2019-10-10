package com.qf.dao;

import com.qf.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Integer> {

    List<Users> findAllByUEmailOrUNameOrUTell(String uEmail, String uName, String uTell);

}
