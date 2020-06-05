package com.example.auth.dao.entity.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company_reviews")
public class CompanyReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private Boolean isPositive;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyStatistic;
}
