package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookEntity {
    private String title;
    private List<AuthorEntity> authorEntities;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorEntity> getAuthors() {
        return authorEntities;
    }

    public void setAuthors(List<AuthorEntity> authorEntities) {
        this.authorEntities = authorEntities;
    }

    @Override
    public String toString() {
        String authors = authorEntities == null ? "Nenhum autor registrado" :
                authorEntities.stream()
                        .map(AuthorEntity::toString)
                        .collect(Collectors.joining(", "));

        return "Título: " + title + "\n" + authors + "\n-------------------------";
    }
}


