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
        Person furkan = new Reader("furkan", new LinkedHashSet<>());
        Person shakespeare = new Author("Shakespeare", new HashSet<>());
        Book hamlet = new StudyBooks(1, new HashSet<>(Set.of(shakespeare)), "Hamlet", 10, 1);

        shakespeare.addBook(hamlet);
        ((Reader)furkan).purchaseBook(hamlet);

        System.out.println(shakespeare);
        System.out.println(furkan.getName() + " " + furkan.getBooks());
    }
}