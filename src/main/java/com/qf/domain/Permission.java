package com.qf.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Integer pId;

    @Column(name = "p_name")
    private String pName;

    @Column(name = "p_info")
    private String pInfo;//权限备注

    @Column(name = "r_id")
    private Integer rId;//角色表的外键

}
