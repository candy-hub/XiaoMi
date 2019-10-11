package com.qf.service;

import com.qf.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAllPermissions();

    String addPermission(Permission permission);

    Permission findPermissionById(Integer Pid);

    String updatePermission(Permission permission);

    String delete(Integer id);

}
