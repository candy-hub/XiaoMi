package com.qf.service;

import com.qf.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    String insert(Role role);

    Role selectById(Integer id);

    String update(Role role);

    String delete(Integer id);
}
