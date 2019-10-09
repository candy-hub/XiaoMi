package com.qf.controller;

import com.qf.domain.Admin;
import com.qf.response.Login;
import com.qf.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    /*
    * 添加管理员用户时记得用aName作为盐进行加密
    * */




    /*
     * 登录
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestBody Login login){
        String loginName= login.getLoginName();
        String password=login.getPassword();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
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
