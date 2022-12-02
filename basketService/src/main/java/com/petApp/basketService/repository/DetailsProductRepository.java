package com.petApp.basketService.repository;

import com.petApp.basketService.entity.DetailsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsProductRepository extends JpaRepository<DetailsProduct,Long> {
}
