package com.qf.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shop_kinds")
public class ShopKinds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private Integer skId;

    @Column(name = "sk_name")
    private String skName;//商品类别名

}
