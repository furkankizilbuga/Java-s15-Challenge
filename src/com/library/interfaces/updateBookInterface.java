package com.library.interfaces;

import com.library.books.Book;
import com.library.enums.Status;

import java.time.LocalDate;

public interface updateBookInterface {

    default void updateBook(Book book, long bookId) {
        book.setBookId(bookId);
    }

    default void updateBook(Book book, String title) {
        book.setTitle(title);
    }

    default void updateBook(Book book, double price) {
        book.setPrice(price);
    }

    default void updateBook(Book book, Status status) {
        book.setStatus(status);
    }

    default void updateBook(Book book, int edition) {
        book.setEdition(edition);
    }

    default void updateBook(Book book, LocalDate dateOfPurchase) {
        book.setDateOfPurchase(dateOfPurchase);
    }
}
