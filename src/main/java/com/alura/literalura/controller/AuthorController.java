package com.alura.literalura.controller;

import com.alura.literalura.model.AuthorEntity;
import com.alura.literalura.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity authorEntity) {
        return authorService.saveAuthor(authorEntity);
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/alive/{year}")
    public List<AuthorEntity> getAuthorsByYearAlive(@PathVariable int year) {
        return authorService.getAuthorsByYearAlive(year);
    }
}
