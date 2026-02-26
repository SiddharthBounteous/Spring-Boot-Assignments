package com.siddh.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowerId;

    @ManyToOne
    @JoinColumn(name="bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;
    private Timestamp returnTime;
    private Timestamp borrowTime;
    private Timestamp dueDate;

}
