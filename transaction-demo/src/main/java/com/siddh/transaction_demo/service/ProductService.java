package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.Product;
import com.siddh.transaction_demo.repository.InventoryRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class ProductService {

    private final InventoryRepository inventoryRepository;

    //flush after each query using entity manager
    private final EntityManager entityManager;

    public ProductService(InventoryRepository inventoryRepository, EntityManager entityManager) {
        this.inventoryRepository = inventoryRepository;
        this.entityManager = entityManager;
    }

    //Transaction A
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
//    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updateStock(int productId,int stock) throws InterruptedException{
        //Retrieve the product and update its stock
        Product product=inventoryRepository.findById(productId).orElseThrow(
                ()->new RuntimeException("Product not found")
        );

        product.setStockQuantity(stock);
        inventoryRepository.save(product);
        //Send pending SQL changes to the database immediately, but do not commit the transaction yet.
        entityManager.flush();  //ensure every update is send to DB

        //simulate a long-running transaction(does not commit yet)
        System.out.println("Transaction A: Stock updated to stock "+stock);
        Thread.sleep(5000);

        //we are doing explicitly rollback
        //Demonstrating read uncommitted by rolling back the transaction
//        System.out.println("Transaction A is now doing rollback");
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        System.out.println("Transaction A: Committed the update");
    }

    //Transaction B  (Read stock)
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
//    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int checkStock(int productId){

        //Retrieve the product and update its stock (potentially dirty read)
        Product product=inventoryRepository.findById(productId).orElseThrow(
                ()->new RuntimeException("Product not found")
        );
        System.out.println("Transaction B: Read stock as "+product.getStockQuantity());
        return product.getStockQuantity();
    }

    //if any transaction is doing modification in between, how many times i face the result , I should face constant output
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void fetchStock(int productId){

        //first read
        Product product1=inventoryRepository.findById(productId).orElseThrow(
                ()->new RuntimeException("Product not found")
        );
        System.out.println("Transaction B: First Read stock as (before) "+product1.getStockQuantity());  //50

        // Simulate a delay to allow Transaction A to update the stock
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //second read
        Product product2=inventoryRepository.findById(productId).orElseThrow(
                ()->new RuntimeException("Product not found")
        );
        System.out.println("Transaction B: Second read stock as (after) "+product2.getStockQuantity());  //50

    }

}
