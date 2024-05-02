package com.actividad4_pruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Servicio de préstamos
public class SimpleLoanService {
    private InMemoryBookRepository bookRepository;
    private InMemoryUserRepository userRepository;
    private List<Loan> loans = new ArrayList<>();
    private int nextId = 1;

    public SimpleLoanService(InMemoryBookRepository bookRepository, InMemoryUserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void borrowBook(int userId, int bookId) {
        Book book = bookRepository.getBookById(bookId);
        User user = userRepository.getUserById(userId);
        if (book != null && user != null && book.isAvailable()) {
            book.setAvailable(false);
            Loan loan = new Loan(nextId++, userId, bookId);
            loans.add(loan);
        }
    }

    public void returnBook(int userId, int bookId) {
        for (Loan loan : loans) {
            if (loan.getUserId() == userId && loan.getBookId() == bookId && loan.getReturnDate() == null) {
                loan.setReturnDate(LocalDate.now());
                Book book = bookRepository.getBookById(bookId);
                if (book != null) {
                    book.setAvailable(true);
                }
            }
        }
    }

    public List<Loan> getLoansByUser(int userId) {
        List<Loan> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getUserId() == userId) {
                userLoans.add(loan);
            }
        }
        return userLoans;
    }

    public List<Loan> getLoansByBook(int bookId) {
        List<Loan> bookLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getBookId() == bookId) {
                bookLoans.add(loan);
            }
        }
        return bookLoans;
    }
}
