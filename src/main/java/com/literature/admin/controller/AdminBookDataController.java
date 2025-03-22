package com.literature.admin.controller;

import com.literature.admin.service.AdminBookDataService;
import com.literature.dto.BookDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adminpanel/data")
@CrossOrigin(origins = "*")
public class AdminBookDataController {
    private final AdminBookDataService adminBookDataService;

    @Autowired
    public AdminBookDataController(AdminBookDataService adminBookDataService) {
        this.adminBookDataService = adminBookDataService;
    }

    @PostMapping
    public ResponseEntity<?> addBookData(@RequestBody BookDataDto bookDataDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminBookDataService.addBookData(bookDataDto));
    }

    @PutMapping
    public ResponseEntity<?> editBookData(@RequestBody List<BookDataDto> bookDataDtos) {
        return ResponseEntity.ok(adminBookDataService.editBookData(bookDataDtos));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBookData(@RequestParam Integer bookid) {
        adminBookDataService.removeBookData(bookid);
        return ResponseEntity.ok().build();
    }
}
