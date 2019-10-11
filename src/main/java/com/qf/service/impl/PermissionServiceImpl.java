package com.qf.service.impl;

import com.qf.dao.PermissionRepository;
import com.qf.domain.Permission;
import com.qf.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionRepository permissionRepository;


    @Override
    public List<Permission> findAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission findPermissionById(int PId) {
        return permissionRepository.findByPId(PId);
    }

    @Override
    public Permission updatePermission(Permission permission) {
        return permissionRepository.saveAndFlush(permission);
    }
}
