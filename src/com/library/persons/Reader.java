package com.library.persons;

import com.library.books.Book;

import java.util.Set;

public class Reader extends Person {

    public Reader(String name, Set<Book> books) {
        super(name, books);
    }

    public void purchaseBook(Book book) {
        this.getBooks().add(book);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + super.getName() + '\'' +
                ", booksBorrowed=" + booksToString() +
                '}';
    }

}
