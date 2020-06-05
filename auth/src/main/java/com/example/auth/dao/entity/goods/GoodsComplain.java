package com.example.auth.dao.entity.goods;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.clothes.dao.entity.user.User;

import javax.persistence.*;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods_complain")
@EqualsAndHashCode
public class GoodsComplain {
    public static final String DATE_CREATE = "dateCreate";
    public static final String VIEWS = "views";
    public static final String FAVORITE = "favoriteSize";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("Recieved complain message! \n");
        message.append("Interior with link: \n");
        message.append("https://nice-decor.ru/").append(goods.getLink()).append("\n");
        message.append("Reason: ").append(this.reason).append("\n");
        if (Objects.nonNull(this.description)) {
            message.append("Description: ").append(this.description).append("\n");
        }
        return message.toString();
    }
}
