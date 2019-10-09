package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.qf.domain.Orders;
import com.qf.utils.AlipayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private AlipayUtils alipayUtils;

    @RequestMapping("/pay")
    public String pay(Orders orders){
        String pay="";
        try {
            pay = alipayUtils.pay(orders);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        return pay;
    }

}