package com.example.Base_Domain.dto;

import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderEvent {

    private String message;
    private String status;
    private Order order;
}
