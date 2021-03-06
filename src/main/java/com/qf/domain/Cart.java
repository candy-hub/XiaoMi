package com.qf.domain;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer cId;   //若在页面中用cId取不到值时，可用cid试一试

    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_price")
    private BigDecimal shopPrice;

    @Column(name = "shop_pic")
    private String shopPic;

    @Column(name = "shop_count")
    private Integer shopCount;

    @Column(name = "shop_total")
    private BigDecimal shopTotal;

    @Column(name = "shop_factory")
    private String shopFactory;


}
