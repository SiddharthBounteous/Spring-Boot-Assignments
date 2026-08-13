package com.siddh.transaction_demo.repository;

import com.siddh.transaction_demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
