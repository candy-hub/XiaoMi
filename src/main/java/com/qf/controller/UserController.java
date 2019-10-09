package com.qf.controller;

import com.qf.domain.Users;
import com.qf.response.Login;
import com.qf.response.UserCode;
import com.qf.service.CodeService;
import com.qf.service.UsersService;
import com.qf.utils.EmailUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {

    @Resource
    private UsersService usersService;

    @Resource
    private EmailUtils emailUtils;

    @Resource
    private CodeService codeService;


    @RequestMapping("/sendEmail")
    public String sendEmail(@RequestBody Users users){
        String uEmail=users.getUEmail();
        return emailUtils.sendEmail(uEmail);
    }
    /*
     * 注册
     */
    @RequestMapping("/userRegister")
    public String register(@RequestBody UserCode userCode){
        String msg="";
        Users users=userCode.getUsers();
        String code=userCode.getCode();

        if (usersService.findByRegisterName(users)!=null){
            msg="用户名已存在";
            return msg;
        }
        int i=codeService.sendTo(users,code);

        if (i!=1) {
            if (i == 2) {
                msg = "验证码已失效";

            }else if (i == 3) {
                msg = "验证码错误";
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
    @RequestMapping("/userLogin")
    public Users userLogin(@RequestBody Login login){

        return usersService.login(login);
    }

}
