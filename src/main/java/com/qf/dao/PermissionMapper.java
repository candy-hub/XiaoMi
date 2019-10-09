package com.qf.dao;

import com.qf.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> selectAllByAName(String aName);

}
