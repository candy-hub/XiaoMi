/*
package com.qf.shiro;

import com.qf.dao.AdminRepository;
import com.qf.dao.PermissionRepository;
import com.qf.domain.Permission;
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
    private AdminRepository sysUserRepository;

    @Resource
    private PermissionRepository sysPermissionRepository;

   */
/* @Resource
    private SysPermissionMapper sysPermissionMapper;*//*

    */
/*
     * 负责授权的方法
     *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
       String loginName=(String) principal.getPrimaryPrincipal();
       //查找权限
        List<Permission> sysPermissions=sysPermissionRepository.selectPermissionByLoginName(loginName);
        Collection permissions=new HashSet<>(); //去重

        for (SysPermission s:sysPermissions){
            permissions.add(s.getPerName());  //获得权限名
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }
    */
/*
     *负责用户认证的方法
     *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getPrincipal();
        SysUser sysUser=sysUserRepository.findByLoginName(username);
        String salt=sysUser.getLoginName();  //把用户名作为加密密码的盐
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,sysUser.getPassword(),ByteSource.Util.bytes(salt),getName());
        return simpleAuthenticationInfo;
    }
}
*/
