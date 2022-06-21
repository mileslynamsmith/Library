package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.Book;

import java.util.List;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer> {

    List<Book> somethinghere (String text, String textagain, String textandagain);

}
