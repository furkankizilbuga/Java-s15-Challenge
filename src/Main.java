import com.library.Console;
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

        Person furkan = new Reader(1,"Furkan");
        Person hasan = new Reader(2,"Hasan");

        Person shakespeare = new Author(3,"Shakespeare");
        Person shelley = new Author(4,"Mary Shelley");

        Book hamlet = new Literature(1, new LinkedHashSet<>(Set.of(shakespeare, furkan)), "Hamlet", 10, 1);
        Book lear = new Literature(2, new LinkedHashSet<>(Set.of(shakespeare)), "King Lear", 10, 1);
        Book frankenstein = new Literature(3, new LinkedHashSet<>(Set.of(shelley)), "Frankenstein", 10, 1);
        Book magazine = new Magazines(4, new LinkedHashSet<>(Set.of(shelley)), "magazineExample", 10, 1);
        Book journal = new Journals(5, new LinkedHashSet<>(Set.of(shelley)), "journalExample", 10, 1);
        Book dergi = new Journals(6, new LinkedHashSet<>(Set.of(shelley)), "Dergi", 10, 1);



        //writeBook
        //((Author) shakespeare).writeBook(new Literature(7,new LinkedHashSet<>(Set.of(shakespeare)), "A Midsummer Night's Dream", 20, 2));

        Console.start();





    }

}