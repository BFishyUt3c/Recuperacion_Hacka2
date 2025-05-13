// src/main/java/org/example/recu_hacko/service/InventoryService.java
package org.example.recu_hacko.service;

import org.example.recu_hacko.entidad.Product;
import org.example.recu_hacko.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    private static final Logger logger = LogManager.getLogger(InventoryService.class);
    private final ProductRepository repo;
    private static final int INITIAL_STOCK = 10;

    public InventoryService(ProductRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void reduceStock(List<String> products) {
        for (String name : products) {
            Product p = repo.findById(name)
                    .orElseGet(() -> new Product(name, INITIAL_STOCK));
            p.setStock(p.getStock() - 1);
            repo.save(p);
            logger.info("Stock de '{}' ahora: {}", p.getName(), p.getStock());
        }
    }
}
