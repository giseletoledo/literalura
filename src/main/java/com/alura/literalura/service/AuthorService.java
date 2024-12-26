package com.alura.literalura.service;

import com.alura.literalura.model.AuthorEntity;
import com.alura.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Metodo para salvar um autor
    public AuthorEntity saveAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    // Metodo para listar todos os autores
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Metodo para listar autores vivos em um determinado ano
    public List<AuthorEntity> getAuthorsByYearAlive(int targetYear) {
        List<AuthorEntity> authors = authorRepository.findByYearOfBirthLessThanEqualAndYearOfDeathGreaterThanEqual(targetYear, targetYear);

        if (authors.isEmpty()) {
            System.out.println("Nenhum autor encontrado vivo no ano " + targetYear);
        }

        return authors;
    }

    // Metodo para buscar um autor pelo ID
    public AuthorEntity getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado com o ID: " + id));
    }

    // Metodo para atualizar um autor
    public AuthorEntity updateAuthor(Long id, AuthorEntity authorDetails) {
        AuthorEntity existingAuthor = getAuthorById(id);
        existingAuthor.setName(authorDetails.getName());
        existingAuthor.setYearOfBirth(authorDetails.getYearOfBirth());
        existingAuthor.setYearOfDeath(authorDetails.getYearOfDeath());
        return authorRepository.save(existingAuthor);
    }

    // Metodo para deletar um autor
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}