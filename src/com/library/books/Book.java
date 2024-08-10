package com.library.books;

import com.library.persons.Author;
import com.library.enums.Status;
import com.library.persons.Person;

import java.util.Set;

public abstract class Book {

    private long bookId;
    private Set<Person> authors;
    private String title;
    private double price;
    private Status status;
    private double edition;
    private String dateOfPurchase;

    public Book(long bookId, Set<Person> authors, String title, double price, double edition) {
        this.bookId = bookId;
        this.authors = authors;
        this.title = title;
        this.price = price;
        this.edition = edition;
        this.status = Status.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public Set<Person> getAuthors() {
        return authors;
    }

    public void updateStatus() {
        if(status == Status.AVAILABLE) this.status = Status.IN_USE;
        else if(status == Status.IN_USE) this.status = Status.AVAILABLE;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String authorsToString() {
        String message = "";
        for(Person author : authors) {
            if(author != null) {
                message += author.getName();
            }
        }
        return message;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", authors=" + authorsToString() +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                '}';
    }
}
