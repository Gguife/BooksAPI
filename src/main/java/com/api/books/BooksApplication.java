package com.api.books;

import com.api.books.repository.AuthorRepository;
import com.api.books.repository.BookRepository;
import com.api.books.service.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception {
		Client client = new Client(bookRepository, authorRepository);
		client.showMenu();
	}
}
