package com.example.Email_Service.Service;

import com.example.Base_Domain.dto.orderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceConsumer {

    @KafkaListener(topics = "Order-Topic", groupId = "email")
    public void receiveEmail(orderEvent orderEvent){
        System.out.println("Email Service : " + orderEvent.toString());

    }
}
