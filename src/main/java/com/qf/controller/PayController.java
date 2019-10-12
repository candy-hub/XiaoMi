package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.qf.config.AlipayConfig;
import com.qf.domain.Orders;
import com.qf.service.OrdersService;
import com.qf.utils.AlipayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class PayController {

    @Resource
    private OrdersService ordersService;

    @Autowired
    private AlipayUtils alipayUtils;

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String pay(@RequestBody List<Orders> listOrders){
        Orders orders1=new Orders();
        for(Orders orders:listOrders){
            orders1.setONumber(orders.getONumber());
            orders1.setShopPrice(orders.getShopPrice());
            orders1.setShopName(orders.getShopName());
            orders1.setOStatue(orders.getOStatue());
        }
        //System.out.println(orders1);
        String pay="";
        try {
            pay = alipayUtils.pay(orders1);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        return pay;
    }

    @RequestMapping("/notify")
    public void Verify(HttpServletRequest request, HttpServletResponse response)throws AlipayApiException {
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        //System.out.println(params);

        Orders orders=ordersService.findByONumber(params.get("out_trade_no"));
        if (orders == null) {
            throw new AlipayApiException("out_trade_no错误");
        }

        long total_amount = new BigDecimal(params.get("total_amount")).multiply(new BigDecimal(100)).longValue();
        if (total_amount != orders.getShopPrice().longValue()) {
            throw new AlipayApiException("error total_amount");
        }

        if (!params.get("app_id").equals(AlipayConfig.app_id)) {
            throw new AlipayApiException("app_id不一致");
        }

        System.out.println(orders);
        orders.setOStatue(1);
        ordersService.updateStatue(orders);
    }
}