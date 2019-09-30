package com.qf.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Integer oId;

    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_number")
    private Integer shopNumber;

    @Column(name = "shop_price")
    private Float shopPrice;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_tell")
    private Number userTell;

    @Column(name = "user_address")
    private String user_address;

    @Column(name = "o_price")
    private Float oPrice;

}
