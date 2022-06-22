package com.wildcodeschool.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wildcodeschool.entity.Book;
import com.wildcodeschool.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

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

        @PostMapping("/books/search")
        public List<Book> search(@RequestBody Map<String, String> body){
            String searchTerm = body.get("text");
            return bookRepository.findByTitleAuthorDescription(searchTerm, searchTerm, searchTerm);
        }
        @PostMapping("/books")
        public Book create(@RequestParam String title,
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
        bookRepository.deleteById(id);
        return true;
    }
    
}
