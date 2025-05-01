package com.microservices.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class OrderController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/orders")
    public String getOrders() {
        String users = webClientBuilder.build()
            .get()
            .uri("http://localhost:8081/users")
            .retrieve()
            .bodyToMono(String.class)
            .block();

        return "Orders from OrderService and Users: " + users;
    }
}