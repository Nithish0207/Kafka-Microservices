package com.example.Base_Domain.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private String name;
    private int quantity;
    private double price;
}
