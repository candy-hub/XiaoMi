package com.qf.service.impl;

import com.qf.dao.AdminRepository;
import com.qf.domain.Admin;
import com.qf.service.AdminService;
import com.qf.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;
    @Autowired
    private Md5Utils md5Utils;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public String insert(Admin admin) {
        admin.setAPassword(md5Utils.getPassword(admin.getAName(),admin.getAPassword()));
        admin.setCreateTime(new Date());
         adminRepository.save(admin);
         return "1";
    }

    @Override
    public Admin selectById(Integer id) {
        Optional<Admin> byId = adminRepository.findById(id);
        if(byId.isPresent()){
            Admin admin=byId.get();
            return admin;
        }
        return null;
    }

    @Override
    public String update(Admin admin) {
        adminRepository.saveAndFlush(admin);
        return "1";
    }

    @Override
    public String delete(Integer id) {
        adminRepository.deleteById(id);
        return "1";
    }
}
