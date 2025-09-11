package com.rahul.onlinebookstore.controller;

import com.rahul.onlinebookstore.model.Book;
import com.rahul.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin_dashboard";
    }

    @GetMapping("/add-book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_book";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book, Model model) {
        bookService.saveBook(book);
        model.addAttribute("message", "Book added successfully!");
        model.addAttribute("books", bookService.getAllBooks());
        return "admin_dashboard";
    }
    
    @GetMapping("/edit-book/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        bookService.getBookById(id).ifPresent(book -> model.addAttribute("book", book));
        return "edit_book";
    }

    @PostMapping("/edit-book")
    public String editBook(@ModelAttribute Book book, Model model) {
        bookService.saveBook(book);
        model.addAttribute("message", "Book updated successfully!");
        model.addAttribute("books", bookService.getAllBooks());
        return "admin_dashboard";
    }

    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBookById(id);
        model.addAttribute("message", "Book deleted successfully!");
        model.addAttribute("books", bookService.getAllBooks());
        return "admin_dashboard";
    }

}
