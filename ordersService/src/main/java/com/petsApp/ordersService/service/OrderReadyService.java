package com.petsApp.ordersService.service;

import com.petsApp.ordersService.entity.OrderReady;
import com.petsApp.ordersService.repository.OrderReadyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderReadyService {

    @Autowired
    OrderReadyRepository orderReadyRepository;

    public List<OrderReady> getAll(){
        return orderReadyRepository.findAll();
    }

    public OrderReady getById(Long id){
        return orderReadyRepository.findById(id).orElse(null);
    }

    public OrderReady saveOrderReady(OrderReady orderReady){
        return orderReadyRepository.save(orderReady);
    }

    public OrderReady updateOrderReady(Long id, OrderReady orderReady){
        Optional<OrderReady> orderReadyOptional = orderReadyRepository.findById(id);
        if(orderReadyOptional.isEmpty()){
            return null;
        }
        orderReady.setId(orderReadyOptional.get().getId());
        return orderReadyRepository.save(orderReady);
    }

    public void deleteOrderReady(Long id){
        orderReadyRepository.deleteById(id);
    }
}
