package com.example.auth.dao.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pro.clothes.dao.entity.goods.Goods;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "user_statistic")
@Getter
@Setter
@EqualsAndHashCode
public class UserStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_account")
    private LocalDate createAccount;

    @OneToOne
    private User user;


    @ManyToMany
    @JoinTable(name = "goods__last_viewed_goods",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "last_viewed_goods_id"))
    private List<Goods> last_viewed_goods;

    public UserStatistic() {
        this.createAccount = LocalDate.now();
    }
}
