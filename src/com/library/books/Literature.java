package com.library.books;

import com.library.persons.Person;

import java.util.Set;

public class Literature extends Book {

    public Literature(long bookId, Set<Person> authors, String title, double price, int edition) {
        super(bookId, authors, title, price, edition);
    }
}
