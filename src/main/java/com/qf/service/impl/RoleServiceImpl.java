package com.qf.service.impl;

import com.qf.dao.RoleRepository;
import com.qf.domain.Role;
import com.qf.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public String insert(Role role) {
         roleRepository.save(role);
         return "1";
    }

    @Override
    public Role selectById(Integer id) {
        Optional<Role> byId = roleRepository.findById(id);
        if(byId.isPresent()){
            Role role=byId.get();
            return role;
        }
        return null;
    }

    @Override
    public String update(Role role) {
        roleRepository.saveAndFlush(role);
        return "1";
    }

    @Override
    public String delete(Integer id) {
        roleRepository.deleteById(id);
        return "1";
    }
}
