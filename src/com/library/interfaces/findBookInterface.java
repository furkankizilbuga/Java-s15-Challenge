package com.library.interfaces;

import com.library.Library;
import com.library.books.Book;
import com.library.persons.Author;
import com.library.persons.Person;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.library.Library.getBooks;

public interface findBookInterface {
    default Optional<Book> findBook(String title) {
        return getBooks()
                .stream()
                .filter(book -> book.getTitle().trim().equalsIgnoreCase(title))
                .findFirst();
    }

    default Optional<Book> findBook(long bookId) {
        return Library.getBooks().stream().filter(book -> book.getBookId() == bookId).findFirst();
    }

    default Set<Book> findBook(Person author) {

        if (!(author instanceof Author)) {
            System.out.println("Lütfen geçerli bir yazar ismi giriniz.");
            return new LinkedHashSet<>();
        }

        return Library.getBooks()
                .stream()
                .filter(book -> book.getAuthors().contains(author))
                .collect(Collectors.toSet());
    }

    default Set<Book> findBook(Class type) {
        Set<Book> categorizedBooks = new HashSet<>();
        for (Book book : Library.getBooks()) {
            if (type.isInstance(book)) {
                categorizedBooks.add(book);
            }
        }
        return categorizedBooks;
    }
}
