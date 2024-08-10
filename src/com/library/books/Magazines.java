package com.library.books;

import com.library.persons.Author;
import com.library.persons.Person;

import java.util.Set;

public class Magazines extends Book {

    public Magazines(long bookId, Set<Person> authors, String title, double price, double edition) {
        super(bookId, authors, title, price, edition);
    }
}
