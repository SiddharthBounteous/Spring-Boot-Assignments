package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.AuditLog;
import com.siddh.transaction_demo.entity.Order;
import com.siddh.transaction_demo.repository.AuditLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentValidatorHandler {

    private final AuditLogRepository auditLogRepository;

    public PaymentValidatorHandler(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

//    @Transactional(propagation = Propagation.MANDATORY)
    @Transactional(propagation = Propagation.NESTED)  //this is child transaction
    public void validatePayment(Order order){

        boolean isPaymentSuccessfull=false;

        if(!isPaymentSuccessfull){
            AuditLog paymentLog=new AuditLog();
            paymentLog.setOrderId(Long.valueOf(order.getId()));
            paymentLog.setAction("Payment Failed");
            paymentLog.setTimestamp(LocalDateTime.now());

            //forcefully throwing some exception to check
//            if(order.getTotalPrice()>5000){
//                throw new RuntimeException("Error in validatePayment method");
//            }

            auditLogRepository.save(paymentLog);
        }
    }
}
