package org.example.recu_hacko.listener;

import org.example.recu_hacko.event.OrderCreatedEvent;
import org.example.recu_hacko.service.InventoryService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener implements ApplicationListener<OrderCreatedEvent> {

    private final InventoryService inventoryService;

    public InventoryUpdateListener(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void onApplicationEvent(OrderCreatedEvent event) {
        inventoryService.reduceStock(event.getOrder().getProducts());
    }
}
