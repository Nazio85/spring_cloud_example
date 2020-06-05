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
@Table(name = "goods_size")
public class GoodsSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "size", cascade = CascadeType.PERSIST)
    private Set<GoodsCharacteristic> goodsCharacteristicList;


    public GoodsSize(String name, String link) {
        this.name = name;
        this.goodsCharacteristicList = new HashSet<>();
    }

    @Override
    public String toString() {
        return "InteriorStyle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
