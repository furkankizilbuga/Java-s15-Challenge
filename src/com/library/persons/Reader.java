package com.library.persons;

import com.library.Library;
import com.library.books.Book;
import com.library.enums.Status;

import java.time.LocalDate;
import java.util.Set;

public class Reader extends Person {

    private int points;

    public Reader(String name, Set<Book> books) {
        super(name, books);
        points = 5;
    }

    public void purchaseBook(Book book) {
        if(!Library.getBooks().contains(book)) {
            System.out.println("Kütüphanemiz aradığınız kitaba sahip değil.");
        }
        else if(points >= 2) {
            this.getBooks().add(book);
            System.out.println("Tebrikler! Satın alma işleminiz başarılı.");
            Library.deleteBook(book);
        } else {
            System.out.println("Yetersiz bakiye.");
        }
    }

    public void borrowBook(Person person, Book book) {
        if(!Library.getBooks().contains(book)) {
            System.out.println("Ödünç almaya çalıştığınız kitap bulunmamaktadır.");
        } else if(person instanceof Reader) {
            if(person.getBooks().size() >= 5) {
                System.out.println("En fazla 5 kitap ödünç alabilirsiniz.");
            } else if(points >= 1) {
                book.setStatus(Status.IN_USE);

                LocalDate lendDate = LocalDate.now();
                book.setDateOfPurchase(lendDate);

                person.getBooks().add(book);

                Library.getReaders().put(this, getBooks());

                System.out.println("Kitap başarıyla ödünç alınmıştır.");
            } else {
                System.out.println("Yetersiz bakiye.");
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                " Name:'" + super.getName() + '\'' +
                ", Books in possession: " + booksToString() +
                '}';
    }

}
