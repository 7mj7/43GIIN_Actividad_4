package com.actividad4_pruebas;

import java.time.LocalDate;

// Clase para representar un préstamo
public class Loan {
    private int id;
    private int userId;
    private int bookId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(int id, int userId, int bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = LocalDate.now();
        this.returnDate = null;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}