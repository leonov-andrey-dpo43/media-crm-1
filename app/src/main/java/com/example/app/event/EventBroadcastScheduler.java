package com.example.app.event;

import com.example.app.websocket.EventDTO;
import com.example.app.event.ReportRepository;
import com.example.app.websocket.WebSocketNotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EventBroadcastScheduler {

    private final ReportRepository repository;
    private final WebSocketNotificationService notificationService;

    public EventBroadcastScheduler(ReportRepository repository,
                                   WebSocketNotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    @Scheduled(fixedRate = 5000)
    public void broadcastAllEvents() {
        var allEvents = repository.findAll().stream()
                .map(event -> new EventDTO(event.getId(), event.getRegion(), event.getText(), event.getPerformer(), event.getEventDate()))
                .toList();

        notificationService.sendAllEvents(allEvents);
    }
}