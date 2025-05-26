package com.example.Stock_Service.Service;

import com.example.Base_Domain.dto.orderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumerService {

    @KafkaListener(topics = "Order-Topic", groupId = "stock")
    public void receiveOrder(orderEvent orderEvent){
        System.out.println("Message Received : " + orderEvent.toString());
    }
}
