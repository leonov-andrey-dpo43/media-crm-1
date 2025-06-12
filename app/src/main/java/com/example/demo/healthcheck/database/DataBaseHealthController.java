package com.example.demo.healthcheck.database;

import com.example.demo.healthcheck.database.DataBaseHealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBaseHealthController {

    private final DataBaseHealthService healthService;

    public DataBaseHealthController(DataBaseHealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/api/health")
    public HealthStatus checkHealth() {
        boolean isUp = healthService.isDatabaseReachable();
        return new HealthStatus(isUp ? "UP" : "DOWN", isUp ? null : "Database not reachable");
    }

    // Простой DTO для ответа
    public record HealthStatus(String status, String reason) {}
}
