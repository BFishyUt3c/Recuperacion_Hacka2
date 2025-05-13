package org.example.recu_hacko.controller;

import org.example.recu_hacko.event.OrderCreatedEvent;
import org.example.recu_hacko.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ApplicationEventPublisher publisher;

    @Autowired
    public OrderController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        publisher.publishEvent(new OrderCreatedEvent(this, order));
        return ResponseEntity.ok().build();
    }
}