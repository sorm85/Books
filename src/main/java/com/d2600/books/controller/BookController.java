package com.d2600.books.controller;

import com.d2600.books.entity.Book;
import com.d2600.books.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookServices bookServices;

    @GetMapping
    public ResponseEntity <List<Book>>  getAllBooks () {
        List <Book> books = bookServices.getAllBooks();
        return ResponseEntity.ok(books);
    }
    @PostMapping (value = "/addingBook", consumes = "application/json")
    public ResponseEntity<Book> addinBook (@RequestBody Book book){
        if (book == null){
            return ResponseEntity.notFound().build();
        }
        Book savedBook = bookServices.addingBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    @PostMapping (value = "/testStream", consumes = "application/json")
    public ResponseEntity<String> addingTestString () {
        List <Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List <Integer> result = numbers.stream()
                .filter(n -> n %2 ==0)
                .map (n -> n*n)
                .collect(Collectors.toList());
        String str = result.toString();
        return new ResponseEntity<> (str,HttpStatus.ACCEPTED);

    }

}
