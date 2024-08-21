package com.library.persons;

import com.library.Library;
import com.library.books.Book;

public class Author extends Person {

    public Author(int id, String name) {
        super(id, name);
    }

    public void writeBook(Book book) {
        getBooks().add(book);
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
