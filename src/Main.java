import com.library.Library;
import com.library.books.Book;
import com.library.books.Literature;
import com.library.persons.Author;
import com.library.persons.Person;
import com.library.persons.Reader;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person furkan = new Reader("Furkan", new LinkedHashSet<>());
        Person shakespeare = new Author("Shakespeare", new LinkedHashSet<>(), new LinkedHashSet<>());
        Book hamlet = new Literature(1, new LinkedHashSet<>(Set.of(shakespeare, furkan)), "Hamlet", 10, 1);
        Book lear = new Literature(2, new LinkedHashSet<>(Set.of(shakespeare)), "King Lear", 10, 1);

        //System.out.println(Library.findBook(2));
        //System.out.println(Library.findBook("hamlet"));
        System.out.println(Library.findBook(furkan));
    }

    /*

    **Sisteme yeni kitap eklenebilir.
    **Sistemden id, isim veya yazar bilgisine göre bir kitap seçilebilir
    **Sistemde var olan bir kitabın bilgileri güncellenebilir.
    **Sistemde var olan bir kitap silinebilir.
      Sistemde var olan bir kategorideki tüm kitaplar listelenebilir.
    **Sistemde var olan bir yazarın tüm kitapları listelenebilir
    Bir kullanıcı sistemde eğer kitap kütüphanede varsa ve başkası tarafından alınmadıysa bir kitabı ödünç alabilir. Bu durum yaşanırsa hangi kitabın hangi kullanıcıda olduğunun bilgisi tutulmalıdır.
    Aynı şekilde kullanıcı kitap geri teslimde edebilir.
    Sistemden bir kitap alındığında kitabı alan kullanıcıya bir fatura kesilmelidir. Kitabı geri iade ettiğinde kullanıcıya ücreti geri iade edilmelidir.
    Kullanıcıların 5 kitap limiti olmalı ve bu kitap limitine ulaştıklarında daha fazla kitap alamamalılar.

     */

    
}