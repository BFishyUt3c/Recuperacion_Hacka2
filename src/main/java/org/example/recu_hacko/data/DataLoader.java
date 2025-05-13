package org.example.recu_hacko.data;

import org.example.recu_hacko.entidad.Product;
import org.example.recu_hacko.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadInitialStock(ProductRepository repo) {
        return args -> {
            for (String name : List.of("lapiz", "cuaderno")) {
                if (!repo.existsById(name)) {
                    repo.save(new Product(name, 100));
                }
            }
        };
    }
}
