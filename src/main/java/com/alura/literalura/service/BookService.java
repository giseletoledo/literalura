package com.alura.literalura.service;

import com.alura.literalura.api.GutendexClient;
import com.alura.literalura.api.BookResponse;
import com.alura.literalura.model.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final GutendexClient client;
    private final List<BookEntity> registeredBooks;

    public BookService(GutendexClient client) {
        this.client = client;
        this.registeredBooks = new ArrayList<>();
    }

    public void searchBookByTitle(String title) {
        try {
            BookResponse response = client.fetchBooks(title);
            List<BookEntity> books = response.getResults();

            if (books.isEmpty()) {
                System.out.println("Nenhum livro encontrado com o título fornecido.");
            } else {
                BookEntity firstBook = books.get(0);
                registeredBooks.add(firstBook);
                System.out.println("Livro encontrado e registrado:");
                System.out.println(firstBook);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar livro: " + e.getMessage());
        }
    }

    public void listRegisteredBooks() {
        if (registeredBooks.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            System.out.println("=== Livros registrados ===");
            registeredBooks.forEach(System.out::println);
        }
    }

    public void listBooksByLanguage(String language) {
        List<BookEntity> filteredBooks = registeredBooks.stream()
                .filter(book -> book.getAuthors().get(0).getName().equalsIgnoreCase(language))
                .toList();

        if (filteredBooks.isEmpty()) {
            System.out.println("Não existem livros nesse idioma no banco de dados.");
        } else {
            System.out.println("=== Livros no idioma " + language + " ===");
            filteredBooks.forEach(System.out::println);
        }
    }
}

