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

        Person furkan = new Reader("Furkan", new LinkedHashSet<>());
        Person hasan = new Reader("Hasan", new LinkedHashSet<>());
        Person shakespeare = new Author("Shakespeare", new LinkedHashSet<>());
        Person shelley = new Author("Mary Shelley", new LinkedHashSet<>());
        Book hamlet = new Literature(1, new LinkedHashSet<>(Set.of(shakespeare, furkan)), "Hamlet", 10, 1);
        Book lear = new Literature(2, new LinkedHashSet<>(Set.of(shakespeare)), "King Lear", 10, 1);
        Book frankenstein = new Literature(3, new LinkedHashSet<>(Set.of(shelley)), "Frankenstein", 10, 1);
        Book magazine = new Magazines(4, new LinkedHashSet<>(Set.of(shelley)), "magazineExample", 10, 1);
        Book journal = new Journals(5, new LinkedHashSet<>(Set.of(shelley)), "journalExample", 10, 1);
        Book dergi = new Journals(6, new LinkedHashSet<>(Set.of(shelley)), "Dergi", 10, 1);



        ((Reader)furkan).borrowBook(hamlet);
        System.out.println(Library.getBooks());
        ((Reader)hasan).borrowBook(hamlet);
        System.out.println(hasan);
        System.out.println(furkan);




    }

    /*public static void purchaseBook(Person person, Book book) {
        ((Reader) person).purchaseBook(book);
    }*/

    /*

    **Sisteme yeni kitap eklenebilir.
    **Sistemden id, isim veya yazar bilgisine göre bir kitap seçilebilir
    **Sistemde var olan bir kitabın bilgileri güncellenebilir.
    **Sistemde var olan bir kitap silinebilir.
    **Sistemde var olan bir kategorideki tüm kitaplar listelenebilir.
    **Sistemde var olan bir yazarın tüm kitapları listelenebilir
    Bir kullanıcı sistemde eğer kitap kütüphanede varsa ve başkası tarafından alınmadıysa bir kitabı ödünç alabilir. Bu durum yaşanırsa hangi kitabın hangi kullanıcıda olduğunun bilgisi tutulmalıdır.
    Aynı şekilde kullanıcı kitap geri teslimde edebilir.
    Sistemden bir kitap alındığında kitabı alan kullanıcıya bir fatura kesilmelidir. Kitabı geri iade ettiğinde kullanıcıya ücreti geri iade edilmelidir.
    **Kullanıcıların 5 kitap limiti olmalı ve bu kitap limitine ulaştıklarında daha fazla kitap alamamalılar.

     */

    
}