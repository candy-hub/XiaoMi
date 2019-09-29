package com.qf.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Integer aId;

    @Column(name = "u_name")
    private String uName;

    @Column(name = "u_password")
    private String uPassword;

    @Column(name = "u_tell")
    private String uTell;

    @Column(name = "u_address")
    private String uAddress;

    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;//注册时间

    @Column(name = "u_pic")
    private String uPic;

    @Column(name = "u_sex")
    private boolean uSex;

    @Column(name = "u_birthday")
    private Date uBirthday;

    @Column(name = "u_money")
    private  float uMoney;//用户账户余额

    @Column(name = "u_statue")
    private  Integer uStatue;//用户状态





}
