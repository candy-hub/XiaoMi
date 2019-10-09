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
    public Users findByRegisterName(String uEmail,String uName,String uTell) {
        return usersRepository.findAllByUEmailOrUNameOrUTell(uEmail,uName,uTell);
    }

    @Override
    public Users login(Users users) {
        String uName= users.getUName();
        String password=users.getUPassword();
        String uTell=users.getUTell();
        String uEmail=users.getUName();
        Users a=usersRepository.findAllByUEmailOrUNameOrUTell(uEmail,uName,uTell);
        if (a.getUPassword().equals(password)){
            return a;
        }
        return null;
    }
}
