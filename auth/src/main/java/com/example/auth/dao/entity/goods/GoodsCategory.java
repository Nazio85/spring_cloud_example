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
@Table(name = "goods_category")
public class GoodsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String title;
    @Column(name = "header_text")
    private String headerText;
    @Column(unique = true)
    private String link;
    @Lob
    private String description;
    private int position;
    @Column(name = "top_slide_image")
    private String topSlideImage;
    @Column(name = "sidebar_image")
    private String sidebarImage;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Goods> goods;


    public GoodsCategory(String title, String link, String description, int position) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.position = position;
    }

}
