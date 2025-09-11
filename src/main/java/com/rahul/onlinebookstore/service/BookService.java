package com.rahul.onlinebookstore.service;

import com.rahul.onlinebookstore.model.Book;
import com.rahul.onlinebookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    
 // Get book by id
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
 // Delete book by id
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}

