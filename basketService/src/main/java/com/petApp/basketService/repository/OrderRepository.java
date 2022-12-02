package com.petApp.basketService.repository;

import com.petApp.basketService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
