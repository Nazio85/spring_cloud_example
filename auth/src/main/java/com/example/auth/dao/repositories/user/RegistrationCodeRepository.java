package com.example.auth.dao.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.clothes.dao.entity.user.RegistrationCode;
import pro.clothes.dao.entity.user.User;

import java.util.Optional;

public interface RegistrationCodeRepository extends JpaRepository<RegistrationCode, Long> {
    Optional<RegistrationCode> findByUuid(String code);
    Optional<RegistrationCode> findByUser(User user);
}
