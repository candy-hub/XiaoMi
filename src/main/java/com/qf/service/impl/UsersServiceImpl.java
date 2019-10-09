package com.qf.service.impl;

import com.qf.dao.UsersRepository;
import com.qf.domain.Users;
import com.qf.service.UsersService;
import com.qf.utils.Md5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersRepository usersRepository;


    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users findById(int id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public Users findByRegisterName(String uEmail) {
        return usersRepository.findAllByUEmailOrUNameOrUTell(uEmail);
    }

    @Override
    public Users login(Users users) {
        String aName= users.getUName();
        String password=users.getUPassword();

        Users a=usersRepository.findAllByUEmailOrUNameOrUTell(aName);
        if (a.getUPassword().equals(password)){
            return a;
        }
        return null;
    }
}
