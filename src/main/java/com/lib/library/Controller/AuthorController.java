package com.lib.library.Controller;

import com.lib.library.features.Author.AuthorRepository;
import com.lib.library.features.Author.AuthorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<AuthorResponseDTO> getAll() {
        try {
            List<AuthorResponseDTO> authorList = repository.findAll().stream().map(AuthorResponseDTO:: new).toList();
            return authorList;
        } catch (Exception e) {
            throw e;
        }
    }
}
