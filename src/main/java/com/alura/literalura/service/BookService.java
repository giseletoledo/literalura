package com.alura.literalura.service;

import com.alura.literalura.api.BookData;
import com.alura.literalura.api.BookResponse;
import com.alura.literalura.api.GutendexClient;
import com.alura.literalura.model.AuthorEntity;
import com.alura.literalura.model.BookEntity;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GutendexClient gutendexClient;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GutendexClient gutendexClient) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.gutendexClient = gutendexClient;
    }

    public List<BookEntity> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookEntity> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    @Transactional
    public BookEntity saveBook(BookEntity bookEntity) {
        // Processar autores manualmente (se necessário)
        List<AuthorEntity> managedAuthors = bookEntity.getAuthors().stream()
                .map(author -> authorRepository.findByName(author.getName())
                        .orElseGet(() -> authorRepository.save(author)))
                .collect(Collectors.toList());

        bookEntity.setAuthors(managedAuthors);
        BookEntity savedBook = bookRepository.save(bookEntity);
        System.out.println("Livro salvo: " + savedBook);
        return savedBook;
    }

    @Transactional
    public void fetchAndSaveBooks(String query) {
        try {
            // Buscar livros na API
            BookResponse response = gutendexClient.fetchBooks(query);
            List<BookData> books = response.getResults();

            books.forEach(bookData -> {
                Optional<BookEntity> existingBook = bookRepository.findByTitleContainingIgnoreCase(bookData.title()).stream().findFirst();
                if (existingBook.isEmpty()) {
                    // Processar autores
                    List<AuthorEntity> authors = bookData.authors().stream()
                            .map(authorData -> authorRepository.findByName(authorData.name())
                                    .orElseGet(() -> authorRepository.save(new AuthorEntity(authorData))))
                            .collect(Collectors.toList());

                    // Salvar livro com autores
                    BookEntity book = new BookEntity(bookData);
                    book.setAuthors(authors);
                    BookEntity savedBook = bookRepository.save(book);
                    System.out.println("Livro salvo: " + savedBook);
                } else {
                    System.out.println("Livro já existe: " + existingBook.get());
                }
            });

            System.out.println("Livros salvos com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar livros: " + e.getMessage(), e);
        }
    }
}