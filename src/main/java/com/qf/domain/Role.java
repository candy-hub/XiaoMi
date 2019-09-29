package com.qf.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Integer rId;

    @Column(name = "r_name")
    private String rName;

    @Column(name = "r_info")
    private String rInfo;//角色备注

    @Column(name = "a_id")
    private Integer aId;//用户表的外键

}
