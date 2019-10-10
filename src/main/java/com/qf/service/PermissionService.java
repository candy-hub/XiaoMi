package com.qf.service;

import com.qf.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAllPermissions();

    Permission addPermission(Permission permission);

    Permission findPermissionById(int PId);

    Permission updatePermission(Permission permission);

}
