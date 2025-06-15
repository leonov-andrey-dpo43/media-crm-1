package com.example.app.healthcheck;

import com.example.app.websocket.DBHealthStatus;
import com.example.app.websocket.WebSocketNotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckScheduler {

    private final HealthCheckService healthCheckService;
    private final WebSocketNotificationService webSocketNotificationService;

    private DBHealthStatus lastStatus;

    public HealthCheckScheduler(HealthCheckService healthCheckService,
                                WebSocketNotificationService webSocketNotificationService) {
        this.healthCheckService = healthCheckService;
        this.webSocketNotificationService = webSocketNotificationService;
    }

    @Scheduled(fixedRate = 5000)
    public void checkDBHealth() {
        var currentStatus = healthCheckService.checkContainerAndDB();

        if (lastStatus == null || !lastStatus.equals(currentStatus)) {
            webSocketNotificationService.sendDBHealthUpdate(currentStatus);
            lastStatus = currentStatus;
        }
    }
}