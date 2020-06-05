package com.example.auth.dao.entity.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.storage.Storage;
import pro.clothes.dao.entity.user.Address;
import pro.clothes.dao.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "company")
    private List<CompanyUrl> url;
    @OneToMany(mappedBy = "company")
    private List<Address> address;
    private String description;
    @Column(name = "logotype_path")
    private String logotypePath;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private Set<User> users;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private List<Storage> storage;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private ComapnyPhoto comapnyPhoto;

    @Column(name = "sold_goods")
    private Integer soldGoods;


    @OneToMany(mappedBy = "companyStatistic")
    @Column(name = "company_reviews")
    private List<CompanyReviews> companyReviews;

    private BigDecimal rating;
}
