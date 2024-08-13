package com.library.books;

import com.library.persons.Author;
import com.library.persons.Person;

import java.util.Set;

public class Journals extends Book {

    public Journals(long bookId, Set<Person> authors, String title, double price, int edition) {
        super(bookId, authors, title, price, edition);
    }
}
