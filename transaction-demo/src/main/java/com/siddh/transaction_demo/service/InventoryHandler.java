package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.Product;
import com.siddh.transaction_demo.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryHandler {

    private final InventoryRepository inventoryRepository;

    public InventoryHandler(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public Product updateProductDetails(Product product){
        //let us throw some forced exception to check this
        if(product.getPrice()>7000){
            throw  new RuntimeException("Product price is greater than 5000");
        }
        return inventoryRepository.save(product);
    }

    public Product getProduct(int id){
        return inventoryRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }
}

