package com.api.books.model;

import com.api.books.dto.AuthorData;
import com.api.books.dto.BookData;
import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int birthYear;
    private int deathYear;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Author() {}

    public Author(AuthorData authorData, Book book) {
        this.name = authorData.name();
        this.birthYear = authorData.birthYear();
        this.deathYear = authorData.deathYear();
        this.book = book;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public Book getBook() {
        return book;
    }
}
