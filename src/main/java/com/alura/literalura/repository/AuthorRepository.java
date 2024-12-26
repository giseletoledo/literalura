package com.alura.literalura.repository;

import com.alura.literalura.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByName(String name);
    List<AuthorEntity> findByYearOfBirthLessThanEqualAndYearOfDeathGreaterThanEqual(Integer birthYear, Integer deathYear);
}