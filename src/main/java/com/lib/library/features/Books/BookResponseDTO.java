package com.lib.library.features.Books;

public record BookResponseDTO(
        Long id, String publicId, String title, Integer authorId, String description
) {
    public BookResponseDTO(Book book) {
        this(book.getId(), book.getPublicId(), book.getTitle(), book.getAuthorId(), book.getDescription());
    }
}
