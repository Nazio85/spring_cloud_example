package com.example.auth.dao.entity.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.goods.GoodsCategory;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company_site")
public class CompanySite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "companySite")
    private List<CompanySiteTemplate> siteTemplates;
    @ManyToMany
    @JoinTable(name = "company_site__goods_category",
            joinColumns = @JoinColumn(name = "goods_category_id"),
            inverseJoinColumns = @JoinColumn(name = "company_site_id"))
    private List<GoodsCategory> goodsCategories;

}
