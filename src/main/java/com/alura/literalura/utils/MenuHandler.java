package com.alura.literalura.utils;

import com.alura.literalura.service.AuthorService;
import com.alura.literalura.service.BookService;

import java.util.Scanner;

public class MenuHandler {

    private final BookService bookService;
    private final AuthorService authorService;

    public MenuHandler(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Escolha o número de sua opção:");
            System.out.println("1. Buscar livro pelo título");
            System.out.println("2. Listar Livros registrados");
            System.out.println("3. Listar Autores registrados");
            System.out.println("4. Listar autores vivos em um determinado ano");
            System.out.println("5. Listar Livros em um determinado idioma");
            System.out.println("0. Sair");

            option = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (option) {
                case 1:
                    System.out.print("Insira o título do livro: ");
                    String title = scanner.nextLine();
                    bookService.searchBookByTitle(title);
                    break;
                case 2:
                    bookService.listRegisteredBooks();
                    break;
                case 3:
                    authorService.listRegisteredAuthors();
                    break;
                case 4:
                    System.out.print("Insira o ano: ");
                    int year = scanner.nextInt();
                    authorService.listLivingAuthorsByYear(year);
                    break;
                case 5:
                    System.out.print("Insira o idioma (es, en, fr, pt): ");
                    String language = scanner.nextLine();
                    bookService.listBooksByLanguage(language);
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