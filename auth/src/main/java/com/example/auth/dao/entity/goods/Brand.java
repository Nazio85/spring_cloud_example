package com.example.auth.dao.entity.goods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods_brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String link;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<GoodsCharacteristic> goodsCharacteristicList;

    public Brand(String name, String link) {
        this.name = name;
        this.link = link;
        this.goodsCharacteristicList = new HashSet<>();
    }
}
