package com.literature.service;

import com.literature.dto.BookDataDto;
import com.literature.model.BookData;
import com.literature.repository.BookDataRepository;
import com.literature.service.exception.BookDoesNotExistException;
import com.literature.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDataServiceImpl implements BookDataService {
    private final BookDataRepository bookDataRepository;

    @Autowired
    public BookDataServiceImpl(BookDataRepository bookDataRepository) {
        this.bookDataRepository = bookDataRepository;
    }

    @Override
    public BookDataDto getBookText(Integer bookId) {
        List<BookData> bookData = bookDataRepository.findAllByBookId(bookId);
        if (bookData.isEmpty()) {
            throw new BookDoesNotExistException();
        }
        StringBuilder text = new StringBuilder();
        for (BookData bookData1 : bookData) {
            text.append(bookData1.getText());
        }
        return new BookDataDto(bookId, text.toString());
    }
}
