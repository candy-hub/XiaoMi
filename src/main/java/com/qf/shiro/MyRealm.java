package com.qf.shiro;

import com.qf.dao.AdminRepository;
import com.qf.dao.PermissionMapper;
import com.qf.dao.PermissionRepository;
import com.qf.dao.UsersRepository;
import com.qf.domain.Admin;
import com.qf.domain.Permission;
import com.qf.domain.Users;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm{

    @Resource
    private AdminRepository adminRepository;

    @Resource
    private UsersRepository usersRepository;

    @Resource
    private PermissionMapper permissionMapper;


    /*
    * 负责授权的方法
    */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
       String aName=(String) principal.getPrimaryPrincipal();
       //查找权限
        List<Permission> permissions=permissionMapper.selectAllByAName(aName);
        Collection per=new HashSet<>(); //去重

        for (Permission s:permissions){
            per.add(s.getPName());  //获得权限名
        }
        System.out.println(per);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addStringPermissions(per);

        return simpleAuthorizationInfo;
    }


     /*
     * 负责用户认证的方法
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String uEmail=(String)token.getPrincipal();
        Users users=usersRepository.findAllByUEmail(uEmail);
        String salt=users.getUEmail();  //把用户名作为加密密码的盐
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(uEmail,users.getUPassword(),ByteSource.Util.bytes(salt),getName());
        return simpleAuthenticationInfo;
    }

}
