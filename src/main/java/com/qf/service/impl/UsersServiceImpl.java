package com.qf.service.impl;

import com.qf.dao.UsersRepository;
import com.qf.domain.Users;
import com.qf.response.Login;
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
    public Users findByRegisterName(Users users) {
        String uEmail=users.getUEmail();
        String uTell=users.getUTell();
        String uName=users.getUName();
        return usersRepository.findAllByUEmailOrUNameOrUTell(uEmail,uName,uTell);
    }

    @Override
    public Users login(Login login) {
        String loginName= login.getLoginName();
        String password=login.getPassword();
        Users a=usersRepository.findAllByUEmailOrUNameOrUTell(loginName,loginName,loginName);
        if (a.getUPassword().equals(password)){
            return a;
        }
        return null;
    }
}
