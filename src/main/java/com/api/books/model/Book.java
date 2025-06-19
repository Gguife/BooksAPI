package com.api.books.model;

import com.api.books.dto.AuthorData;
import com.api.books.dto.BookData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String title;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> author;
    @ElementCollection
    private List<String> language;


    public Book() {}

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.author = bookData.authors().stream()
                .map(authorData -> new Author(authorData, this))
                .toList();
        this.language = bookData.languages();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public List<String> getLanguage() {
        return language;
    }
}
