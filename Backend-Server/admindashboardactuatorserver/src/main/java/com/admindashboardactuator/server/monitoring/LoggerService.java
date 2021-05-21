package com.admindashboardactuator.server.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LoggerService implements HealthIndicator {

    private final String Logger_SERVICE="Logger Service";
    @Override
    public Health health() {
        if(isLoggerServiceGood()){
            return Health.up().withDetail(Logger_SERVICE,"Logger service is running").build();
        }
        return Health.down().withDetail(Logger_SERVICE,"Logger service is not available").build();
    }

    private boolean isLoggerServiceGood(){
        return true;
    }
}
