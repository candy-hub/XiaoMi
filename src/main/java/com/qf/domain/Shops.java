package com.qf.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "shops")
public class Shops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_pic")
    private String shopPic;

    @Column(name = "shop_bigpic")
    private String shopBigPic;

    @Column(name = "shop_price")
    private float shopPrice;

    @Column(name = "shop_number")
    private Integer shopNumber;//商品库存

    @Column(name = "product_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productTime;//生产日期

    @Column(name = "factory")
    private String factory;//生产厂家

    @Column(name = "shop_repertory")
    private Integer shopRepertory;//商品库存

    @Column(name = "shop_info")
    private String shopInfo;//商品详情描述

    @Column(name = "sk_id")
    private String skId;

}
