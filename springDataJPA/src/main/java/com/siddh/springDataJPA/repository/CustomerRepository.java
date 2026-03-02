package com.siddh.springDataJPA.repository;

import com.siddh.springDataJPA.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
