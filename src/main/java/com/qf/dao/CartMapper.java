package com.qf.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    int findCartCount( int uid);
}
