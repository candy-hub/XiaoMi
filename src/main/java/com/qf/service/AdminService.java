package com.qf.service;

import com.qf.domain.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();

    String insert(Admin admin);

    Admin selectById(Integer id);

    String update(Admin admin);

    String delete(Integer id);

}
