package com.petApp.basketService.service;

import com.petApp.basketService.entity.Order;
import com.petApp.basketService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order getById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order){
        kafkaTemplate.send("topicBasket", order);
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isEmpty()){
            return null;
        }
        order.setId(orderOptional.get().getId());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
