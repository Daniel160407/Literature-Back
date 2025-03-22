package com.literature.admin.service;

import com.literature.dto.BookDataDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminBookDataService {
    BookDataDto addBookData(BookDataDto bookDataDto);

    BookDataDto editBookData(List<BookDataDto> bookDataDtos);

    void removeBookData(Integer bookId);
}
