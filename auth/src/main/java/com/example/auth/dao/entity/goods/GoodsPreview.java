package com.example.auth.dao.entity.goods;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "goods_image")
@SuppressWarnings("ALL")
public class GoodsPreview {
    public static final String blockedImagePath = "/img/blocked-image.png";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "path_large")
    private String pathLarge;
    @Column(name = "path_small")
    private String pathSmall;
    @Column(name = "cache_photo")
    private String cache;

    private boolean isMovie;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Column(name = "is_main_image")
    private boolean isMainImage = false;
    private boolean blocked = false;

    public void setPathLarge(String pathLarge) {
        if (!blocked) {
            this.pathLarge = pathLarge;
            this.cache = System.currentTimeMillis() + "";
        }
    }

    public void setPathSmall(String pathSmall) {
        if (!blocked) {
            this.pathSmall = pathSmall;
            this.cache = System.currentTimeMillis() + "";
        }
    }

    public GoodsPreview() {
        this.pathSmall = "/img/nopic.png";
        this.pathLarge = "/img/nopic.png";
        this.isMainImage = true;
        this.cache = System.currentTimeMillis() + "";
    }

    public GoodsPreview(String pathLarge, String pathSmall, Goods goods) {
        this.pathSmall = pathSmall;
        this.pathLarge = pathLarge;
        this.goods = goods;
        this.cache = System.currentTimeMillis() + "";
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", pathLarge='" + pathLarge + '\'' +
                ", pathSmall='" + pathSmall + '\'' +
                '}';
    }

    public String getPathLarge() {
        if (this.isBlocked()) {
            return blockedImagePath;
        } else {
            return pathLarge;
        }
    }

    public String getPathSmall() {
        if (this.isBlocked()) {
            return blockedImagePath;
        } else {
            return pathSmall;
        }
    }

}
