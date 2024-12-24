package com.alura.literalura.api;

import com.alura.literalura.model.BookEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {
    private List<BookEntity> results;

    public List<BookEntity> getResults() {
        return results;
    }

    public void setResults(List<BookEntity> results) {
        this.results = results;
    }
}

