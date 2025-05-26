package com.example.Order_Service.Controller;

import com.example.Base_Domain.dto.Order;
import com.example.Base_Domain.dto.orderEvent;
import com.example.Order_Service.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/place/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity placeOrder(@RequestBody Order order){

        order.setId(UUID.randomUUID().toString());

        orderEvent orderEvent = new orderEvent();
        orderEvent.setMessage("Order is pending");
        orderEvent.setStatus("PENDING");
        orderEvent.setOrder(order);

        orderService.publishMessage(orderEvent);
        return new ResponseEntity<>(Map.of("Message","Message sent to kafka cluster"), HttpStatus.OK);
    }
}
