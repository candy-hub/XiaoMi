package com.qf.service.impl;

import com.qf.dao.AdminRepository;
import com.qf.domain.Admin;
import com.qf.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;


}
