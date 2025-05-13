package org.example.recu_hacko.event;

import org.springframework.context.ApplicationEvent;
import org.example.recu_hacko.model.Order;

public class OrderCreatedEvent extends ApplicationEvent {
    private final Order order;

    public OrderCreatedEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
