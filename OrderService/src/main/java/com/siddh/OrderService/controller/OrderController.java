package com.siddh.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    OrderService orderService;
//
//    @GetMapping("/{id}")
//    public ProductDTO getProduct(@PathVariable("id") int id){
//        return orderService.getProduct(id);
//    }
//
//    @PostMapping("/addOrder")
//    public int addOrder(@RequestBody ProductDTO productDTO){
//        return orderService.addOrder(productDTO);
//    }
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable String id){
        //invoke product API
        String response=restTemplate.getForObject("http://localhost:8082/products/"+id,String.class);
        System.out.println("Response from Product API called from order service: "+response);
        return ResponseEntity.ok("order call successful");
    }

}
