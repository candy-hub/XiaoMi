package com.qf.service;

import com.qf.domain.Users;

public interface UsersService {

    Users save(Users users);

    Users findById(int id);

    Users findByRegisterName(String uEmail,String uName,String uTell);

    Users login(Users users);
}
