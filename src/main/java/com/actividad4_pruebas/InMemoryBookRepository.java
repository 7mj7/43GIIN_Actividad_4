package com.actividad4_pruebas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Repositorio de libros
public class InMemoryBookRepository {
    private Map<Integer, Book> books = new HashMap<>();
    private int nextId = 1;

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
    }

    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }

    public void deleteBook(int id) {
        books.remove(id);
    }
}
