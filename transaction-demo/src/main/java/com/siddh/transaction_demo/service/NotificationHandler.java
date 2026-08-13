package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationHandler {

//    @Transactional(propagation = Propagation.NEVER)
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void sendConfirmationOrder(Order order){

        //sending email to customer regarding confirmation of order
        System.out.println(order.getId()+" order placed successfully");
    }
}
