package org.example.recu_hacko.repository;

import org.example.recu_hacko.entidad.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
