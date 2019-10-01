package com.qf.service.impl;

import com.qf.dao.UsersRepository;
import com.qf.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersRepository usersRepository;
}
