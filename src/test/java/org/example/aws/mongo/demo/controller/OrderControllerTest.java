package org.example.aws.mongo.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getAllOrders() {

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("")
                        .build());

    }
}