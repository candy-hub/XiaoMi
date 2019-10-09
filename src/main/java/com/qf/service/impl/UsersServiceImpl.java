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

    private Md5Utils md5Utils=new Md5Utils();

    @Override
    public Users save(Users users) {
        //注册时进行MD5加密
        String uName=users.getUName();
        String password=users.getUPassword();
        String pass=md5Utils.getPassword(uName,password);
        users.setUPassword(pass);
        return usersRepository.save(users);
    }

    @Override
    public Users findById(int id) {
        return usersRepository.findById(id).get();
    }

    /*判断用户名是否存在*/
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
        //登录时进行MD5加密
        Users a=usersRepository.findAllByUEmailOrUNameOrUTell(loginName,loginName,loginName);

        String pass=md5Utils.getPassword(a.getUName(),password);

        if (a.getUPassword().equals(pass)){
            return a;
        }
        return null;
    }
}
