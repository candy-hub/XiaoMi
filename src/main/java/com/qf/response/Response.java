package com.qf.response;

import lombok.Data;

import java.util.List;

@Data
public class Response<T> {
    private List<T> list;
    private Long total;
}
