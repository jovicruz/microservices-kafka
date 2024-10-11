package com.jovicruz.rest_kafka.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderData {

    private String code;
    private String nameOrder;
    private BigDecimal value;
}
