package com.qf.response;

import com.qf.domain.Shops;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddCart {
    private Shops shop;
    private Integer num;  //选中商品数量
    private BigDecimal total;  //选中商品总价
}
