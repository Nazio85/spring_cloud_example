package com.example.auth.dao.entity.goods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods_characteristic_item")
public class GoodsCharacteristicItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String value;
    private String position;

    @ManyToMany(mappedBy = "goodsCharacteristics")
    private List<GoodsCharacteristic> goods;
}
