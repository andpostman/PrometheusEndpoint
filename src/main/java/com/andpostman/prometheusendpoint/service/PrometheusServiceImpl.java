package com.andpostman.prometheusendpoint.service;

import com.andpostman.prometheusendpoint.properties.Duration;
import com.andpostman.prometheusendpoint.properties.TimeProperties;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class PrometheusServiceImpl implements PrometheusService{

    private long metricsPeriod;
    private final AtomicInteger number;

    @Autowired
    public PrometheusServiceImpl(@Value("${metrics.time.low}") int low,@Value("${metrics.time.high}") int high, MeterRegistry meterRegistry) {
        number = new AtomicInteger();
        meterRegistry.gauge("number", number);
        Duration.LOW.setDuration(low);
        Duration.HIGH.setDuration(high);
        metricsPeriod = low;
    }

    @Override
    public void setMetricsData() {
        log.info("Прошедшее время после старта приложения: " + TimeProperties.getInstance().getTimeDifference());
        if (number.get() == Duration.HIGH.getValue()) {
            setMetricsPeriod(Duration.HIGH, Duration.LOW);
        }
        else {
            setMetricsPeriod(Duration.LOW, Duration.HIGH);
        }
    }

    @Override
    public void setMetricsPeriod(Duration from, Duration to){
        if (TimeProperties.getInstance().getTimeDifference() <= metricsPeriod){
            number.set(from.getValue());
        }
        else {
            metricsPeriod += to.getDuration();
            number.set(to.getValue());
        }
    }




}
