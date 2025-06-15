package com.example.app.healthcheck;

import com.example.app.websocket.DBHealthStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HealthRestController {

    private final HealthCheckService healthCheckService;

    public HealthRestController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping("/health")
    public DBHealthStatus getHealth() {
        return healthCheckService.checkContainerAndDB();
    }
}