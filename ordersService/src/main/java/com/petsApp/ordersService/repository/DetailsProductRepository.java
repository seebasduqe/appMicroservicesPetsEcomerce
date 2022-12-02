package com.petsApp.ordersService.repository;

import com.petsApp.ordersService.entity.DetailsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsProductRepository extends JpaRepository<DetailsProduct,Long> {
}
