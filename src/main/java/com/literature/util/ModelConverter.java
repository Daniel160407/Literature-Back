package com.literature.util;

import com.literature.dto.BookDto;
import com.literature.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelConverter {
    public List<BookDto> convertBooksToDtoList(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(book -> bookDtos.add(new BookDto(book.getTitle(), book.getDescription(), book.getAuthor())));
        return bookDtos;
    }

    public Book convert(BookDto bookDto) {
        return Book.builder()
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .author(bookDto.getAuthor())
                .build();
    }
}
