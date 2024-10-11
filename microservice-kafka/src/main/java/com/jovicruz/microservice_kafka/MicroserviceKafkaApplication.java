package com.jovicruz.microservice_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MicroserviceKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceKafkaApplication.class, args);
	}

}
