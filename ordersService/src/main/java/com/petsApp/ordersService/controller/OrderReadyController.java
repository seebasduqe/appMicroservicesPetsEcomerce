package com.petsApp.ordersService.controller;


import com.petsApp.ordersService.entity.OrderReady;
import com.petsApp.ordersService.service.OrderReadyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_ready")
public class OrderReadyController {


    @Autowired
    OrderReadyService orderReadyService;

    @GetMapping
    public ResponseEntity<List<OrderReady>> getAll(){
        return ResponseEntity.ok(orderReadyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderReady> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderReadyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OrderReady> saveOrderReady(@RequestBody OrderReady orderReady){
        return ResponseEntity.ok(orderReadyService.saveOrderReady(orderReady));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderReady> updateOrderReady(@PathVariable("id") Long id, @RequestBody OrderReady orderReady){
        return ResponseEntity.ok(orderReadyService.updateOrderReady(id,orderReady));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderReady(@PathVariable("id") Long id){
        orderReadyService.deleteOrderReady(id);
        return ResponseEntity.ok("deleted order");
    }

}
