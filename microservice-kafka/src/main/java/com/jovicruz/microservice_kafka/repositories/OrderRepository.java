package com.jovicruz.microservice_kafka.repositories;

import com.jovicruz.microservice_kafka.data.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, Long> {

}
