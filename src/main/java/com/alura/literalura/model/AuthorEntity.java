package com.alura.literalura.model;

import com.alura.literalura.api.AuthorData;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer yearOfBirth;

    private Integer yearOfDeath;

    @ManyToMany(mappedBy = "authors")
    private List<BookEntity> books;

    // Construtores
    public AuthorEntity() {
    }

    public AuthorEntity(AuthorData authorData) {
        this.name = authorData.name();
        this.yearOfBirth = authorData.yearOfBirth();
        this.yearOfDeath = authorData.yearOfDeath();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(Integer yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", yearOfDeath=" + yearOfDeath +
                '}';
    }
}