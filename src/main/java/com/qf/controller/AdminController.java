package com.qf.controller;

import com.qf.domain.Admin;
import com.qf.response.Login;
import com.qf.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
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

    //查看管理员
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Admin> findAll(){
     return adminService.findAll();
    }

    //新增管理员
    @RequiresPermissions(value = {"addAdmin"})
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestBody Admin admin){
        //System.out.println(admin);
        return adminService.insert(admin);
    }

    //修改管理员
    @RequestMapping(value = "/selectById/{ids}",method = RequestMethod.GET)
    public Admin selectById(@PathVariable ("ids") Integer id){
       return adminService.selectById(id);
    }
    @RequiresPermissions(value = {"updateAdmin"})
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody Admin admin){
        return adminService.update(admin);
    }

    //删除管理员
    @RequiresPermissions(value = {"deleteAdmin"})
     @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable ("id") Integer id){
        return adminService.delete(id);
     }

}
