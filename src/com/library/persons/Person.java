package com.library.persons;

import com.library.books.Book;

import java.util.Set;

public abstract class Person {

    private String name;
    private Set<Book> booksInPossession;

    public Person(String name, Set<Book> booksInPossession) {
        this.name = name;
        this.booksInPossession = booksInPossession;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooksInPossession() {
        return booksInPossession;
    }

    public void setBooksInPossession(Set<Book> books) {
        this.booksInPossession = books;
    }

    public void addBookInPossession(Book book) {
        booksInPossession.add(book);
    }

    public String booksToString() {
        String message = "";
        for(Book book : booksInPossession) {
            if(book != null) {
                message += book.getTitle();
            }
        }
        return message;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", booksInPossession=" + booksInPossession +
                '}';
    }
}
