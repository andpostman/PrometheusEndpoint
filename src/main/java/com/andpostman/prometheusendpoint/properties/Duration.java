package com.andpostman.prometheusendpoint.properties;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Duration {

    LOW(50, 0),
    HIGH(70, 0);

    private int value;
    private int duration;

    Duration(int value, int duration) {
        this.value = value;
        this.duration = duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
