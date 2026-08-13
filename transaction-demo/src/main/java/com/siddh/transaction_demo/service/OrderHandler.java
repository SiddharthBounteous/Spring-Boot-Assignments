package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.Order;
import com.siddh.transaction_demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderHandler {
    private final OrderRepository orderRepository;

    public OrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
