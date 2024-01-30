package com.andpostman.prometheusendpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PrometheusEndpointApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrometheusEndpointApplication.class, args);
    }

}
