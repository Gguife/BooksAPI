package com.api.books.dto;

public record AuthorData(
        String name,
        int birthYear,
        int deathYear
    ) {
}
