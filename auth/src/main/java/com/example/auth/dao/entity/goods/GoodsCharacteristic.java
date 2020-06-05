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
@Table(name = "goods_characteristic")
public class GoodsCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private GoodsStyle style;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private GoodsSize size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private GoodsColor color;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private GoodsMaterial material;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToMany
    @JoinTable(name = "goods__characteristics",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "characteristics_id"))
    private List<GoodsCharacteristicItem> goodsCharacteristics;


    @OneToMany(mappedBy = "characteristic")
    private List<Goods> goods;
}
