package com.products.CatalogMicroservice.Repository;

import com.products.CatalogMicroservice.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
