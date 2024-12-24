package com.alura.literalura;

import com.alura.literalura.api.BookResponse;
import com.alura.literalura.api.GutendexClient;

public class GutendexDemo {

    public static void main(String[] args) {
        // Instanciar o cliente
        GutendexClient client = new GutendexClient();

        try {
            // Fazer a requisição à API
            BookResponse bookResponse = client.fetchBooks("shakespeare");

            // Exibir os resultados no console
            System.out.println("=== Livros encontrados ===");
            bookResponse.getResults().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
