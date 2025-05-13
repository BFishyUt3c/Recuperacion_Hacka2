package org.example.recu_hacko.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.example.recu_hacko.event.OrderCreatedEvent;

@Component
public class AuditLogListener implements ApplicationListener<OrderCreatedEvent> {
    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @Override
    public void onApplicationEvent(OrderCreatedEvent event) {
        logger.info("Audit log – Pedido procesado: {}", event.getOrder().getId());
    }
}
