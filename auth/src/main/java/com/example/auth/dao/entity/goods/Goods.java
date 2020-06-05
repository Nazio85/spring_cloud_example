package com.example.auth.dao.entity.goods;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.storage.Storage;
import pro.clothes.dao.entity.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods")
public class Goods {
    public static final String DATE_CREATE = "dateCreate";
    public static final String VIEWS = "views";
    public static final String FAVORITE = "favoriteSize";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String goodsArticle;
    private String title;
    @Lob
    private String description;
    private String status;
    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Column(name = "date_update")
    private LocalDateTime dateUpdate;

    @Column(name = "date_finished")
    private LocalDateTime dateFinished;

    @Column(name = "amount")
    private Integer amount;

    @OneToMany(mappedBy = "goods")
    @Column(name = "amount_history")
    private List<GoodsAmountHistory> amountHistory;

    @OneToOne
    @JoinColumn(name = "goods_discount_id")
    private GoodsDiscount discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "characteristic")
    private GoodsCharacteristic characteristic;

    private Long count;

    private Long views;

    @Column(unique = true)
    private String link;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private GoodsCategory category;

    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL)
    private List<GoodsPreview> images;


    @ManyToMany
    @JoinTable(name = "goods__goods_tag",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_tag_id"))
    private List<GoodsTag> tagList;

    @ManyToMany
    @JoinTable(name = "goods__like",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> favorite;

    @Column(name = "favorite_size")
    private Integer favoriteSize;


    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL)
    private List<GoodsComplain> complain;

    @OneToMany(mappedBy = "goods")
    private List<GoodsComment> comments;


    public Goods(Goods goods, String link, Storage storages) {
        this.title = goods.getTitle();
        this.link = link;
        this.storage = storages;
        this.category = goods.category;
        this.images = new ArrayList<>();
        this.tagList = goods.getTagList();
        this.favoriteSize = 0;

        if (Objects.isNull(goods.getDescription()) || goods.getDescription().isEmpty()) {
            this.description = "<p></p>";
        } else {
            this.description = goods.getDescription();
        }

    }


    @Override
    public String toString() {
        return "Interior{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", category=" + category +
                ", images=" + images +
                ", furniture=" + tagList +
                ", like=" + favorite +
                '}';
    }



}
