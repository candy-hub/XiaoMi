package com.qf.response;

import com.qf.domain.Shops;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddCart {
    private Shops shop;
    private Integer num;
    private BigDecimal total;
}
