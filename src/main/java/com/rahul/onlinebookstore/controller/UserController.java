package com.rahul.onlinebookstore.controller;

import com.rahul.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;  // ✅ Import this

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookService bookService;

    @GetMapping("/dashboard")
    public String userDashboard(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "user_dashboard";
    }
}
