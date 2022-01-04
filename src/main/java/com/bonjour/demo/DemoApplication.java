package com.bonjour.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.bonjour.demo")
public class DemoApplication {
    public static void main(String[] args) {
        // 解决netty跟elasticsearch冲突
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(DemoApplication.class, args);
    }

}
