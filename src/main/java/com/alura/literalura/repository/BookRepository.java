package com.alura.literalura.repository;

import com.alura.literalura.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    // Método para encontrar livros pelo título
    List<BookEntity> findByTitleContainingIgnoreCase(String title);

    // Método para encontrar livros pelo idioma
    List<BookEntity> findByLanguage(String language);
}