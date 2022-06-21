package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Book;
import Repository.BookRepository;
import com.wildcodeschool.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
        public List<Book> index(){
            return bookRepository.findAll();
        }

    @PostMapping("/books")
        public void create(@RequestParam String title,
                            @RequestParam String author,
                            @RequestParam String description){
            return bookRepository.save(new Book(title, author, description));
        }

    @PutMapping("books/{id}")
        public Book update(@PathVariable int id, @RequestBody Book book){
            // getting book
            Book bookToUpdate = bookRepository.findById(id).get();
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setDescription(book.getDescription());
            return bookRepository.save(bookToUpdate); 
        }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id){
        BookRepository.deleteById(id);
        return true;
    }
    
}
