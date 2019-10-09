package com.qf.service.impl;

import com.qf.dao.CodeRepository;
import com.qf.domain.Code;
import com.qf.domain.Users;
import com.qf.service.CodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeRepository codeRepository;


    @Override
    public int sendTo(Users users, String code) {
        String useremail = users.getUEmail();
        Code co = codeRepository.findByUEmail(useremail);
        Date createTime = co.getCreateTime();
        Date nowTime = new Date();
//        System.out.println(nowTime);
//        System.out.println(createTime);
        long i = nowTime.getTime()-createTime.getTime();  //比较毫秒值
//        System.out.println(i);
        if (i >= 6000) {
            //失效
            co.setCStatue(0);
            codeRepository.save(co);
            return 2;
        } else {
            if (co.getCCode().equals(code)) {
                co.setCStatue(0);
                codeRepository.save(co);
                return 1;
            } else {
                return 3;
            }
        }
        // return 1;
    }
}

