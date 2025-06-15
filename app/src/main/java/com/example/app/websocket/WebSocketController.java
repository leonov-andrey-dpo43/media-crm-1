package com.example.app.websocket;

import com.example.app.healthcheck.HealthCheckService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final WebSocketNotificationService notificationService;
    private final HealthCheckService healthCheckService;

    public WebSocketController(WebSocketNotificationService notificationService,
                               HealthCheckService healthCheckService) {
        this.notificationService = notificationService;
        this.healthCheckService = healthCheckService;
    }

    @MessageMapping("/request-health")
    public void requestHealthStatus() {
        DBHealthStatus status = healthCheckService.checkContainerAndDB();
        notificationService.sendDBHealthUpdate(status);
    }
}