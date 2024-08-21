package com.library.books;

import com.library.Library;
import com.library.persons.Author;
import com.library.enums.Status;
import com.library.persons.Person;
import com.library.persons.Reader;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public abstract class Book {

    private long bookId;
    private Set<Person> authors;
    private String title;
    private double price;
    private Status status;
    private int edition;
    private LocalDate dateOfPurchase;
    private Reader owner;

    public Book(long bookId, Set<Person> authors, String title, double price, int edition) {
        this.bookId = bookId;
        this.authors = authors;
        this.title = title;
        this.price = price;
        this.edition = edition;
        this.status = Status.AVAILABLE;

        for(Person author : authors) {
            if(author instanceof Author) {
                ((Author) author).writeBook(this);
                Library.addBookStore(this);
            }
        }
    }

    public Book getBook() {
        return this;
    }
    public Reader getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public long getBookId() {
        return bookId;
    }

    public Set<Person> getAuthors() {
        return authors;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setOwner(Reader owner) {
        this.owner = owner;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setAuthors(Set<Person> authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String authorsToString() {
        StringBuilder message = new StringBuilder();
        int index = 0;
        for(Person author : authors) {
            if(author != null) {
                if(index > 0) {
                    message.append(",");
                }
                message.append(author.getName());
            }
            index++;
        }

        return message.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    @Override
    public String toString() {
        return "Book{" +
                " bookId: " + bookId +
                ", authors: " + authorsToString() +
                ", title:' " + title + '\'' +
                ", price: " + price +
                ", status: " + status +
                ", edition: " + edition +
                ", dateOfPurchase:' " + dateOfPurchase + '\'' +
                '}';
    }
}
