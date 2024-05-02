package com.actividad4_pruebas;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear repositorios
        InMemoryBookRepository bookRepository = new InMemoryBookRepository();
        InMemoryUserRepository userRepository = new InMemoryUserRepository();

        // Agregar algunos libros y usuarios
        bookRepository.addBook(new Book(1, "La vida es sueño", "Pedro Calderón de la Barca"));
        bookRepository.addBook(new Book(2, "Don Juan Tenorio", "José Zorrilla"));
        bookRepository.addBook(new Book(3, "Los trabajos de Persiles y Sigismunda", "Miguel de Cervantes"));
        bookRepository.addBook(new Book(4, "El lazarillo de Tormes", "Autor anónimo"));
        bookRepository.addBook(new Book(5, "La Celestina", "Fernando de Rojas"));

        userRepository.addUser(new User(1, "user1", "password", false));
        userRepository.addUser(new User(2, "admin", "admin123", true));

        // Crear servicio de préstamos
        SimpleLoanService loanService = new SimpleLoanService(bookRepository, userRepository);

        // Realizar algunas operaciones de préstamo y devolución
        loanService.borrowBook(1, 1);
        loanService.borrowBook(1, 2);
        loanService.returnBook(2, 3);

        // Obtener préstamos de un usuario y un libro
        List<Loan> userLoans = loanService.getLoansByUser(1);
        List<Loan> bookLoans = loanService.getLoansByBook(1);

        // Imprimir los préstamos
        System.out.println("Préstamos del usuario 1:");
        for (Loan loan : userLoans) {

            Book book = bookRepository.getBookById(loan.getId());
            // System.out.println(book.getTitle());
            System.out.println("  - Libro: [" + loan.getBookId() + "] " + book.getTitle() + ", Fecha de préstamo: "
                    + loan.getLoanDate());
        }

        System.out.println("Préstamos del libro 1:");
        for (Loan loan : bookLoans) {
            User usr = userRepository.getUserById(loan.getUserId());
            System.out.println("  - Usuario: [" + loan.getUserId() + "] " + usr.getUsername() + ", Fecha de préstamo: "
                    + loan.getLoanDate());
        }
    }
}