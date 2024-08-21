package com.library;

import com.library.books.Book;
import com.library.books.Literature;
import com.library.enums.Status;
import com.library.interfaces.findBookInterface;
import com.library.interfaces.updateBookInterface;
import com.library.persons.Author;
import com.library.persons.Person;
import com.library.persons.Reader;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Library {

    private static Set<Book> books = new LinkedHashSet<>();
    private static Map<Reader, Set<Book>> readers = new LinkedHashMap<>();
    private static Map<Author, Set<Book>> authors = new LinkedHashMap<>();


    public static Set<Book> getBooks() {
        return books;
    }

    public static Map<Author, Set<Book>> getAuthors() {
        return authors;
    }

    public static Map<Reader, Set<Book>> getReaders() {
        return readers;
    }

    public static void addBookStore(Book book) {

            //Set olduğu için zaten 2.kez eklenmiyor ancak feedback vermek için bu şekilde yazdım.

            if(!books.contains(book)) {
                //System.out.println("Kitap sisteme eklenmiştir: " + book.getTitle());
                books.add(book);
            }
            else System.out.println("Eklemeye çalıştığınız kitap zaten mevcut.");

    }

    public static void deleteBook(Book book) {

        Set<Reader> readerKeys = readers.keySet();
        for(Reader key : readerKeys) {
            readers.get(key).remove(book); //Hata olursa contain check'i koy.
        }

        Set<Author> authorKeys = authors.keySet();
        for(Author key : authorKeys) {
            authors.get(key).remove(book); //Hata olursa contain check'i koy.
        }

        books.remove(book);
        System.out.println("Kitap sistemden silinmiştir.");
    }

    public static void updateBook(Book book, long bookId) {
        book.setBookId(bookId);
    }

    public static void updateBook(Book book, String title) {
        book.setTitle(title);
    }

    public static void updateBook(Book book, double price) {
        book.setPrice(price);
    }

    public static void updateBook(Book book, Status status) {
        book.setStatus(status);
    }

    public static void updateBook(Book book, int edition) {
        book.setEdition(edition);
    }

    public static void updateBook(Book book, LocalDate dateOfPurchase) {
        book.setDateOfPurchase(dateOfPurchase);
    }

    public static Optional<Book> findBook(long bookId) {
        return books.stream().filter(book -> book.getBookId() == bookId).findFirst();
    }

    public static Optional<Book> findBook(String title) {
        return books
                .stream()
                .filter(book -> book.getTitle().trim().equalsIgnoreCase(title))
                .findFirst();
    }

    public static Set<Book> findBook(Person author) {

        if (!(author instanceof Author)) {
            System.out.println("Lütfen geçerli bir yazar ismi giriniz.");
            return new LinkedHashSet<>();
        }


        /*if (!(author instanceof Author)) {
            throw new IllegalArgumentException("Lütfen geçerli bir yazar ismi giriniz.");
        }*/

        return books
                .stream()
                .filter(book -> book.getAuthors().contains(author))
                .collect(Collectors.toSet());
    }

    public static Set<Book> findBook(Class type) {
        Set<Book> categorizedBooks = new HashSet<>();
        for (Book book : books) {
            if (type.isInstance(book)) {
                categorizedBooks.add(book);
            }
        }
        return categorizedBooks;
    }

    public static Reader checkUser(int id) {
        Set<Reader> keys = getReaders().keySet();
        for(Reader key : keys) {
            if(key.getId() == id) {
                System.out.println("Kullanıcı mevcut.");
                return key;
            }
        }
        System.out.println("Kullanıcı bulunamadı.");
        return null;
    }

    public static void addReader(Reader reader) {
        //Person vermiyorum çünkü zaten checkUser Reader üzerinden işlem yapıyor. Author gelemez.
        readers.put(reader, reader.getBooks());
    }


}
