package com.api.books.service;

import com.api.books.dto.ApiBookResponse;
import com.api.books.dto.BookData;
import com.api.books.model.Author;
import com.api.books.model.Book;
import com.api.books.repository.AuthorRepository;
import com.api.books.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Client {
    private Scanner scanner = new Scanner(System.in);
    private final String address = "http://gutendex.com/books/";
    APIService apiService = new APIService();
    ConvertInJson convertInJson = new ConvertInJson();
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public Client(BookRepository repository, AuthorRepository authorRepository) {
        this.bookRepository = repository;
        this.authorRepository = authorRepository;
    }

    public void showMenu() {
        int option = -1;
        while (option != 0) {
            String menu = """
                    0 - Sair
                    1 - Buscar livro pelo titulo
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em determinado idioma
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLivrosPorIdiomas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao selecionada invalida.");
            }
        }



    }

    private ApiBookResponse getLivros() {
        String json = apiService.data(address);
        System.out.println(json);
        ApiBookResponse data = convertInJson.getData(json, ApiBookResponse.class);
        return data;
    }

    private void buscarLivroPorTitulo() {
        ApiBookResponse data  = getLivros();
        System.out.println("Digite o nome do livro: ");
        String name = scanner.nextLine();

        Optional<BookData> livroEncontrado = data.results().stream()
                .filter(book -> book.title().equalsIgnoreCase(name))
                .findFirst();

        if(livroEncontrado.isPresent()) {
            System.out.println("Livro encontrado: ");
            System.out.println(livroEncontrado.get());
            Book book = new Book(livroEncontrado.get());
            bookRepository.save(book);
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    private void listarLivros() {
        books = bookRepository.findAll();
        books.forEach(System.out::println);
    }

    private void listarAutores() {
        authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }

    private void listarAutoresVivos() {

    }

    private void listarLivrosPorIdiomas() {
        System.out.println("Digite a sigla do idioma para procuro do livro: ");
        String lang = scanner.nextLine();

    }

}
