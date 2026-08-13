package com.siddh.transaction_demo.service;

import com.siddh.transaction_demo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRecommendationHandler {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Product> getRecommendations(){

        List<Product> recommendations=new ArrayList<>();

        recommendations.add(new Product(101,"Wireless Speaker",1000.0,4));
        recommendations.add(new Product(102,"Gaming Mouse",1500.0,5));
        recommendations.add(new Product(103,"LCD",8000.0,6));
        recommendations.add(new Product(104,"Keyboard",1200.0,4));

        System.out.println("Recommendation fetched for customer");
        return recommendations;
    }
}
