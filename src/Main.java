import com.library.Library;
import com.library.books.Book;
import com.library.books.StudyBooks;
import com.library.persons.Author;
import com.library.persons.Person;
import com.library.persons.Reader;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person furkan = new Reader("Furkan", new LinkedHashSet<>());
        Person shakespeare = new Author("Shakespeare", new LinkedHashSet<>(), new LinkedHashSet<>());
        Book hamlet = new StudyBooks(1, new LinkedHashSet<>(Set.of(shakespeare, furkan)), "Hamlet", 10, 1);
        Book lear = new StudyBooks(2, new LinkedHashSet<>(Set.of(shakespeare)), "King Lear", 10, 1);

        /*Library.addBookStore(hamlet);
        Library.lendBook(furkan, hamlet);
        Library.lendBook(furkan, lear);

        System.out.println(furkan);*/

        System.out.println(shakespeare);
        System.out.println(furkan);









    }
}