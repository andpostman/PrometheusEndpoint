package com.andpostman.prometheusendpoint.properties;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeProperties {

    private static TimeProperties initialiseTime;
    private final LocalDateTime dateTime;

    private TimeProperties() {
        dateTime = LocalDateTime.now();
    }

    public static synchronized TimeProperties getInstance() {
        if (initialiseTime == null) {
            initialiseTime = new TimeProperties();
        }
        return initialiseTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public long getTimeDifference() {
        return Duration.between(getDateTime(), LocalDateTime.now()).toSeconds();
    }
}
