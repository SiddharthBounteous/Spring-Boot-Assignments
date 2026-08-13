package com.siddh.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

//    @Autowired
//    ProductService productService;

//    @GetMapping("/{id}")
//    public ProductDTO productId(@PathVariable("id") Integer id){
//        return productService.getProduct(id);
//    }
    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Integer id) {
        return "Product fetched with id: " + id;
    }

//    @PostMapping("/addProduct")
//    public int addProduct(@RequestBody ProductDTO productDTO){
//        return productService.addProduct(productDTO);
//    }
}
