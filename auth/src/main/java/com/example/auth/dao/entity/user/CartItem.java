package com.example.auth.dao.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.goods.Goods;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods good;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "cart")
    private Cart cart;
}
