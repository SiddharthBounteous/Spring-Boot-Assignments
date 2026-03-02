package com.siddh.OMS.controller;

import com.siddh.OMS.dto.OrderRequestDTO;
import com.siddh.OMS.model.Order;
import com.siddh.OMS.model.OrderStatus;
import com.siddh.OMS.repository.OrderRepository;
import com.siddh.OMS.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository){
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders")
    public ResponseEntity<Map<String,String>>placeOrder(@RequestBody OrderRequestDTO incomingRequest){
        Order newOrder=new Order(
                incomingRequest.getAccountId(),
                incomingRequest.getSymbol(),
                incomingRequest.getQuantity(),
                incomingRequest.getPrice(),
                incomingRequest.getSide()
        );

        orderService.placeOrder(newOrder);
        Map<String,String>response=new LinkedHashMap<>();
        response.put("message","Order received and is processing in the background.");
        response.put("orderId",newOrder.getOrderId());
        response.put("status",newOrder.getStatus().name());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/analytics")
    public ResponseEntity<Map<String, Object>>getAnalytics(){
        List<Order> orders=orderRepository.findAllOrdersList();
        Map<String,Object>stats=new LinkedHashMap<>();

        //total order amount
        double totalAmount=orders.stream()
                .mapToDouble(o->o.getPrice()*o.getQuantity())
                .sum();
        stats.put("TotalOrderAmount",totalAmount);

        //total buy vs sell
        Map<String,Long>buyVsSell=orders.stream()
                .collect(Collectors.groupingBy(Order::getSide,Collectors.counting()));
        stats.put("TotalBuyVsSell",buyVsSell);

        //Group Order by Status
        Map<OrderStatus,Long>ordersByStatus=orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,Collectors.counting()));
        stats.put("OrdersByStatus",ordersByStatus);

        //Top Customer by volume
        String topCustomer=orders.stream()
                .collect(Collectors.groupingBy(Order::getAccountId,
                        Collectors.summingDouble(o->o.getPrice()*o.getQuantity())))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Customers Yet");

        stats.put("TopCustomer",topCustomer);

        return ResponseEntity.ok(stats);
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>>getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAllOrdersList());
    }
}
