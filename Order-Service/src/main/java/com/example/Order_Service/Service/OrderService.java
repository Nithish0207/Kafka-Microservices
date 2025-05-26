package com.example.Order_Service.Service;

import com.example.Base_Domain.dto.Order;
import com.example.Base_Domain.dto.orderEvent;
import com.example.Order_Service.Constant.topicDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    @Autowired
    KafkaTemplate<String,orderEvent> kafkaTemplate;

    public String publishMessage(orderEvent orderEvent){
        Message<orderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topicDetails.TopicName)
                .build();

        kafkaTemplate.send(message);
        System.out.println("Message --> " + message);
        return "Message published to kafka cluster";
    }
}
