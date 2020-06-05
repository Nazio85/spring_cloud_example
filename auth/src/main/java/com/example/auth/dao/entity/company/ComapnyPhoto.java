package com.example.auth.dao.entity.company;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@Table(name = "company_photo")
public class ComapnyPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "path_small")
    private String pathSmall;
    @Column(name = "path_large")
    private String pathLarge;
    @Column(name = "cache_photo")
    private String cache;

    @OneToOne
    @JoinColumn(name = "comapny_photo")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "company_site_template")
    private CompanySiteTemplate siteTemplate;

    public ComapnyPhoto() {
        this.pathSmall = "/img/nopic.png";
        this.pathLarge = "/img/nopic.png";
        this.cache = System.currentTimeMillis() + "";
    }

    public void setPathSmall(String pathSmall) {
        this.pathSmall = pathSmall;
        this.cache = System.currentTimeMillis() + "";
    }

    public void setPathLarge(String pathLarge) {
        this.pathLarge = pathLarge;
        this.cache = System.currentTimeMillis() + "";
    }
}
