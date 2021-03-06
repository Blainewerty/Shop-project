package ru.milov.shoptest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.milov.shoptest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
