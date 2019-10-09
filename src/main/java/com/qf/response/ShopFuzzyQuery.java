package com.qf.response;

import lombok.Data;

@Data
public class ShopFuzzyQuery {
    private String value;  //模糊查询条件
    private String name;  //模糊查询字段
}
