package com.qf.service;

import com.qf.domain.Users;
import com.qf.response.Login;

public interface UsersService {

    Users save(Users users);

    Users findById(int id);

    Users findByRegisterName(Users users);

    Users login(Login login);

    String updateUser(Users users);
}
