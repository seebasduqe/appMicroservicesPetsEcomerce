package com.products.CatalogMicroservice.Repository;

import com.products.CatalogMicroservice.Entity.Pet_type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pet_typeRepository extends JpaRepository <Pet_type, Long> {
}
