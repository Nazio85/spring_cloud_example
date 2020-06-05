package com.example.auth.dao.entity.goods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods_discount")
public class GoodsDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String percent;
    private LocalDateTime dateStart;
    private LocalDateTime dateFinished;


    @OneToOne (mappedBy = "discount")
    private Goods goods;
}
