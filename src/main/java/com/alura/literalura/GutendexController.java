package com.alura.literalura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GutendexController {

    private final GutendexClient gutendexClient;

    public GutendexController() {
        this.gutendexClient = new GutendexClient();
    }

    @GetMapping("/books")
    public BookResponse getBooks(@RequestParam String query) {
        try {
            return gutendexClient.fetchBooks(query);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar livros: " + e.getMessage());
        }
    }
}
