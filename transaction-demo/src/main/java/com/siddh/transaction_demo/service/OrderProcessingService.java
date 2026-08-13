package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.Order;
import com.siddh.transaction_demo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProcessingService {
    private final OrderHandler orderHandler;
    private final InventoryHandler inventoryHandler;
    private final AuditLogHandler auditLogHandler;
    private final PaymentValidatorHandler paymentValidatorHandler;
    private final NotificationHandler notificationHandler;
    private final ProductRecommendationHandler productRecommendationHandler;

    public OrderProcessingService(OrderHandler orderHandler, InventoryHandler inventoryHandler, AuditLogHandler auditLogHandler, PaymentValidatorHandler paymentValidatorHandler, NotificationHandler notificationHandler, ProductRecommendationHandler productRecommendationHandler) {
        this.orderHandler = orderHandler;
        this.inventoryHandler = inventoryHandler;
        this.auditLogHandler = auditLogHandler;
        this.paymentValidatorHandler = paymentValidatorHandler;
        this.notificationHandler = notificationHandler;
        this.productRecommendationHandler = productRecommendationHandler;
    }

    //REQUIRED: Join the existing transaction or create a new one if not exists
    //REQUIRES_NEW: Always create a new transaction, suspending if any existing transaction exist
    //(if I want to keep the track of those logs which are failed to improve my customer engagement)
    //MANDATORY: Requires an existing transaction if nothing found will throw an exception
    //NEVER: Ensure that the method will execute without transaction, throw an exception(Illegal State Transaction exception) if found any
    //NOT_SUPPORTED: Execute without any active transaction, suspending any active transaction
    //SUPPORTS: supports if there is any active transaction,if not execute without transaction
    //NESTED: It will execute within a nested transaction, allowing nested transaction to rollback independently if there is any exception without impacting outer transaction (Uses same transaction but creates savepoint).

    //Isolation: controls the visibility of changes made by one transaction to other transaction
    //DEFAULT: take isolation level that is of db internally
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED
    ,isolation = Isolation.DEFAULT)
    public Order placeAnOrder(Order order){
        //first get product from the inventory
        Product product=inventoryHandler.getProduct(order.getProductId());

        //validate stock availability
        if(order.getQuantity()>product.getStockQuantity()){
            throw new RuntimeException("Insufficient stock");
        }

        //update total price in order entity
        order.setTotalPrice(product.getPrice()*order.getQuantity());
        Order saveOrder=null;
        try{
            //save the order(1st inner transaction T1)
            saveOrder=orderHandler.saveOrder(order);

            //update stock in inventory(2nd inner transaction T2)
            updateInventoryStock(product,order);

            //required_new
            auditLogHandler.auditLogDetails("Order placement successfull",order);  //when we want to create a new transaction for this
        }
        catch(Exception ex){
            auditLogHandler.auditLogDetails("Order placement failed",order);
        }

        //example for never
        //order confirmation for user(retrying for 3 times)
        //notificationHandler.sendConfirmationOrder(order); //(will throw exception if i call here for never)
        //but for not_supported it will execute without any transaction(it will suspend the current transaction and execute method without any transaction)

        //validateAPayment(I want it to execute within the existing transaction)
        //if anything happens to this code it will not affect other part(MANDATORY)
        paymentValidatorHandler.validatePayment(order);

//        productRecommendationHandler.getRecommendations();

        //for supports check
        //getCustomerDetails();

        return saveOrder;
    }

    //call this method after successfully placing order for checking NEVER
//    public Order processOrder(Order order){
//        //1. place an order
//        Order savedOrder=placeAnOrder(order);
//        //2. send notification (non-transactional)
//        notificationHandler.sendConfirmationOrder(order);
//
//        return savedOrder;
//    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void getCustomerDetails(){
        System.out.println("Customer details fetched !!!");
    }

    private void updateInventoryStock(Product product,Order order){
        int remainingStock= product.getStockQuantity()-order.getQuantity();
        product.setStockQuantity(remainingStock);
        inventoryHandler.updateProductDetails(product);
    }
}
