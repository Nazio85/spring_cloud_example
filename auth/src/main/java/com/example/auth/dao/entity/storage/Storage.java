package com.example.auth.dao.entity.storage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.company.Company;
import pro.clothes.dao.entity.goods.Goods;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "storage")
    private List<Goods> goods;

    @Column(name = "is_history_storage")
    private boolean isHistoryStorage;
}
