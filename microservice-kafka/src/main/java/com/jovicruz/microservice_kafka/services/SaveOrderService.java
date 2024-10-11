package com.jovicruz.microservice_kafka.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jovicruz.microservice_kafka.data.OrderData;
import com.jovicruz.microservice_kafka.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveOrderService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    OrderRepository repository;

    @KafkaListener(topics = "SaveOrder", groupId = "MicroserviceSaveOrder")
    private void execute(ConsumerRecord<String, String> record){
        log.info("Key: {}", record.key());
        log.info("Header: {}", record.headers());
        log.info("Partition: {}", record.partition());

        String strData = record.value();

        ObjectMapper mapper = new ObjectMapper();
        OrderData order = null;

        try {
            order = mapper.readValue(strData, OrderData.class);
        } catch (JsonProcessingException ex) {
            log.error("Error while converting dado: {}{}", strData, ex);
            return;
        }

        repository.save(order);
        System.out.println("PRINT DE TODAS AS ORDERS: " + repository.findAll());
        kafkaTemplate.send("ConfirmationTopic", "Order processed: " + order);

    }
}
