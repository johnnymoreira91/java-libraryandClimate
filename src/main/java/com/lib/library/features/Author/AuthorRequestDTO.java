package com.lib.library.features.Author;

import java.util.Date;

public record AuthorRequestDTO(String name, String countryOfBirth, Date dateOfBirth) {
}
