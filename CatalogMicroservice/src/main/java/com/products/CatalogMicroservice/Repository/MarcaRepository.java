package com.products.CatalogMicroservice.Repository;

import com.products.CatalogMicroservice.Entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
