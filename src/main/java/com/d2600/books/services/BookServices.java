package com.d2600.books.services;

import com.d2600.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.d2600.books.repos.BookRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }
    public Book addingBook (Book book ) {
        return bookRepository.save(book);
    }
    public Book searchBook (Long id) {
        return  bookRepository.getById(id);
    }

}
