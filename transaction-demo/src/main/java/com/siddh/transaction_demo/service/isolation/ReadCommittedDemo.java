package com.siddh.transaction_demo.service.isolation;

import com.siddh.transaction_demo.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ReadCommittedDemo {

    private final ProductService productService;

    public ReadCommittedDemo(ProductService productService) {
        this.productService = productService;
    }

    public void testReadCommitted(int id) throws InterruptedException{

        //50->5
        //ThreadA is trying to update stock but not commit it
        Thread threadA=new Thread(()->{
            try{
                productService.updateStock(id,5);  //updating it to 5
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //50
        //ThreadB is trying to read the stock
        Thread threadB=new Thread(()->{
            try{
                Thread.sleep(2000); //wait a moment to ensure that threadA starts first
                int stock= productService.checkStock(id);  //Read the value of stock A during transaction
                System.out.println("Stock read by Transaction B: "+stock);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
