package com.library;

import com.library.books.Book;
import com.library.persons.Author;
import com.library.persons.Person;
import com.library.persons.Reader;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Library {

    private static Set<Book> books = new LinkedHashSet<>();
    private static Map<Reader, Set<Book>> readers = new LinkedHashMap<>();
    private static Map<Author, Set<Book>> authors = new LinkedHashMap<>();

    public static Set<Book> getBooks() {
        return books;
    }

    public static Map<Reader, Set<Book>> getReaders() {
        return readers;
    }

    public static void addBookStore(Book book) {

            //Set olduğu için zaten 2.kez eklenmiyor ancak feedback vermek için bu şekilde yazdım.

            if(!books.contains(book)) {
                System.out.println("Kitap sisteme eklenmiştir.");
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

    public static void lendBook(Person person, Book book) {
        if(!books.contains(book)) {
            System.out.println("Ödünç almaya çalıştığınız kitap bulunmamaktadır.");
        } else {
            book.updateStatus();

            LocalDate lendDate = LocalDate.now();
            book.setDateOfPurchase(lendDate);

            person.addBookInPossession(book);
            System.out.println("Kitap başarıyla ödünç verilmiştir.");
        }
    }


}
