package com.example.auth.dao.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.clothes.dao.entity.user.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String name);
}
