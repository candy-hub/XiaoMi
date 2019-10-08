package com.qf.service;

import com.qf.domain.Users;

public interface UsersService {

    Users save(Users users);

    Users findById(int id);

    Users findByLoginName(String uName);
}
