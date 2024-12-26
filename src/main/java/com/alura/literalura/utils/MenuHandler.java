package com.alura.literalura.utils;

import com.alura.literalura.model.AuthorEntity;
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
            printMenuOptions();
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (option) {
                case 1:
                    searchBookByTitle(scanner);
                    break;
                case 2:
                    listAllBooks();
                    break;
                case 3:
                    listAllAuthors();
                    break;
                case 4:
                    listAuthorsAliveInYear(scanner);
                    break;
                case 5:
                    listBooksByLanguage(scanner);
                    break;
                case 6:
                    fetchAndSaveBooks(scanner);
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

    private void printMenuOptions() {
        System.out.println("Escolha o número de sua opção:");
        System.out.println("1. Buscar livro pelo título");
        System.out.println("2. Listar Livros registrados");
        System.out.println("3. Listar Autores registrados");
        System.out.println("4. Listar autores vivos em um determinado ano");
        System.out.println("5. Listar Livros em um determinado idioma");
        System.out.println("6. Buscar e salvar livros da API");
        System.out.println("0. Sair");
    }

    private void searchBookByTitle(Scanner scanner) {
        System.out.print("Insira o título do livro: ");
        String title = scanner.nextLine();
        List<BookEntity> books = bookService.getBooksByTitle(title);
        showBooks(books, "Nenhum livro encontrado com o título: " + title);
    }

    private void listAllBooks() {
        List<BookEntity> books = bookService.getAllBooks();
        showBooks(books, "Nenhum livro registrado.");
    }

    private void listBooksByLanguage(Scanner scanner) {
        System.out.print("Insira o idioma (es, en, fr, pt): ");
        String language = scanner.nextLine();
        List<BookEntity> books = bookService.getBooksByLanguage(language);
        showBooks(books, "Nenhum livro encontrado no idioma: " + language);
    }

    private void listAllAuthors() {
        List<AuthorEntity> authors = authorService.getAllAuthors();
        showAuthors(authors, "Nenhum autor registrado.");
    }

    private void listAuthorsAliveInYear(Scanner scanner) {
        System.out.print("Insira o ano: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        List<AuthorEntity> authors = authorService.getAuthorsByYearAlive(year);
        showAuthors(authors, "Nenhum autor encontrado vivo no ano " + year);
    }

    private void fetchAndSaveBooks(Scanner scanner) {
        System.out.print("Insira o termo de busca: ");
        String searchTerm = scanner.nextLine();
        bookService.fetchAndSaveBooks(searchTerm);
        System.out.println("Livros buscados e salvos com sucesso!");
    }

    private void showBooks(List<BookEntity> books, String emptyMessage) {
        if (books.isEmpty()) {
            System.out.println(emptyMessage);
        } else {
            books.forEach(book ->
                    System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Idioma: " + book.getLanguage()));
        }
    }

    private void showAuthors(List<AuthorEntity> authors, String emptyMessage) {
        if (authors.isEmpty()) {
            System.out.println(emptyMessage);
        } else {
            authors.forEach(author ->
                    System.out.println("ID: " + author.getId() + ", Nome: " + author.getName()));
        }
    }
}