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
        String password= users.getUPassword();
        String uEmail=users.getUEmail();
        Md5Utils md5Utils=new Md5Utils();
        String password1 = md5Utils.getPassword(uEmail,password);
        users.setUPassword(password1);
        return usersRepository.save(users);
    }

    @Override
    public Users findById(int id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public Users findByLoginName(String uEmail) {
        return usersRepository.findAllByUEmail(uEmail);
    }
}
