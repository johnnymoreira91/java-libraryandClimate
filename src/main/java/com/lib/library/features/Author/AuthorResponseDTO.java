package com.lib.library.features.Author;

import java.util.Date;

public record AuthorResponseDTO(
        Long id, String public_id, String name, String countryOfBirth, Date dateOfBirth
) {
    public AuthorResponseDTO(Author author) {
        this(author.getId(), author.getPublicId(), author.getName(), author.getCountryOfBirth(), author.getDateOfBirth());
    }
}