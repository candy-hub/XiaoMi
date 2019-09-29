package com.qf.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    private Integer aId;

    @Column(name = "a_name")
    private String aName;

    @Column(name = "a_password")
    private String aPassword;

    @Column(name = "a_tell")
    private Number aTell;

    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Data createTime;//注册时间

    @Column(name = "a_statue")
    private Integer aStatue;//管理员的状态
}
