package com.example.auth.dao.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
@Table(name = "registration_code")
public class RegistrationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uuid;
    private boolean active;
    private String operation;
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
    @Column(name = "count_try", nullable = false)
    private int countTry;

    @Column(name = "operation_value")
    private String operationValue;

    @OneToOne(mappedBy = "registrationCode")
    private User user;

    public RegistrationCode() {
        this.uuid = UUID.randomUUID().toString();
        active = true;
        countTry = 0;
    }


    public void setActive(boolean active) {
        if (!active) countTry = 0;
        this.active = active;
    }
}
