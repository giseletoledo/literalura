package com.alura.literalura.controller;

import com.alura.literalura.model.BookEntity;
import com.alura.literalura.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Injeção de dependência via construtor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Cria um novo livro
    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity bookEntity) {
        BookEntity savedBook = bookService.saveBook(bookEntity);
        return ResponseEntity.ok(savedBook);
    }

    // Retorna todos os livros
    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Retorna livros pelo título
    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookEntity>> getBooksByTitle(@PathVariable String title) {
        List<BookEntity> books = bookService.getBooksByTitle(title);
        return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
    }

    // Retorna livros pelo idioma
    @GetMapping("/language/{language}")
    public ResponseEntity<List<BookEntity>> getBooksByLanguage(@PathVariable String language) {
        List<BookEntity> books = bookService.getBooksByLanguage(language);
        return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
    }
}
