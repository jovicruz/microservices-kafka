package com.jovicruz.rest_kafka.controllers;


import com.jovicruz.rest_kafka.data.OrderData;
import com.jovicruz.rest_kafka.services.EventRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final EventRegisterService eventService;

    @PostMapping("/salva-pedido")
    public ResponseEntity<String> saveOrder(@RequestBody OrderData order){
        eventService.addEvent("SaveOrder", order);
        return ResponseEntity.ok("Success");
    }
}
