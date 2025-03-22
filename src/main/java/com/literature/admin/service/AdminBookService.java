package com.literature.admin.service;

import com.literature.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminBookService {
    List<BookDto> addBook(BookDto bookDto);

    List<BookDto> editBook(List<BookDto> bookDtos);

    List<BookDto> removeBook(String title, String author);
}
