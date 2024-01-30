package com.andpostman.prometheusendpoint.service;

import com.andpostman.prometheusendpoint.properties.Duration;

public interface PrometheusService {
    void setMetricsData();
    void setMetricsPeriod(Duration from, Duration to);
}
