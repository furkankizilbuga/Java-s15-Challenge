import com.library.Console;
import com.library.Library;
import com.library.books.Book;
import com.library.books.Journals;
import com.library.books.Literature;
import com.library.books.Magazines;
import com.library.persons.Author;
import com.library.persons.Person;
import com.library.persons.Reader;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Person furkan = new Reader("Furkan");
        Person hasan = new Reader("Hasan");
        Person shakespeare = new Author("Shakespeare");
        Person shelley = new Author("Mary Shelley");
        Book hamlet = new Literature(1, new LinkedHashSet<>(Set.of(shakespeare, furkan)), "Hamlet", 10, 1);
        Book lear = new Literature(2, new LinkedHashSet<>(Set.of(shakespeare)), "King Lear", 10, 1);
        Book frankenstein = new Literature(3, new LinkedHashSet<>(Set.of(shelley)), "Frankenstein", 10, 1);
        Book magazine = new Magazines(4, new LinkedHashSet<>(Set.of(shelley)), "magazineExample", 10, 1);
        Book journal = new Journals(5, new LinkedHashSet<>(Set.of(shelley)), "journalExample", 10, 1);
        Book dergi = new Journals(6, new LinkedHashSet<>(Set.of(shelley)), "Dergi", 10, 1);

        Console.start();



    }

}