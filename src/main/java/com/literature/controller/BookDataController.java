package com.literature.controller;

import com.literature.service.BookDataService;
import com.literature.service.exception.BookDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/literature/data")
@CrossOrigin(origins = "*")
public class BookDataController {
    private final BookDataService bookDataService;

    @Autowired
    public BookDataController(BookDataService bookDataService) {
        this.bookDataService = bookDataService;
    }

    @GetMapping
    public ResponseEntity<?> getData(@RequestParam Integer bookid) {
        try {
            return ResponseEntity.ok(bookDataService.getBookText(bookid));
        } catch (BookDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
