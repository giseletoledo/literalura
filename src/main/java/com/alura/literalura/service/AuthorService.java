package com.alura.literalura.service;

import com.alura.literalura.model.AuthorEntity;
import com.alura.literalura.model.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private final List<AuthorEntity> registeredAuthors;

    public AuthorService() {
        this.registeredAuthors = new ArrayList<>();
    }

    public void listRegisteredAuthors() {
        if (registeredAuthors.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            System.out.println("=== Autores registrados ===");
            registeredAuthors.forEach(System.out::println);
        }
    }

    public void listLivingAuthorsByYear(int year) {
        List<AuthorEntity> livingAuthors = registeredAuthors.stream()
                .filter(author -> author.getYearOfDeath() == null || author.getYearOfDeath() > year)
                .filter(author -> author.getYearOfBirth() <= year)
                .toList();

        if (livingAuthors.isEmpty()) {
            System.out.println("Nenhum autor vivo encontrado no ano " + year + ".");
        } else {
            System.out.println("=== Autores vivos no ano " + year + " ===");
            livingAuthors.forEach(System.out::println);
        }
    }

    public void registerAuthorsFromBook(BookEntity book) {
        if (book.getAuthors() != null && !book.getAuthors().isEmpty()) {
            book.getAuthors().forEach(author -> {
                if (!registeredAuthors.contains(author)) {
                    registeredAuthors.add(author);
                }
            });
        }
    }
}