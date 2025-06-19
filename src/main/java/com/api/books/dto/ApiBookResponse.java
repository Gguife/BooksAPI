package com.api.books.dto;

import java.util.List;

public record ApiBookResponse(
        int count,
        String next,
        String previous,
        List<BookData> results
    ) {
}
