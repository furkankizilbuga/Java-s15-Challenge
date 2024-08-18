package com.library.persons;

import com.library.Library;
import com.library.books.Book;

import java.util.Set;

public class Author extends Person {

    public Author(String name, Set<Book> books) {
        super(name, books);
        setBooks(books);
    }

    public void writeBook(Book book) {
        getBooks().add(book);
        Library.addBookStore(book);
        Library.getAuthors().put(this, getBooks());
    }

    @Override
    public String toString() {
        return "Author{" +
                " Name: " + getName() +
                ", Books written: " + booksToString() +
                '}';
    }
}
