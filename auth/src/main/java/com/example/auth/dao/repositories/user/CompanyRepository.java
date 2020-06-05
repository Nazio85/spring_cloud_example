package com.example.auth.dao.repositories.user;

import org.springframework.data.repository.CrudRepository;
import pro.clothes.dao.entity.company.Company;


public interface CompanyRepository extends CrudRepository<Company, Long> {
}
