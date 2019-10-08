package com.qf.domain;


import lombok.Data;

import java.util.List;

@Data
public class ResponseShops<T> {
    private List<T> list;
    private Long total;
}
