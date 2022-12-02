package com.petApp.basketService.controller;


import com.petApp.basketService.entity.Order;
import com.petApp.basketService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order order){
        return ResponseEntity.ok(orderService.updateOrder(id,order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok("order deleted");
    }


}
