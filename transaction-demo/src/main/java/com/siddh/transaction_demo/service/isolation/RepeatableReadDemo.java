package com.siddh.transaction_demo.service.isolation;

import com.siddh.transaction_demo.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class RepeatableReadDemo {
    private final ProductService productService;

    public RepeatableReadDemo(ProductService productService) {
        this.productService = productService;
    }

    public void testRepeatableRead(int id) throws InterruptedException{

        //ThreadA is trying to update stock but not commit it
        Thread threadA=new Thread(()->{
            try{
                productService.updateStock(id,5);  //updating it to 5
            } catch (InterruptedException e) {
                System.out.println("Transaction A Exception occurred");
            }
        });

        //ThreadB is trying to read the stock multiple times
        Thread threadB=new Thread(()->{
            try{
                Thread.sleep(2000); //wait a moment to ensure that threadA starts first
                productService.fetchStock(id);  //Read the value of stock A during transaction
            } catch (InterruptedException e) {
                System.out.println("Transaction B Exception occurred");
            }
        });

        //start the threads
        threadA.start();
        threadB.start();

        //wait for the threads to complete
        threadA.join();
        threadB.join();
    }
}
