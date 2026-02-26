package com.siddh.library.controller;

import com.siddh.library.dto.BookDTO;
import com.siddh.library.entity.Book;
import com.siddh.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO){
        BookDTO savedBook=bookService.createBook(bookDTO);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO>getBookById(@PathVariable Integer Id){
        BookDTO book=bookService.getBookById(Id);

        if(book==null){
            return new ResponseEntity<>(book,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookDTO>updateBookById(@PathVariable Integer id, @RequestBody Book book){
        BookDTO bookDTO=bookService.updateBook(id,book);

        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBook(){
        List<BookDTO> allBooks = bookService.getAllBooks();

        return ResponseEntity.ok(allBooks);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Integer id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book Deleted");
    }
}
