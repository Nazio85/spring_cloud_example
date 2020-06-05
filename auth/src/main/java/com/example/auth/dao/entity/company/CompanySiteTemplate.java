package com.example.auth.dao.entity.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.goods.Goods;
import pro.clothes.dao.entity.goods.GoodsCategory;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company_site_template")
public class CompanySiteTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String template;

    @ManyToMany
    @JoinTable(name = "company_site_template__goods_category",
            joinColumns = @JoinColumn(name = "goods_category_id"),
            inverseJoinColumns = @JoinColumn(name = "company_site_template_id"))
    private List<GoodsCategory> goodsCategories;


    @ManyToMany
    @JoinTable(name = "company_site_template__goods",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "company_site_template_id"))
    private List<Goods> goodsList;
    private Integer position;
    private String target;
    private String title;
    private String description;

    @OneToMany(mappedBy = "siteTemplate")
    private List<ComapnyPhoto> templatePhotos;

    @ManyToOne
    @JoinColumn(name = "company_site_id")
    private CompanySite companySite;
}
