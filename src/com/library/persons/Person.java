package com.library.persons;

import com.library.books.Book;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Person {

    private int id;
    private String name;
    private Set<Book> books;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        this.books = new LinkedHashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
