package com.library.persons;

import com.library.books.Book;

import java.util.Set;

public class Author extends Person {

    private Set<Book> booksWritten;

    public Author(String name, Set<Book> books, Set<Book> booksWritten) {
        super(name, books);
        this.booksWritten = booksWritten;
    }

    public Set<Book> getBooksWritten() {
        return booksWritten;
    }

    public void writeBook(Book book) {
        booksWritten.add(book);
    }

    @Override
    public Set<Book> getBooksInPossession() {
        return super.getBooksInPossession();
    }

    @Override
    public String toString() {
        return "Author{" +
                " Name: " + getName() +
                ", Books in possession: " + getBooksInPossession() +
                ", Books written: " + booksWritten +
                '}';
    }
}
