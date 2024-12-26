package com.alura.literalura;

import com.alura.literalura.utils.MenuHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação para indicar que é uma aplicação Spring Boot
@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    private final MenuHandler menuHandler;

    // Injeção de dependência do MenuHandler via construtor
    public MainApplication(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public static void main(String[] args) {
        // Inicializa a aplicação Spring Boot
        SpringApplication.run(MainApplication.class, args);
    }

    // Método executado após a inicialização do contexto do Spring Boot
    @Override
    public void run(String... args) {
        // Mostra o menu ao usuario
        menuHandler.showMenu();
    }
}