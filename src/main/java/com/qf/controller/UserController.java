package com.qf.controller;

import com.qf.domain.Users;
import com.qf.response.UserCode;
import com.qf.service.CodeService;
import com.qf.service.UsersService;
import com.qf.utils.EmailUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        String email=users.getUEmail();
        if (usersService.findByLoginName(email)!=null){
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
    public String login(@RequestBody Users users){
        String uEmail= users.getUEmail();
        String password=users.getUPassword();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uEmail, password);
        try{
            subject.login(token);
            if (subject.isAuthenticated()){

               /* List<SysPermission> list=sysPermissionMapper.selectPermissionByLoginName(loginName);

                List<Integer> a=new ArrayList<>();
                int b=0;
                for (int i=0;i<list.size();i++){
                    b= list.get(i).getPermissionId();
                    if (b==2){
                        return "for";
                    }
                    a.add(b);
                }*/

                return "success";
            }else {
                return "fail";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "null";
    }

}
