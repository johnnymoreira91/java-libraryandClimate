package com.lib.library.Controller;

import com.lib.library.features.Author.Author;
import com.lib.library.features.Author.AuthorResponseDTO;
import com.lib.library.features.Books.Book;
import com.lib.library.features.Books.BookRepository;
import com.lib.library.features.Books.BookRequestDTO;
import com.lib.library.features.Books.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody BookRequestDTO data) {
        try {
            Book book = new Book(data);
            return repository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Error to create a new book: " + e.getMessage(), e);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<BookResponseDTO> getAll() {
        try {
            return repository.findAll().stream().map(BookResponseDTO:: new).toList();
        } catch (Exception e) {
            throw new RuntimeException("Error to list book:" + e.getMessage(), e);
        }
    }
}
