package com.d2600.books.repos;

import com.d2600.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    List<Book> findAll();

    List <Book> findByTitle(String str);
}
