package com.example.auth.dao.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.clothes.dao.entity.user.RegistrationCode;
import pro.clothes.dao.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByRegistrationCode(RegistrationCode registrationCode);
    List<User> findAllByEnabled(Boolean isEnabled);
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmailOrUsername(String email, String name);
    boolean existsByUsername(String name);
    boolean existsByEmail(String email);
}
