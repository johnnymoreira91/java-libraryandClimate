package com.lib.library.Controller;

import com.lib.library.features.Author.Author;
import com.lib.library.features.Author.AuthorRepository;
import com.lib.library.features.Author.AuthorRequestDTO;
import com.lib.library.features.Author.AuthorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody AuthorRequestDTO data) {
        try {
            Author author = new Author(data);
            return repository.save(author);
        } catch (Exception e) {
            throw new RuntimeException("Error ao crier o author: " + e.getMessage(), e);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<AuthorResponseDTO> getAll() {
        try {
            List<AuthorResponseDTO> authorList = repository.findAll().stream().map(AuthorResponseDTO:: new).toList();
            return authorList;
        } catch (Exception e) {
            throw new RuntimeException("Error to list authors:" + e.getMessage(), e);
        }
    }
}
