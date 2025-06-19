package com.api.books.dto;

import java.util.List;

public record BookData(
        String title,
        List<AuthorData> authors,
        List<String> languages
    ) {
}
