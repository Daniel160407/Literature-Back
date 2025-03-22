package com.literature.admin.service;

import com.literature.dto.BookDto;
import com.literature.model.Book;
import com.literature.repository.BooksRepository;
import com.literature.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBookServiceImpl implements AdminBookService {
    private final BooksRepository booksRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public AdminBookServiceImpl(BooksRepository booksRepository, ModelConverter modelConverter) {
        this.booksRepository = booksRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public List<BookDto> addBook(BookDto bookDto) {
        booksRepository.save(modelConverter.convert(bookDto));
        return modelConverter.convertBooksToDtoList(booksRepository.findAll());
    }

    @Override
    public List<BookDto> editBook(List<BookDto> bookDtos) {
        BookDto original = bookDtos.get(0);
        BookDto edited = bookDtos.get(1);

        Book book = booksRepository.findByTitleAndAuthor(original.getTitle(), original.getAuthor());
        book.setTitle(edited.getTitle());
        book.setDescription(edited.getDescription());
        book.setAuthor(edited.getAuthor());

        booksRepository.save(book);

        return modelConverter.convertBooksToDtoList(booksRepository.findAll());
    }

    @Override
    public List<BookDto> removeBook(String title, String author) {
        booksRepository.deleteByTitleAndAuthor(title, author);
        return modelConverter.convertBooksToDtoList(booksRepository.findAll());
    }
}
