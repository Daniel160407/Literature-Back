package com.literature.admin.service;

import com.literature.dto.BookDataDto;
import com.literature.model.BookData;
import com.literature.repository.BookDataRepository;
import com.literature.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminBookDataServiceImpl implements AdminBookDataService {
    private final BookDataRepository bookDataRepository;

    private static final int MAX_TEXT_SIZE = 65535;

    @Autowired
    public AdminBookDataServiceImpl(BookDataRepository bookDataRepository) {
        this.bookDataRepository = bookDataRepository;
    }

    @Override
    public BookDataDto addBookData(BookDataDto bookDataDto) {
        Integer bookId = bookDataDto.getBookId();
        String text = bookDataDto.getText();

        List<BookData> bookDataChunks = new ArrayList<>();

        for (int i = 0; i < text.length(); i += MAX_TEXT_SIZE) {
            String chunk = text.substring(i, Math.min(i + MAX_TEXT_SIZE, text.length()));

            BookData bookData = new BookData();
            bookData.setBookId(bookId);
            bookData.setText(chunk);

            bookDataChunks.add(bookData);
        }

        bookDataRepository.saveAll(bookDataChunks);

        return bookDataDto;
    }

    @Override
    public BookDataDto editBookData(List<BookDataDto> bookDataDtos) {
        BookDataDto originalDto = bookDataDtos.get(0);
        BookDataDto editedDto = bookDataDtos.get(1);

        Integer originalBookId = originalDto.getBookId();
        Integer editedBookId = editedDto.getBookId();
        String editedText = editedDto.getText();

        bookDataRepository.deleteAllByBookId(originalBookId);

        List<BookData> newChunks = new ArrayList<>();
        for (int i = 0; i < editedText.length(); i += MAX_TEXT_SIZE) {
            String chunk = editedText.substring(i, Math.min(i + MAX_TEXT_SIZE, editedText.length()));

            BookData bookData = new BookData();
            bookData.setBookId(editedBookId);
            bookData.setText(chunk);

            newChunks.add(bookData);
        }

        bookDataRepository.saveAll(newChunks);

        return editedDto;
    }

    @Override
    public void removeBookData(Integer bookId) {
        bookDataRepository.deleteAllByBookId(bookId);
    }
}
