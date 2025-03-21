package com.literature.service;

import com.literature.dto.BookDataDto;
import org.springframework.stereotype.Service;

@Service
public interface BookDataService {
    BookDataDto getBookText(Integer bookId);
}
