package com.petsApp.ordersService.repository;

import com.petsApp.ordersService.entity.OrderReady;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReadyRepository extends JpaRepository<OrderReady,Long> {
}
