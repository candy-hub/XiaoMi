package com.qf.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer uId;

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
    private Date createTime;//注册时间

    @Column(name = "u_pic")
    private String uPic;

    @Column(name = "u_sex")
    private boolean uSex;  //1:男  0:女

    @Column(name = "u_birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date uBirthday;

    @Column(name = "u_money")
    private  float uMoney;//用户账户余额

    @Column(name = "u_statue")
    private  Integer uStatue;//用户状态

    @Column(name = "u_email")
    private  String uEmail;

}
