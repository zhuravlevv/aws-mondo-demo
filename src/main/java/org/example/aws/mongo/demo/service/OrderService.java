package org.example.aws.mongo.demo.service;

import lombok.RequiredArgsConstructor;
import org.example.aws.mongo.demo.entity.Order;
import org.example.aws.mongo.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}