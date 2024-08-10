package com.library.persons;

import com.library.books.Book;

import java.util.Set;

public class Author extends Person {

    public Author(String name, Set<Book> books) {
        super(name, books);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + super.getName() + '\'' +
                ", booksWritten=" + booksToString() +
                '}';
    }
}
