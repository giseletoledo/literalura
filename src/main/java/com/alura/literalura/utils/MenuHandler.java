package com.alura.literalura.utils;

import com.alura.literalura.model.BookEntity;
import com.alura.literalura.service.AuthorService;
import com.alura.literalura.service.BookService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuHandler {

    private final BookService bookService;
    private final AuthorService authorService;

    public MenuHandler(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int option;

        do {
            System.out.println("Escolha o número de sua opção:");
            System.out.println("1. Buscar livro pelo título");
            System.out.println("2. Listar Livros registrados");
            System.out.println("3. Listar Autores registrados");
            System.out.println("4. Listar autores vivos em um determinado ano");
            System.out.println("5. Listar Livros em um determinado idioma");
            System.out.println("6. Buscar e salvar livros da API");
            System.out.println("0. Sair");

            option = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (option) {
                case 1:
                    System.out.print("Insira o título do livro: ");
                    String title = scanner.nextLine();
                    List<BookEntity> booksByTitle = bookService.getBooksByTitle(title);
                    if (booksByTitle.isEmpty()) {
                        System.out.println("Nenhum livro encontrado com o título: " + title);
                    } else {
                        booksByTitle.forEach(book -> System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Idioma: " + book.getLanguage()));
                    }
                    break;
                case 2:
                    bookService.getAllBooks().forEach(book -> System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Idioma: " + book.getLanguage()));
                    break;
                case 3:
                    authorService.getAllAuthors().forEach(author -> System.out.println("ID: " + author.getId() + ", Nome: " + author.getName()));
                    break;
                case 4:
                    System.out.print("Insira o ano: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    authorService.getAuthorsByYearAlive(year).forEach(author -> System.out.println("ID: " + author.getId() + ", Nome: " + author.getName()));
                    break;
                case 5:
                    System.out.print("Insira o idioma (es, en, fr, pt): ");
                    String language = scanner.nextLine();
                    bookService.getBooksByLanguage(language).forEach(book -> System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Idioma: " + book.getLanguage()));
                    break;
                case 6:
                    System.out.print("Insira o termo de busca: ");
                    String searchTerm = scanner.nextLine();
                    bookService.fetchAndSaveBooks(searchTerm);
                    System.out.println("Livros buscados e salvos com sucesso!");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}