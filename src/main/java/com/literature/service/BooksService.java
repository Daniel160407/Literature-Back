package com.literature.service;

import com.literature.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksService {
    List<BookDto> getBooks();
}
