package com.alura.literalura.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutendexClient {

    private static final String API_URL = "https://gutendex.com/books/";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public GutendexClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper(); // Inicializando o ObjectMapper
    }

    public BookResponse fetchBooks(String query) throws Exception {
        // Construindo a solicitação
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "?search=" + query))
                .GET()
                .build();

        // Enviando a solicitação e obtendo a resposta
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Desserializando o JSON para um objeto BookResponse
            return objectMapper.readValue(response.body(), BookResponse.class);
        } else {
            throw new RuntimeException("Erro na API: " + response.statusCode());
        }
    }
}
