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
    public String addPermission(Permission permission) {

         permissionRepository.save(permission);
        return "1";
    }

    @Override
    public Permission findPermissionById(Integer Pid) {
        return permissionRepository.findByPId(Pid);
    }

    @Override
    public String updatePermission(Permission permission) {
         permissionRepository.saveAndFlush(permission);
        return "1";
    }

    @Override
    public String delete(Integer id) {
         permissionRepository.deleteById(id);
         return "1";
    }
}
