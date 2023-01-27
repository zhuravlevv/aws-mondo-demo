package org.example.aws.mongo.demo.controller;

import org.example.aws.mongo.demo.AppTestConfiguration;
import org.example.aws.mongo.demo.entity.Order;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Iterator;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Import(AppTestConfiguration.class)
class OrderIT {

    @Autowired
    protected WebTestClient webTestClient;

    @Test
    void getAllOrdersIT () {
        Order order = new Order();
        order.setBuyer("Test buyer");
        order.setPrice(10D);
        order.setQuantity(1);
        Order createdOrder = webTestClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/orders")
                        .build())
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(order))
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(201)
                .returnResult(Order.class)
                .getResponseBody()
                .blockFirst();
        Assertions.assertNotNull(createdOrder);
        Assertions.assertNotNull(createdOrder.getId());
        Iterator<Order> orders = webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/orders")
                        .build())
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON)
                .exchange()
                .returnResult(Order.class)
                .getResponseBody()
                .toIterable()
                .iterator();
        int num = 0;
        while (orders.hasNext()){
            num++;
            Order next = orders.next();
            System.out.println(next);
        }
        System.out.println("Responses - " + num);
    }
}