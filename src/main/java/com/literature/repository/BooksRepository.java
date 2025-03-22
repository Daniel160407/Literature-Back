package com.literature.repository;

import com.literature.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    Book findByTitleAndAuthor(String title, String author);

    @Transactional
    void deleteByTitleAndAuthor(String title, String author);
}
