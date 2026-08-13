package com.siddh.transaction_demo.repository;

import com.siddh.transaction_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository  extends JpaRepository<Product,Integer> {
}
