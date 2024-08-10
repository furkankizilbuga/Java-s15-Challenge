package com.library;

import com.library.books.Book;
import com.library.persons.Reader;

import java.util.Set;

public class Library {

    private Set<Book> books;
    private Set<Reader> readers;

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void addBookStore(Book book) {
        books.add(book);
    }

    public void lendBook(Reader reader, Book book) {
        reader.addBook(book);
    }


}
