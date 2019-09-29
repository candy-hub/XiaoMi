package com.qf.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

@Component
public class Md5Utils {
    public String getPassword(String username,String pass){
        String hashAlgorithName = "MD5";//加密算法
        String password = pass;//登陆时的密码
        int hashIterations =1024;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);//使用登录名做为salt
        SimpleHash simpleHash = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        return simpleHash.toString();
    }

}
