package com.jovicruz.rest_kafka.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationListener {

    @KafkaListener(topics = "ConfirmationTopic", groupId = "ApiServiceGroup")
    public void listenConfirmation(ConsumerRecord<String, String> record) {
        //Receives the saving confirmation
        String confirmationMessage = record.value();
        System.out.println("Order Saved : " + confirmationMessage);
    }
}