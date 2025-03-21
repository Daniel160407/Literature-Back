package com.literature.service;

import com.literature.dto.BookDto;
import com.literature.repository.BooksRepository;
import com.literature.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;
    private final ModelConverter modelConverter;

    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository, ModelConverter modelConverter) {
        this.booksRepository = booksRepository;
        this.modelConverter = modelConverter;
    }

    @Override
    public List<BookDto> getBooks() {
        return modelConverter.convertBooksToDtoList(booksRepository.findAll());
    }
}
