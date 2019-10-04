package com.qf.response;

import com.qf.domain.Shops;
import lombok.Data;

@Data
public class AddCart {
    private Shops shop;
    private Integer num;
    private Float total;
}
