package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Entity.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //custom query to search Library by title, author, description
    List<Book> findByTitleAuthorDescription (String text, String textagain, String textandagain);

}
