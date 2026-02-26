package com.siddh.library.controller;

import com.siddh.library.entity.Borrower;
import com.siddh.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @PostMapping("/borrow/member/{memberId}/book/{bookId}")
    public ResponseEntity<Borrower> borrowBook(@PathVariable Integer memberId,@PathVariable Integer bookId) {

        Borrower newRecord=borrowService.borrowBook(memberId, bookId);
        return ResponseEntity.ok(newRecord);
    }

    @PutMapping("/return/{borrowerId}")
    public ResponseEntity<Borrower> returnBook(@PathVariable Integer borrowerId) {

        Borrower updatedRecord=borrowService.returnBook(borrowerId);
        return ResponseEntity.ok(updatedRecord);
    }
}
