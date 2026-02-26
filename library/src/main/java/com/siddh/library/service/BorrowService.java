package com.siddh.library.service;

import com.siddh.library.entity.Book;
import com.siddh.library.entity.Borrower;
import com.siddh.library.entity.Member;
import com.siddh.library.repository.BookRepo;
import com.siddh.library.repository.BorrowerRepo;
import com.siddh.library.repository.MemberRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class BorrowService {

    @Autowired
    BorrowerRepo borrowerRepo;

    @Autowired
    MemberRepo memberRepo;

    @Autowired
    BookRepo bookRepo;


    public Borrower borrowBook(Integer memberId,Integer bookId){
        Book book=bookRepo.findById(bookId).orElseThrow(()->new RuntimeException("Book not found with given id"));

        Member member=memberRepo.findById(memberId).orElseThrow(()->new RuntimeException("Member not found with given id"));

        Borrower borrowerRecord=new Borrower();
        borrowerRecord.setBook(book);
        borrowerRecord.setMember(member);

        borrowerRecord.setBorrowTime(new Timestamp(System.currentTimeMillis()));


        LocalDateTime now = LocalDateTime.now();
        borrowerRecord.setDueDate(Timestamp.valueOf(now.plusMonths(3)));
        borrowerRecord.setReturnTime(null);

        return borrowerRepo.save(borrowerRecord);
    }

    public Borrower returnBook(Integer borrowerId){
        Borrower borrowerRecord=borrowerRepo.findById(borrowerId)
                .orElseThrow(()->new RuntimeException("Borrow record not found with ID: " + borrowerId));

        if(borrowerRecord.getReturnTime()!=null) {
            throw new RuntimeException("This book has already been returned!");
        }

        borrowerRecord.setReturnTime(new Timestamp(System.currentTimeMillis()));
        return borrowerRepo.save(borrowerRecord);
    }
}
