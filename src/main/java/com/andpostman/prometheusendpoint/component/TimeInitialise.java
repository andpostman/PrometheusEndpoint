package com.andpostman.prometheusendpoint.component;

import com.andpostman.prometheusendpoint.properties.TimeProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class TimeInitialise{

    @PostConstruct
    private void initialiseTime() {
        TimeProperties timeInitialise = TimeProperties.getInstance();
        log.info("Start time: " + timeInitialise.getDateTime());
    }
}
