package com.qf.service;

import com.qf.domain.Permission;
import com.qf.domain.Users;
import com.qf.response.Login;

import java.util.List;

public interface UsersService {

    Users save(Users users);

    Users findById(int id);

    String findByRegisterName(Users users);

    Users login(Login login);

    String updateUser(Users users);
}
