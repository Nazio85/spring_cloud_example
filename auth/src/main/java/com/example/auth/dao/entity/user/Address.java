package com.example.auth.dao.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.company.Company;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String url;
    private String city;
    private String street;
    private String building;
    private String number;

    @OneToMany(mappedBy = "address")
    private List<Phone> phone;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
