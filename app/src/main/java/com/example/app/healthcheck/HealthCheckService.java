package com.example.app.healthcheck;

import com.example.app.websocket.DBHealthStatus;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    private final DataBaseHealthService dataBaseHealthService;

    public HealthCheckService(DataBaseHealthService dataBaseHealthService) {
        this.dataBaseHealthService = dataBaseHealthService;
    }

    public DBHealthStatus checkContainerAndDB() {
        boolean isUp = isDatabaseReachable();
       

        return new DBHealthStatus(isUp ? "UP" : "DOWN");
    }

    private boolean isDatabaseReachable() {
        try {
            return dataBaseHealthService.isDatabaseReachable(); 
        } catch (Exception e) {
            return false;
        }
    }
}