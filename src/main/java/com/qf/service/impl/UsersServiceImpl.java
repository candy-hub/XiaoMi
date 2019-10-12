package com.qf.service.impl;

import com.qf.dao.UsersRepository;
import com.qf.domain.Users;
import com.qf.response.Login;
import com.qf.service.UsersService;
import com.qf.utils.Md5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public String findByRegisterName(Users users) {
        String uEmail=users.getUEmail();
        String uTell=users.getUTell();
        String uName=users.getUName();
        List<Users> all = usersRepository.findAllByUEmailOrUNameOrUTell(uEmail, uName, uTell);
        if (all.size()>0){
            return "fail";
        }else {
            return "success";
        }
    }

    @Override
    public String login(Login login) {
        String loginName= login.getLoginName();
        String password=login.getPassword();
        //登录时进行MD5加密
        List<Users> all = usersRepository.findAllByUEmailOrUNameOrUTell(loginName, loginName, loginName);
        if(all.size()==0){
            return "用户名不存在";
        }else if (all.size()==1) {
            String pass = md5Utils.getPassword(all.get(0).getUName(), password);

            if (all.get(0).getUPassword().equals(pass)) {
                return "success";
            }
        }else {
            return "登录失败";
        }
        return "登录失败";
    }
    /*
    *先查id
    */
    @Override
    public String updateUser(Users users) {
        String uEmail=users.getUEmail();
        String uTell=users.getUTell();
        String uName=users.getUName();
        List<Users> all = usersRepository.findAllByUEmailOrUNameOrUTell(uEmail, uName, uTell);
        if (all.size()==1){
            usersRepository.save(users);
            return "success";
        }else {
            return "fail";
        }

    }

    @Override
    public Users findByName(String uname) {
        List<Users> all = usersRepository.findAllByUEmailOrUNameOrUTell(uname, uname, uname);
        return all.get(0);
    }

}
