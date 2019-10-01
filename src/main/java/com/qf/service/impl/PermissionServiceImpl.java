package com.qf.service.impl;

import com.qf.dao.PermissionRepository;
import com.qf.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionRepository permissionRepository;
}
