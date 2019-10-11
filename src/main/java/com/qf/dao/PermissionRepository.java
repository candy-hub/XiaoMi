package com.qf.dao;

import com.qf.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    Permission findByPId(int PId);
}
