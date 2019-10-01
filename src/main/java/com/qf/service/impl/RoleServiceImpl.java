package com.qf.service.impl;

import com.qf.dao.RoleRepository;
import com.qf.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;
}
