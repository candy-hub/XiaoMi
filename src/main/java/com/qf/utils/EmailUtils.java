package com.qf.utils;


import com.qf.dao.UserCodeRespository;
import com.qf.domain.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmailUtils {

    @Value("${spring.mail.username}")
    private String sendFrom;

    @Autowired
    private JavaMailSender javamailSender;

    @Autowired
    private UserCodeRespository userCodeRespository;

    public String sendEmail(String sendTo){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject("注册验证码");
        String code=randomCode();
        simpleMailMessage.setText(code);
        simpleMailMessage.setFrom(sendFrom);
        simpleMailMessage.setTo(sendTo);
        try{
            javamailSender.send(simpleMailMessage);
            UserCode userCode=new UserCode();
            userCode.setUsername(sendTo);
            userCode.setCode(code);
            userCode.setStatus(1); //设置当前验证码的状态
            userCodeRespository.save(userCode);
            return code;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public static String randomCode(){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++){
            int num=random.nextInt(9);
            sb.append(num);
        }
        return sb.toString();
    }


}
