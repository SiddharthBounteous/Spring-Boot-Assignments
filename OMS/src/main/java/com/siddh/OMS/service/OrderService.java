package com.siddh.OMS.service;

import com.siddh.OMS.config.CustomRejectHandler;
import com.siddh.OMS.config.CustomThreadFactory;
import com.siddh.OMS.model.Order;
import com.siddh.OMS.model.OrderStatus;
import com.siddh.OMS.repository.OrderRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ExecutorService executorService;
    private static final String LOG_FILE="orders_log.txt";

    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
        this.executorService=new ThreadPoolExecutor(3,5,10, TimeUnit.MINUTES,new ArrayBlockingQueue<>(3),new CustomThreadFactory(),new CustomRejectHandler());
    }

    public void placeOrder(Order order){
        orderRepository.saveOrder(order);
        executorService.submit(()->processOrder(order));
    }

    public void processOrder(Order order){
        try{
            Thread.sleep(1000);
            order.setStatus(OrderStatus.COMPLETED);
            orderRepository.saveOrder(order);
            writeToFile(order);
        } catch (InterruptedException e){
            order.setStatus(OrderStatus.FAILED);
            orderRepository.saveOrder(order);
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void writeToFile(Order order){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(LOG_FILE,true))){
            String logEntry=String.format("Time: %s | OrderID: %s | Account: %s | %s %d %s @ $%.2f | Status: %s\n",
                    order.getTimestamp(), order.getOrderId(), order.getAccountId(),
                    order.getSide(), order.getQuantity(), order.getSymbol(), order.getPrice(), order.getStatus());

            writer.write(logEntry);
        }
        catch (IOException ex){
            System.err.println("Failed to write log to file: "+ex.getMessage());
        }
    }

    @PreDestroy
    public void shutdown(){
        executorService.shutdown();
    }
}

