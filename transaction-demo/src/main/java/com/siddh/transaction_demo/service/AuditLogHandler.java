package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.AuditLog;
import com.siddh.transaction_demo.entity.Order;
import com.siddh.transaction_demo.repository.AuditLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuditLogHandler {

    private final AuditLogRepository auditLogRepository;

    public AuditLogHandler(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    //log audit details(runs in independent transaction)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void auditLogDetails(String action, Order order){
        AuditLog auditLog=new AuditLog();
        auditLog.setOrderId(Long.valueOf(order.getId()));
        auditLog.setAction(action);
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }
}
