package com.example.app.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import com.example.app.websocket.DBHealthStatus;
import com.example.app.websocket.EventDTO;
import java.util.List;
import java.util.Map;

@Service
public class WebSocketNotificationService {

    private final SimpMessagingTemplate messagingTemplate;
    
    public WebSocketNotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    
    public void sendEventUpdate(EventDTO event) {
        messagingTemplate.convertAndSend("/topic/events", event);
    }

    public void sendEventDelete(Long eventId) {
        messagingTemplate.convertAndSend("/topic/events-delete", Map.of("id", eventId));
    }

    public void sendAllEvents(List<EventDTO> events) {
        messagingTemplate.convertAndSend("/topic/events-all", events);
    }
    
    public void sendDBHealthUpdate(DBHealthStatus status) {
        messagingTemplate.convertAndSend("/topic/db-health", status);
    }
}