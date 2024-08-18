package com.library.persons;

import com.library.books.Book;

import java.util.Set;

public abstract class Person {

    private String name;
    private Set<Book> books;

    public Person(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String booksToString() {
        StringBuilder message = new StringBuilder();
        int index = 0;
        for(Book book : books) {
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
}
