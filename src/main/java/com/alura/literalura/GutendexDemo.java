package com.alura.literalura;

public class GutendexDemo {

    public static void main(String[] args) {
        // Instanciar o cliente
        GutendexClient client = new GutendexClient();

        try {
            // Fazer a requisição à API
            BookResponse bookResponse = client.fetchBooks("shakespeare");

            // Exibir os resultados no console
            System.out.println("=== Livros encontrados ===");
            bookResponse.getResults().forEach(book -> {
                System.out.println("Título: " + book.getTitle());
                book.getAuthors().forEach(author ->
                        System.out.println("Autor: " + author.getName())
                );
                System.out.println("-------------------------");
            });
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

