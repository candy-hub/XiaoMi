package com.qf.service;

import com.qf.domain.Users;

public interface CodeService {

    int sendTo(Users users, String code); //生成验证码
}
