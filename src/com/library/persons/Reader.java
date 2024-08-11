package com.library.persons;

import com.library.Library;
import com.library.books.Book;

import java.util.Set;

public class Reader extends Person {

    public Reader(String name, Set<Book> books) {
        super(name, books);
    }

    public void purchaseBook(Book book) {
        if(Library.getBooks().contains(book)) {
            this.getBooksInPossession().add(book);
            System.out.println("Tebrikler! Satın alma işleminiz başarılı.");
            Library.deleteBook(book);
        }
        else System.out.println("Kütüphanemiz aradığınız kitaba sahip değil.");

    }

    @Override
    public String toString() {
        return "Person{" +
                " Name:'" + super.getName() + '\'' +
                ", Books in possession: " + booksToString() +
                '}';
    }

}
