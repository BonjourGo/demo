package com.bonjour.demo.test.common.mq;

import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * @authur tc
 * @date 2021/12/6 17:58
 */
@Configuration
public class RabbitMQConfig {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("3000");
        BigDecimal bigDecimal1 = new BigDecimal("3000.00");
        System.out.println(bigDecimal.equals(bigDecimal1));
    }
}
