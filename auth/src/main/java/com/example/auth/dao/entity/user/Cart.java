package com.example.auth.dao.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany (mappedBy = "cart")
    private List<CartItem> cartItem;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
