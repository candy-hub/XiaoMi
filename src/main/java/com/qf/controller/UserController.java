package com.qf.controller;

import com.qf.dao.UsersRepository;
import com.qf.domain.Users;
import com.qf.response.Login;
import com.qf.response.UserCode;
import com.qf.service.CodeService;
import com.qf.service.UsersService;
import com.qf.utils.EmailUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController {

    @Resource
    private UsersService usersService;

    @Resource
    private EmailUtils emailUtils;

    @Resource
    private CodeService codeService;

    @Resource
    private UsersRepository usersRepository;


    @RequestMapping(value = "/findAllUsers",method = RequestMethod.GET)
    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }

    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    public List<Users> checkUser(@RequestBody Users users){
        return usersRepository.findAllByUNameAndUEmailAndUTell(users.getUName(),users.getUEmail(),users.getUTell());
    }


    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public String sendEmail(@RequestBody Users users){
        String uEmail=users.getUEmail();
        return emailUtils.sendEmail(uEmail);
    }
    /*
     * 注册
     */
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public String register(@RequestBody UserCode userCode){
        String msg="";
        Users users=userCode.getUsers();
        String code=userCode.getCode();

        if (usersService.findByRegisterName(users)!="success"){
            msg="用户名已存在";
            return msg;
        }
        int i=codeService.sendTo(users,code);

        if (i!=1) {
            if (i == 2) {
                msg = "验证码已失效";

            }else if (i == 3) {
                msg = "验证码错误";
            }else if (i == 4) {
                msg = "未发送验证码，请发送验证码";
            }
            return msg;
        }else {
            usersService.save(users);
            return "success";
        }
    }

    /*
     * 登录
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String userLogin(@RequestBody Login login){
        return usersService.login(login);
    }

    @RequestMapping(value = "/findUserByUid/{uId}",method = RequestMethod.GET)
    public Users findById(@PathVariable int uId){
        return usersService.findById(uId);
    }

    @RequestMapping(value = "/findUserByName/{uname}",method = RequestMethod.POST)
    public Users findByName(@PathVariable String uname){

        return usersService.findByName(uname);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(@RequestBody Users users){

        return usersService.updateUser(users);

    }

    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public String updatePassword(@RequestBody Users users){

        return usersService.updatePassword(users);

    }

}
