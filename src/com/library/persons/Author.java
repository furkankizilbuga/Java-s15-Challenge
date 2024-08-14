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

    public String writtenBooksToString() {
        StringBuilder message = new StringBuilder();
        int index = 0;
        for(Book book : booksWritten) {
            if(book != null) {
                if(index > 0) {
                    message.append(", ");
                }
                message.append(book.getTitle());
            }
            index++;
        }

        return message.toString();
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
                ", Books written: " + writtenBooksToString() +
                '}';
    }
}
