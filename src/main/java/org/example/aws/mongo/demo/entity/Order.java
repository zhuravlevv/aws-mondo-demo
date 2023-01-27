package org.example.aws.mongo.demo.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
@ToString
@EqualsAndHashCode
public class Order {
    @Id
    private String id;
    private String buyer;
    private Double price;
    private int quantity;
}