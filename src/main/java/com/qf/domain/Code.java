package com.qf.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "code")
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer cId;

    @Column(name = "u_email")
    private String uEmail;

    @Column(name = "c_code")
    private String cCode;

    @Column(name = "c_statue")
    private Integer cStatue;

    @Column(name = "create_time")
    private Date createTime;
}
