package com.literature.repository;

import com.literature.model.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDataRepository extends JpaRepository<BookData, Integer> {
    List<BookData> findAllByBookId(Integer bookId);
}
