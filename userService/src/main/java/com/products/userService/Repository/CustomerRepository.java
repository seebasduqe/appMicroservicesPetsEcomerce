package com.products.userService.Repository;

import com.products.userService.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
