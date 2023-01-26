package org.example.aws.mongo.demo.repository;

import org.example.aws.mongo.demo.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {
}