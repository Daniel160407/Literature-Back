package com.literature.admin.controller;

import com.literature.admin.service.AdminBookService;
import com.literature.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adminpanel/books")
@CrossOrigin(origins = "*")
public class AdminBookController {
    private final AdminBookService adminBookService;

    @Autowired
    public AdminBookController(AdminBookService adminBookService) {
        this.adminBookService = adminBookService;
    }

    @PostMapping
    public ResponseEntity<?> addNewBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(adminBookService.addBook(bookDto));
    }

    @PutMapping
    public ResponseEntity<?> editBook(@RequestBody List<BookDto> bookDtos) {
        return ResponseEntity.ok(adminBookService.editBook(bookDtos));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBook(@RequestParam String title,
                                        @RequestParam String author) {
        return ResponseEntity.ok(adminBookService.removeBook(title, author));
    }
}
