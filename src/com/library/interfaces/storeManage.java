package com.library.interfaces;

import com.library.Library;
import com.library.books.Book;
import com.library.persons.Author;
import com.library.persons.Reader;

import java.util.Set;

public interface storeManage {

    default void addBookStore(Book book) {

        //Set olduğu için zaten 2.kez eklenmiyor ancak feedback vermek için bu şekilde yazdım.

        if(!Library.getBooks().contains(book)) {
            //System.out.println("Kitap sisteme eklenmiştir: " + book.getTitle());
            Library.getBooks().add(book);
        }
        else System.out.println("Eklemeye çalıştığınız kitap zaten mevcut.");

    }

    default void deleteBook(Book book) {

        Set<Reader> readerKeys = Library.getReaders().keySet();
        for(Reader key : readerKeys) {
            Library.getReaders().get(key).remove(book); //Hata olursa contain check'i koy.
        }

        Set<Author> authorKeys = Library.getAuthors().keySet();
        for(Author key : authorKeys) {
            Library.getAuthors().get(key).remove(book); //Hata olursa contain check'i koy.
        }

        Library.getBooks().remove(book);
        System.out.println("Kitap sistemden silinmiştir.");
    }
}
