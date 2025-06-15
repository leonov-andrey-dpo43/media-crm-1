package com.example.app.websocket;

import com.example.app.websocket.DBHealthStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final WebSocketNotificationService notificationService;

    public TestController(WebSocketNotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/test-ws")
    public String testWS() {
        // Отправляем тестовое сообщение всем подписчикам
        DBHealthStatus status = new DBHealthStatus("UP");
        notificationService.sendDBHealthUpdate(status);

        return "Сообщение отправлено через /topic/db-health";
    }
}