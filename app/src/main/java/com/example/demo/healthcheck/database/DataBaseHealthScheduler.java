package com.example.demo.healthcheck.database;

import com.example.demo.healthcheck.database.DataBaseHealthService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataBaseHealthScheduler {

    private final DataBaseHealthService healthService;

    public DataBaseHealthScheduler(DataBaseHealthService service) {
        this.healthService = service;
    }

    @Scheduled(fixedRate = 5000)
    public void updateHealthStatus() {
        healthService.refreshStatus(); 
    }
}