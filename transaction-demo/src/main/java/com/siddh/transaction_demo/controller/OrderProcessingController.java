package com.siddh.transaction_demo.controller;

import com.siddh.transaction_demo.entity.Order;
import com.siddh.transaction_demo.service.OrderProcessingService;
import com.siddh.transaction_demo.service.isolation.ReadCommittedDemo;
import com.siddh.transaction_demo.service.isolation.ReadUncommittedDemo;
import com.siddh.transaction_demo.service.isolation.RepeatableReadDemo;
import com.siddh.transaction_demo.service.isolation.SerializableDemo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderProcessingController {
    private final OrderProcessingService orderProcessingService;
    private final ReadUncommittedDemo readUncommittedDemo;
    private final ReadCommittedDemo readCommittedDemo;
    private final RepeatableReadDemo repeatableReadDemo;
    private final SerializableDemo serializableDemo;

    public OrderProcessingController(OrderProcessingService orderProcessingService, ReadUncommittedDemo readUncommittedDemo, ReadCommittedDemo readCommittedDemo, RepeatableReadDemo repeatableReadDemo, SerializableDemo serializableDemo) {
        this.orderProcessingService = orderProcessingService;
        this.readUncommittedDemo = readUncommittedDemo;
        this.readCommittedDemo = readCommittedDemo;
        this.repeatableReadDemo = repeatableReadDemo;
        this.serializableDemo = serializableDemo;
    }

    @PostMapping
    public ResponseEntity<?>placeOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderProcessingService.placeAnOrder(order));
    }

    @GetMapping("/isolation")
    public String testIsolation() throws InterruptedException {
//        readUncommittedDemo.testReadUncommitted(1);
//        readCommittedDemo.testReadCommitted(1);
//        repeatableReadDemo.testRepeatableRead(1);
        serializableDemo.testSerializableIsolation(1);
        return "Success";
    }
}
