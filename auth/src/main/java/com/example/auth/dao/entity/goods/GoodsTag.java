package com.example.auth.dao.entity.goods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods_tag")
public class GoodsTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String link;

    @ManyToMany(mappedBy = "tagList")
    private List<Goods> goods;


    public GoodsTag(String name, String link) {
        this.name = name;
        this.link = link;
        goods = new ArrayList<>();
    }


}
