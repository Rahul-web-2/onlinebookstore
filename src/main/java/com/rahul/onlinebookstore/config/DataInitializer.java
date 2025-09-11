package com.rahul.onlinebookstore.config;

import com.rahul.onlinebookstore.model.Book;
import com.rahul.onlinebookstore.model.Role;
import com.rahul.onlinebookstore.model.User;
import com.rahul.onlinebookstore.repository.BookRepository;
import com.rahul.onlinebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword("admin123");
            admin.setRole(Role.ADMIN);
            admin.setCreatedAt(LocalDateTime.now());
            userRepository.save(admin);
        }

        if (bookRepository.count() == 0) {
            bookRepository.saveAll(Arrays.asList(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 399.0, "Fiction", "Classic novel"),
                new Book("Clean Code", "Robert C. Martin", 899.0, "Programming", "Maintainable code guide"),
                new Book("1984", "George Orwell", 499.0, "Fiction", "Dystopian classic")
            ));
        }
    }
}
