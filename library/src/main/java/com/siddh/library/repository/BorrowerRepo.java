package com.siddh.library.repository;

import com.siddh.library.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepo extends JpaRepository<Borrower,Integer> {
}
