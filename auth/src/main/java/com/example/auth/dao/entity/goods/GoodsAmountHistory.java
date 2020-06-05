package com.example.auth.dao.entity.goods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods_amount_history")
public class GoodsAmountHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private boolean currentAmount;

    @Column(unique = true)
    private BigDecimal amount;

    @Column(name = "create")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;
}
