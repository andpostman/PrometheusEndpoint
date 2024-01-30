package com.andpostman.prometheusendpoint.component;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.andpostman.prometheusendpoint.service.PrometheusServiceImpl;

@Component
@EnableAsync
@RequiredArgsConstructor
public class NumberScheduler {

    private final PrometheusServiceImpl service;

    @Async
    @Scheduled(fixedRateString = "${scheduler.contract.timeout}")
    public void updateNumber(){
        service.setMetricsData();
    }

}
